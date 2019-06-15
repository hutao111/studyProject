package org.hutao.projectapi.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@Api(value = "资料查询所需参数")
public class DocumentParamVo {


    @ApiModelProperty(value = "分类id")
    private Long classifyId;

    @ApiModelProperty(value = "资料名称或编码")
    private String name;

    @ApiModelProperty(value = "资料类型")
    private Integer type;

    @ApiModelProperty(value = "分页页码")
    private Integer pageNo = 1;

    @ApiModelProperty(value = "分页行数")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "需要过滤的ids")
    private List<Long> filerDocumentIds;
}
