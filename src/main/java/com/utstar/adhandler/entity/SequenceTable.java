package com.utstar.adhandler.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class SequenceTable implements Serializable {

    private Integer SEQUENCE_ID;
    private String SEQUENCE_NAME;
}