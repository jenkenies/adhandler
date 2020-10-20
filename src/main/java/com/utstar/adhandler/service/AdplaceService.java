package com.utstar.adhandler.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.utstar.adhandler.conf.CommonConfig;
import com.utstar.adhandler.entity.Adplace;
import com.utstar.adhandler.entity.AdplaceExample;
import com.utstar.adhandler.mapper.AdplaceMapper;
import com.utstar.adhandler.vo.AdplacePageReq;
import com.utstar.adhandler.vo.AdplaceReq;
import com.utstar.adhandler.vo.DelAdplaceReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;


@Service
@Transactional
public class AdplaceService {

    @Autowired
    private AdplaceMapper adplaceMapper;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private CommonConfig commonConfig;

    @Autowired
    private GlobalcodedefService globalcodedefService;

    public Adplace getAdplaceById(Integer adplaceId) { return adplaceMapper.selectByPrimaryKey(adplaceId); };

    /**
     * 新增广告位
     * @param adplaceReq
     * @return
     */
    public int registadplace(AdplaceReq adplaceReq) {
        AdplaceExample adplaceExample = new AdplaceExample();
        adplaceExample.createCriteria().andPosidEqualTo(adplaceReq.getPosid()).andDomainidEqualTo(adplaceReq.getDomainid());
        List<Adplace> adplaceList = adplaceMapper.selectByExample(adplaceExample);
        if(CollectionUtils.isEmpty(adplaceList)) {
            Integer adplaceId = sequenceService.getSequenceId("adplaceid");
            Adplace adplace = new Adplace();
            BeanUtils.copyProperties(adplaceReq, adplace);
            adplace.setCode(globalcodedefService.getGlobalCode(0, "47",adplaceId));
            adplace.setAdplaceid(adplaceId);
            adplace.setCreatedate(new Date());
            adplace.setStaffid(commonConfig.getStaffid());
            adplace.setUsableflag("1");
            adplaceMapper.insert(adplace);
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 修改广告位
     * @param adplaceReq
     * @return
     */
    public int updateadplace(AdplaceReq adplaceReq) {
        AdplaceExample adplaceExample = new AdplaceExample();
        adplaceExample.createCriteria().andPosidEqualTo(adplaceReq.getPosid()).andDomainidEqualTo(adplaceReq.getDomainid());
        List<Adplace> adplaceList = adplaceMapper.selectByExample(adplaceExample);
        if(CollectionUtils.isEmpty(adplaceList)) {
            return 0;
        } else {
            Adplace adplace = new Adplace();
            BeanUtils.copyProperties(adplaceReq, adplace);
            adplace.setCreatedate(new Date());
            adplace.setStaffid(commonConfig.getStaffid());
            adplace.setUsableflag("1");
            adplaceMapper.updateByExampleSelective(adplace, adplaceExample);
            return 1;
        }
    }

    /**
     * 删除广告位
     * @param adplace
     */
    public void deleteadplace(DelAdplaceReq adplaceReq) {
        AdplaceExample adplaceExample = new AdplaceExample();
        adplaceExample.createCriteria().andPosidEqualTo(adplaceReq.getPosid()).andDomainidEqualTo(adplaceReq.getDomainid());
        adplaceMapper.deleteByExample(adplaceExample);
    }

    public PageInfo<Adplace> queryadplace(AdplacePageReq adplace) {
        int pageNum = adplace.getPageNum();
        int pageSize = adplace.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        AdplaceExample adplaceExample = new AdplaceExample();
        adplaceExample.createCriteria().andDomainidEqualTo(adplace.getDomainid());
        List<Adplace> adplaces = adplaceMapper.selectByExample(adplaceExample);
        return new PageInfo<Adplace>(adplaces);
    }
}
