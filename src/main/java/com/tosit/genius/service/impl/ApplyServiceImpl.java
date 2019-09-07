package com.tosit.genius.service.impl;

import com.tosit.genius.dao.AdvertisementMapper;
import com.tosit.genius.dao.ApplyMapper;
import com.tosit.genius.dao.CompanyMapper;
import com.tosit.genius.entity.Advertisement;
import com.tosit.genius.entity.Apply;
import com.tosit.genius.entity.ApplyKey;
import com.tosit.genius.service.ApplyService;
import com.tosit.genius.util.AdvertisementInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

    private ApplyMapper applyMapper;
    private AdvertisementMapper advertisementMapper;
    private CompanyMapper companyMapper;

    @Autowired
    public ApplyServiceImpl(ApplyMapper applyMapper, AdvertisementMapper advertisementMapper,
                            CompanyMapper companyMapper){
        this.applyMapper = applyMapper;
        this.advertisementMapper = advertisementMapper;
        this.companyMapper = companyMapper;
    }


    @Override
    public Boolean applyNew(Apply apply) {
        int flag = applyMapper.insert(apply);
        if(flag != 0)
            return true;
        else
            return false;
    }

    @Override
    public List<AdvertisementInfo> listAllApplyInfo(String userId) {
        List<Apply> applyList = applyMapper.listAll();
        List<Apply> newApplyList = new ArrayList<>();
        List<AdvertisementInfo> infoList = new ArrayList<>();
//        List<Advertisement> advertisementList = advertisementMapper.listAll();
//        List<Advertisement> resultList = new ArrayList<>();
        for(int i = 0; i < applyList.size(); i++) {
            if(applyList.get(i).getApplyUserId().equals(userId))
                newApplyList.add(applyList.get(i));
        }



        for(int j = 0; j < newApplyList.size(); j++){
            AdvertisementInfo advertisementInfo = new AdvertisementInfo();
            advertisementInfo.setApplyDate(newApplyList.get(j).getApplyDate());
            advertisementInfo.setPassed(newApplyList.get(j).getIspassed());
            advertisementInfo.setAdTitle(advertisementMapper.selectByPrimaryKey(newApplyList.get(j).getApplyAdId()).getAdTitle());
            advertisementInfo.setCompanyName(companyMapper.selectByPrimaryKey(advertisementMapper.selectByPrimaryKey(newApplyList.get(j).getApplyAdId()).getAdCompanyId()).getCompanyName());
            advertisementInfo.setStatement(newApplyList.get(j).getStatement());
            infoList.add(advertisementInfo);
        }

        return infoList;
    }

    @Override
    public List<AdvertisementInfo> listApplyInfoIsPassed(String userId) {
        List<Apply> applyList = applyMapper.listAll();
        List<Apply> newApplyList = new ArrayList<>();
        List<AdvertisementInfo> infoList = new ArrayList<>();
        List<Advertisement> advertisementList = advertisementMapper.listAll();
        List<Advertisement> resultList = new ArrayList<>();
        for(int i = 0; i < applyList.size(); i++) {
            if(applyList.get(i).getApplyUserId().equals(userId))
                newApplyList.add(applyList.get(i));
        }



        for(int j = 0; j < newApplyList.size(); j++){
            AdvertisementInfo advertisementInfo = new AdvertisementInfo();
            advertisementInfo.setApplyDate(newApplyList.get(j).getApplyDate());
            advertisementInfo.setPassed(newApplyList.get(j).getIspassed());
            advertisementInfo.setAdTitle(advertisementMapper.selectByPrimaryKey(newApplyList.get(j).getApplyAdId()).getAdTitle());
            advertisementInfo.setCompanyName(companyMapper.selectByPrimaryKey(advertisementMapper.selectByPrimaryKey(newApplyList.get(j).getApplyAdId()).getAdCompanyId()).getCompanyName());
            advertisementInfo.setStatement(newApplyList.get(j).getStatement());

            if(advertisementInfo.getPassed() == true)
                infoList.add(advertisementInfo);
        }
        return infoList;
    }

    @Override
    public int isApplied(String userId, String adId) {
        ApplyKey applyKey = new ApplyKey();
        applyKey.setApplyAdId(adId);
        applyKey.setApplyUserId(userId);
        Apply apply = applyMapper.selectByPrimaryKey(applyKey);
        if(apply.getApplyAdId()!=null)
            return 1;
        else
            return 0;

    }


    @Override
    public int updateIsPassed(String usrId, String adId, Boolean isPassed) {
        ApplyKey applyKey = new ApplyKey();
        applyKey.setApplyAdId(adId);
        applyKey.setApplyUserId(usrId);
        Apply apply = applyMapper.selectByPrimaryKey(applyKey);
        apply.setIspassed(isPassed);
        return applyMapper.updateByPrimaryKey(apply);

    }
}
