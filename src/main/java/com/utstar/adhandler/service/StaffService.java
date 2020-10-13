package com.utstar.adhandler.service;

import com.utstar.adhandler.entity.Staff;
import com.utstar.adhandler.entity.StaffExample;
import com.utstar.adhandler.mapper.StaffMapper;
import com.utstar.adhandler.vo.StaffReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Slf4j
public class StaffService {

    @Autowired
    private StaffMapper staffMapper;


    public boolean existUser(String name, String password){
        //staffMapper.selectByExample();
        return true;
    }

    public Staff findUserById(String staffId) {
        return staffMapper.selectByPrimaryKey(Integer.parseInt(staffId));
    }

    public Staff findUserByName(StaffReq staffReq) {
        StaffExample staffExample = new StaffExample();
        staffExample.createCriteria().andNameEqualTo(staffReq.getUsername());
        List<Staff> staffList = staffMapper.selectByExample(staffExample);
        if(CollectionUtils.isEmpty(staffList)) return null;
        else return staffList.get(0);
    }
}