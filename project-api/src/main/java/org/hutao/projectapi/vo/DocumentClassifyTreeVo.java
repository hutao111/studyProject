package org.hutao.projectapi.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Api("储存第一层分类")
@Data
public class DocumentClassifyTreeVo implements Serializable {

    @ApiModelProperty(value = "分类信息")
    private DocumentClassifyVo classifyVo;

    @ApiModelProperty(value = "储存第二层分类")
    private List<SecondClassifyVo> children = new ArrayList<>();

}
