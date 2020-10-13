package com.utstar.adhandler.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DelAdplaceReq implements Serializable {

    private Integer domainid;
    private String posid;
    private static final long serialVersionUID = 1L;

}