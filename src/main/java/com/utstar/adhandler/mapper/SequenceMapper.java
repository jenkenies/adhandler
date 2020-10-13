package com.utstar.adhandler.mapper;


import com.utstar.adhandler.entity.SequenceTable;

public interface SequenceMapper {

    void getNextId(SequenceTable sequenceTable);

}