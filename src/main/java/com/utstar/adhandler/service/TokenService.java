package com.utstar.adhandler.service;

import com.auth0.jwt.algorithms.Algorithm;
import com.utstar.adhandler.conf.CommonConfig;
import com.utstar.adhandler.entity.Staff;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {


    @Autowired
    private CommonConfig commonConfig;

    public String getToken(Staff staff) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 1000 * commonConfig.getExpireTime();//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(String.valueOf(staff.getStaffid())).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(staff.getPassword()));
        return token;
    }
}