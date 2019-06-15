package org.hutao.projectservice.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hutao.projectapi.domain.DocumentClassify;
import org.hutao.projectapi.vo.DocumentClassifyTreeVo;
import org.hutao.projectapi.vo.DocumentClassifyVo;
import org.hutao.projectapi.vo.SecondClassifyVo;
import org.hutao.projectservice.application.mapper.ClassifyMapper;
import org.hutao.projectservice.application.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.IdGenerator;

import java.util.*;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hutao
 * @since 2019-06-11
 */
@Service
@Transactional
public class ClassifyServiceImple extends ServiceImpl<ClassifyMapper, DocumentClassify> implements ClassifyService {


    @Override
    public boolean save(DocumentClassify classify) {

        Long id = classify.getId();
        Long parentId = classify.getParentId();
        Long rootId = classify.getRootId();
        Date curentDate = new Date();

        if (null == id) {
            //id为null，进行插入操作
            classify.setId(new Date().getTime());
            classify.setCompanyId(1314l);
            classify.setSiteId(1314l);
            classify.setOrgId(1314l);
            classify.setCreateByName("shyz");
            classify.setCreateById(1314l);
            classify.setCreateTime(curentDate);
            classify.setDeleted(0);

            //parentId、rootId都为0，一级分类
            //parentId不为0，rootId为0，二级分类
            //parentId、rootId都不为0，三级分类
            if (parentId != 0) {
                if (rootId != 0) {
                    //该新建分类为三级分类
                    classify.setLayer(3);
                } else {
                    //该新建分类为二级分类
                    classify.setLayer(2);
                    classify.setRootId(parentId);
                }
            } else {
                //该新建分类为一级分类
                classify.setParentId(0l);
                classify.setRootId(0l);
                classify.setLayer(1);
                //完整的分类编码=为“code--name” code 只存储数字部分
                Integer code = this.baseMapper.queryMaxCode(1314l, 1314l, 1314l);
                code = (code == null ? 999 : code) + 1;
                classify.setCode(code);
            }

            try {
                this.baseMapper.insert(classify);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return true;
        }
        return false;
    }

    @Override
    public Boolean update(DocumentClassify classify) {

        Date curentDate = new Date();
        if (null != classify) {
            classify.setUpdateTime(curentDate);
            classify.setUpdateByName("shyz");
            classify.setUpdateById(1314l);
            try {
                this.baseMapper.updateById(classify);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @CacheEvict(value = "hutao",key = "1")
    @Override
    public Boolean delete(DocumentClassify classify) {
        classify.setDeleted(1);
        try {
            this.baseMapper.updateById(classify);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Cacheable(cacheNames = "hutao",key = "1")
    @Override
    public List<DocumentClassifyTreeVo> queryClassifyList() {


        System.out.println("进行了查询操作！");
        List<DocumentClassifyTreeVo> classifyTreeVos = new ArrayList<>();
        List<DocumentClassifyVo> classifyVos = this.baseMapper.queryClassifyTree(1314l, 1314l, 1314l);
        if (!CollectionUtils.isEmpty(classifyVos)) {
            //储存第一级分类  <id ,对应的VO>
            Map<Long, DocumentClassifyTreeVo> rootClassifyMap = new HashMap<>();
            //储存第二级分类 《id，对应的vo》
            Map<Long, SecondClassifyVo> secondClassifyMap = new HashMap<>();
            for (DocumentClassifyVo vo : classifyVos) {
                if (vo.getLayer() == 1) {
                    vo.setCodeName(vo.getCode() + "--" + vo.getName());
                    DocumentClassifyTreeVo classifyTreeVo = new DocumentClassifyTreeVo();
                    classifyTreeVo.setClassifyVo(vo);
                    classifyTreeVos.add(classifyTreeVo);
                    if (!rootClassifyMap.containsKey(vo.getId())) {
                        rootClassifyMap.put(vo.getId(), classifyTreeVo);
                    }
                }
            }
            for (DocumentClassifyVo vo : classifyVos) {
                if (vo.getLayer() == 2) {
                    if (null != rootClassifyMap.get(vo.getParentId())) {
                        DocumentClassifyTreeVo classifyTreeVo = rootClassifyMap.get(vo.getParentId());
                        if (null != classifyTreeVo) {
                            SecondClassifyVo secondClassifyVo = new SecondClassifyVo();
                            secondClassifyVo.setClassifyVo(vo);
                            classifyTreeVo.getChildren().add(secondClassifyVo);
                            if (!secondClassifyMap.containsKey(vo.getId())) {
                                secondClassifyMap.put(vo.getId(), secondClassifyVo);
                            }
                        }
                    }
                }

            }
            for (DocumentClassifyVo vo : classifyVos) {
                if (vo.getLayer() == 3) {
                    if (null != secondClassifyMap.get(vo.getParentId())) {
                        SecondClassifyVo secondClassifyVo = secondClassifyMap.get(vo.getParentId());
                        if (null != secondClassifyVo) {
                            secondClassifyVo.setClassifyVo(vo);
                            secondClassifyVo.getChildren().add(vo);

                        }
                    }
                }

            }
        }
        return classifyTreeVos;
    }


    @Override
    public Boolean haveChildrenClassify(Long classifyId) {

        Integer count = this.baseMapper.haveChildrenClassify(classifyId, 1314l, 1314l, 1314l);
        if (count > 0) {
            return true;
        } else
            return false;

    }


}
