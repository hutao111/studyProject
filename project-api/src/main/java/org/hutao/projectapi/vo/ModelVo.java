package org.hutao.projectapi.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("参数Vo")
public class ModelVo {

    @ApiModelProperty(value = "相应泛型id主键   必传！！！")
    private Long id;

    @ApiModelProperty(value = "是否强制删除")
    private Boolean needDelete;


}
