package com.utstar.adhandler.controller;

import com.utstar.adhandler.annotation.UserLoginToken;
import com.utstar.adhandler.service.AdplaceService;
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

@RestController
@Slf4j
@Api(value = "/adplace", tags= {"广告位接口"} , description = "adplace")
@RequestMapping("")
public class AdplaceController {

    @Autowired
    private AdplaceService adplaceService;

    //测试框架使用
    /*@GetMapping("/getadplace/{id}")
    public Adplace getAdplaceById(@PathVariable int id) {
        return adplaceService.getAdplaceById(id);
    }*/

    @UserLoginToken
    @PostMapping(path = "/registadplace")
    @ApiOperation(value="新增广告位", response = Response.class)
    public Response registadplace(@RequestBody AdplaceReq adplace) {
        try{
            int ret = adplaceService.registadplace(adplace);
            if(ret == 1) return Response.duplicateError("posid exists,please modify");
            else return Response.success();
        }catch (Exception ex) {
            log.error("registadplace exception:{}", ex);
            return Response.error();
        }
    }

    @UserLoginToken
    @PostMapping(path = "/updateadplace")
    @ApiOperation(value="修改广告位", response = Response.class)
    public Response updateadplace(@RequestBody AdplaceReq adplace) {
        try{
            int ret = adplaceService.updateadplace(adplace);
            if(ret == 0) return Response.duplicateError("posid not exists,please modify");
            else return Response.success();
        }catch (Exception ex) {
            log.error("updateadplace exception:{}", ex);
            return Response.error();
        }
    }

    @UserLoginToken
    @PostMapping(path = "/deleteadplace")
    @ApiOperation(value="删除广告位", response = Response.class)
    public Response deleteadplace(@RequestBody DelAdplaceReq adplace) {
        try{
            adplaceService.deleteadplace(adplace);
            return Response.success();
        }catch (Exception ex) {
            log.error("deleteadplace exception:{}", ex);
            return Response.error();
        }
    }

    @UserLoginToken
    @PostMapping(path = "/queryadplace")
    @ApiOperation(value="查询广告位", response = Response.class)
    public Response queryadplace(@RequestBody AdplacePageReq adplace) {
        try{
            PageResult pageResult = PageUtils.getPageResult(adplaceService.queryadplace(adplace));
            return Response.createSuccess(pageResult);
        }catch (Exception ex) {
            log.error("queryadplace exception:{}", ex);
            return Response.error();
        }
    }
}
