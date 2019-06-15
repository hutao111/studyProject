package org.hutao.projectapi.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author hutao
 * @since 2019-06-11
 */
@Data
@Api(tags = "Classify", description = "")
@TableName("classify")
public class DocumentClassify extends Model<DocumentClassify> {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "主键")
    @TableId("id")
    private Long id;

    @ApiModelProperty(value = "分类父id   一级分类则为0")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "顶层节点id   一级分类则为0")
    @TableField("root_id")
    private Long rootId;

    @ApiModelProperty(value = "分类层级")
    @TableField("layer")
    private Integer layer;

    @ApiModelProperty(value = "分类名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "分类编码")
    @TableField("code")
    private Integer code;

    @ApiModelProperty(value = "分类描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "是否已删除 0：未删除、1：已删除 默认为0")
    @TableField("deleted")
    private Integer deleted;


    @ApiModelProperty(value = "创建者id")
    @TableField(value = "create_by_id", fill = FieldFill.INSERT)
    private Long createById;

    @ApiModelProperty(value = "创建者名称")
    @TableField(value = "create_by_name", fill = FieldFill.INSERT)
    private String createByName;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新者id")
    @TableField(value = "update_by_id", fill = FieldFill.INSERT)
    private Long updateById;

    @ApiModelProperty(value = "修改者名称")
    @TableField(value = "update_by_name", fill = FieldFill.INSERT)
    private String updateByName;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT)
    private Date updateTime;

    @ApiModelProperty(value = "站点id")
    @TableField("site_id")
    private Long siteId;

    @ApiModelProperty(value = "组织id")
    @TableField("org_id")
    private Long orgId;

    @ApiModelProperty(value = "企业id")
    @TableField("company_id")
    private Long companyId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
