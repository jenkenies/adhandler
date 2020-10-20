package com.utstar.adhandler.service;

import com.utstar.adhandler.entity.Globalcodedef;
import com.utstar.adhandler.entity.GlobalcodedefExample;
import com.utstar.adhandler.mapper.GlobalcodedefMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class GlobalcodedefService {

    @Autowired
    private GlobalcodedefMapper globalcodedefMapper;

    //获取全局唯一编码
    public String getGlobalCode(int spid, String objType, int objId) {
        GlobalcodedefExample globalcodedefExample = new GlobalcodedefExample();
        globalcodedefExample.createCriteria().andObjecttypeEqualTo(objType).andOwnertypeEqualTo("0");
        List<Globalcodedef> globalcodedefs = globalcodedefMapper.selectByExample(globalcodedefExample);
        if(CollectionUtils.isEmpty(globalcodedefs)) return "";
        else {
            Globalcodedef globalcodedef = globalcodedefs.get(0);
            String prefix = globalcodedef.getPrefix();
            String bodytype = globalcodedef.getBodytype();
            String bodyformat = globalcodedef.getBodyformat();
            Integer bodylength = globalcodedef.getBodylength();
            String suffix = globalcodedef.getSuffix();
            String sbody = String.valueOf(objId);
            if ("2".equals(bodyformat)) {
                sbody = lpad(sbody, bodylength, "0");
            }
            String globalcode = null;
            if (suffix == null) {
                globalcode = prefix + sbody;
            } else {
                globalcode = prefix + sbody + suffix;
            }
            return globalcode;
        }
    }

    public String lpad(String str, Integer num, String pad) {
        String n_str = str;
        if (str == null)
            n_str = " ";
        for (int i = str.length(); i < num; i++) {
            n_str = pad + n_str;
        }
        return n_str;
    }
}
