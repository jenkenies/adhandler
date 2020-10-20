package com.utstar.adhandler.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AdplacePageReq {
    /**
     * 当前页码
     */
    @NotNull(message = "当前页码不能为空")
    private int pageNum;
    /**
     * 每页数量
     */
    @NotNull(message = "每页数量不能为空")
    private int pageSize;
    @NotNull(message = "域id不能为空")
    private int domainid;

}