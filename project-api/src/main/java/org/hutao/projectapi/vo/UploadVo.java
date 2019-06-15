package org.hutao.projectapi.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(value = "上传资料vo")
public class UploadVo {

    @ApiModelProperty(value = "资料id")
    private Long id;

    @ApiModelProperty(value = "分类id ")
    private Long classfyId;

    @ApiModelProperty(value = "下载路径 ")
    private String url;

    @ApiModelProperty(value = "资料名称 ")
    private String name;

    @ApiModelProperty(value = "文件名称 " )
    private String fileName;

    @ApiModelProperty(value = "文件后缀名称")
    private String suffixName;

    @ApiModelProperty(value = "资料大小")
    private Double fileSize;
}
