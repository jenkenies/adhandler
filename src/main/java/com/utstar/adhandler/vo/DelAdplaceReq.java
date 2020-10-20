package com.utstar.adhandler.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class DelAdplaceReq implements Serializable {

    @NotNull(message = "域id不能为空")
    private Integer domainid;
    @NotBlank(message = "广告位id不能为空")
    private String posid;
    private static final long serialVersionUID = 1L;

}