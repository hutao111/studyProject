package org.hutao.projectservice.application.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
@Document(indexName = "hh",type = "classify")
public class Classify {

    @Id
    private String id;

    @ApiModelProperty(value = "分类父id   一级分类则为0")
    private String parentId;

    @ApiModelProperty(value = "顶层节点id   一级分类则为0")
    private String rootId;

    @ApiModelProperty(value = "分类层级")
    private Integer layer;

    @ApiModelProperty(value = "分类名称")
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String name;

    @ApiModelProperty(value = "分类编码")
    private Integer code;

    @ApiModelProperty(value = "分类描述")
    private String description;

    @ApiModelProperty(value = "是否已删除 0：未删除、1：已删除 默认为0")
    private Integer deleted;

    @ApiModelProperty(value = "站点id")
    private String siteId;

    @ApiModelProperty(value = "组织id")
    private String orgId;

    @ApiModelProperty(value = "企业id")
    private String companyId;



}
