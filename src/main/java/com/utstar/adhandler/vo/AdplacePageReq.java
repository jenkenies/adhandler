package com.utstar.adhandler.vo;

import lombok.Data;

@Data
public class AdplacePageReq {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;

    private int domainid;

}