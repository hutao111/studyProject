package org.hutao.projectapi.vo;

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
@Api(tags = "DocumentVo", description = "")
public class DocumentVo implements Serializable {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "序号")
    private Integer no;

    @ApiModelProperty(value = "分类id")
    private Long classifyId;

    @ApiModelProperty(value = "资料名称")
    private String name;

    @ApiModelProperty(value = "资料编码")
    private Integer code;

    @ApiModelProperty(value = "资料编码名称   以create_time(“yyyyMMdd”)+code组成")
    private String codeName;

    @ApiModelProperty(value = "下载次数")
    private Integer downloadTimes;

    @ApiModelProperty(value = "资料大小")
    private Double fileSize;

    @ApiModelProperty(value = "资料大小名称")
    private String fileSizeName;

    @ApiModelProperty(value = "资料类型  ：1、文档；2、图片；3、音频；4、视频；5、其他")
    private Integer type;

    @ApiModelProperty(value = "资料类型名称  ：1、文档；2、图片；3、音频；4、视频；5、其他")
    private String typeName;

    @ApiModelProperty(value = "下载路径")
    private String url;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "上传人名称")
    private String createAccounName;

}
