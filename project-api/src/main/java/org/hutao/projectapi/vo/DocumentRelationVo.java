package org.hutao.projectapi.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author hutao
 * @since 2019-06-11
 */
@Data
@Api(tags = "DocumentRelationVo", description = "")

public class DocumentRelationVo {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "资料ids")
    private List<Long> documentIds;

    @ApiModelProperty(value = "关联模块类型：1、课程；2、培训项目")
    private Integer relationType;

    @ApiModelProperty(value = "关联的模块id")
    private Long relationId;

    @ApiModelProperty(value = "是否上移 true:上移 false:下移")
    private Boolean moveUp;


}
