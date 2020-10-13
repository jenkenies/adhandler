package com.utstar.adhandler.controller;

import com.alibaba.druid.util.StringUtils;
import com.utstar.adhandler.entity.Staff;
import com.utstar.adhandler.service.AdplaceService;
import com.utstar.adhandler.service.StaffService;
import com.utstar.adhandler.service.TokenService;
import com.utstar.adhandler.util.EncryptApi;
import com.utstar.adhandler.util.PageUtils;
import com.utstar.adhandler.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@Api(value = "/login", tags= {"登录接口"} , description = "login")
@RequestMapping("")
public class LoginController {

    @Autowired
    private StaffService staffService;

    @Autowired
    TokenService tokenService;

    //测试框架使用
    /*@GetMapping("/getadplace/{id}")
    public Adplace getAdplaceById(@PathVariable int id) {
        return adplaceService.getAdplaceById(id);
    }*/

    @PostMapping(path = "/login")
    @ApiOperation(value="获取token", response = Response.class)
    public Response<String> login(@RequestBody StaffReq staffReq, HttpServletResponse response) {
        try{
            Staff staff = staffService.findUserByName(staffReq);
            if(staff == null)  return Response.createError("user not exists");
            if(!StringUtils.equals(staff.getPassword(), EncryptApi.encryptPlainPassword(staffReq.getPassword()))) {
                return Response.createError("password error");
            } else {
                String token = tokenService.getToken(staff);
                return Response.createSuccess(token);
            }
        }catch (Exception ex) {
            log.error("registadplace exception:{}", ex);
            return Response.error();
        }
    }

}
