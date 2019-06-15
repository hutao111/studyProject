package org.hutao.projectservice.application.controller;


import org.hutao.projectapi.domain.DocumentClassify;
import org.hutao.projectapi.vo.DocumentClassifyTreeVo;
import org.hutao.projectapi.vo.ParamsVo;
import org.hutao.projectapi.vo.SecondClassifyVo;
import org.hutao.projectservice.application.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hutao
 * @since 2019-06-11
 */
@RestController
@RequestMapping("/classify")
public class ClassifyComtroller {

    @Autowired
    private ClassifyService classifyService;


    @PostMapping("/save")
    public ParamsVo save(@RequestBody DocumentClassify classify) {

        ParamsVo paramsVo = new ParamsVo();

        if (null != classify.getParentId()) {
            DocumentClassify classifyTem = classifyService.getById(classify.getParentId());
            if (null != classifyTem) {
                if (classifyTem.getLayer() == 3) {
                    paramsVo.setErrorMsg("分类最多为三级！");
                    paramsVo.setSuccess(false);
                    return paramsVo;
                }
            }
        }
        if (classifyService.save(classify)) {
            paramsVo.setSuccess(true);
            paramsVo.setErrorMsg(null);
        }
        return paramsVo;
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody DocumentClassify classify) {

        if (classifyService.update(classify)) {
            return true;
        }
        return false;
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody DocumentClassify classify) {

        if (classifyService.delete(classify)) {
            return true;
        }
        return false;
    }

    /**
     * 查询 树形结构的分类
     *
     * @param showThirdClassfy 是否显示 第三级分类
     * @return
     */
    @GetMapping("/query")
    public List<DocumentClassifyTreeVo> queryClassfy(@RequestParam("showThirdClassfy") Boolean showThirdClassfy) {
        List<DocumentClassifyTreeVo> classifyTreeVos = classifyService.queryClassifyList();
        ;
        if (!showThirdClassfy) {
            classifyTreeVos.forEach(a -> {
                List<SecondClassifyVo> children = a.getChildren();
                children.forEach(b -> {
                    b.setChildren(new ArrayList<>());
                });
            });
        }

        return classifyTreeVos;
    }

    /**
     * 判断能否添加子分类
     *
     * @param id
     * @return
     */
    @GetMapping("/canSave")
    public Boolean canSave(@RequestParam(value = "id") Long id) {
        DocumentClassify classify = classifyService.getById(id);
        if (classify != null) {
            if (classify.getLayer() == 3) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/queryById")
    public DocumentClassify queryById(@RequestParam(value = "id") Long id) {
        return classifyService.getById(id);
    }
}