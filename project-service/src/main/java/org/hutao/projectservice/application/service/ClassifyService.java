package org.hutao.projectservice.application.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hutao.projectapi.domain.DocumentClassify;
import org.hutao.projectapi.vo.DocumentClassifyTreeVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hutao
 * @since 2019-06-11
 */
public interface ClassifyService extends IService<DocumentClassify> {

    public boolean save(DocumentClassify classify);

    public Boolean update(DocumentClassify classify);

    public Boolean delete(DocumentClassify classify);

    public List<DocumentClassifyTreeVo> queryClassifyList();


    public Boolean haveChildrenClassify(Long ClassifyId);

}
