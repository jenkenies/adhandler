package com.utstar.adhandler.service;

import com.utstar.adhandler.entity.SequenceTable;
import com.utstar.adhandler.mapper.SequenceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class SequenceService {

    @Autowired
    SequenceMapper sequenceDao;

    public Integer getSequenceId(String sequencename){
        SequenceTable sequenceTable = new SequenceTable();
        sequenceTable.setSEQUENCE_NAME(sequencename);
        sequenceDao.getNextId(sequenceTable);
        return sequenceTable.getSEQUENCE_ID();
    }
}