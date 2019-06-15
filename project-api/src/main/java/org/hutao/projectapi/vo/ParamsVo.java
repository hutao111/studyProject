package org.hutao.projectapi.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(tags = "ParamsVo", description = "储存返回信息")
public class ParamsVo {

    @ApiModelProperty("错误信息")
    private String errorMsg;

    @ApiModelProperty("是否成功")
    private Boolean success;

    @ApiModelProperty("返回数据")
    private String successData;
}
