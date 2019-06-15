package org.hutao.projectapi.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author hutao
 * @since 2019-06-11
 */
@Data
@Api(tags = "ClassifyVo", description = "")

public class DocumentClassifyVo implements Serializable {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "分类父id   一级分类则为0")
    private Long parentId;

    @ApiModelProperty(value = "顶层节点id   一级分类则为0")
    private Long rootId;

    @ApiModelProperty(value = "分类层级")
    private Integer layer;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "分类编码")
    private Integer code;

    @ApiModelProperty(value = "分类描述")

    private String description;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "编码名称  站点内从1000开始自增，显示为1000-一级分类   以 code+name 组成")
    private String codeName;

}
