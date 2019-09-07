package com.tosit.genius.service.impl;

import com.tosit.genius.dao.AdvertisementMapper;
import com.tosit.genius.dao.ApplyMapper;
import com.tosit.genius.dao.CompanyMapper;
import com.tosit.genius.entity.Advertisement;
import com.tosit.genius.entity.Apply;
import com.tosit.genius.entity.Company;
import com.tosit.genius.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService{

    private AdvertisementMapper advertisementMapper;
    private CompanyMapper companyMapper;
    private ApplyMapper applyMapper;

    @Autowired
    public AdvertisementServiceImpl(AdvertisementMapper advertisementMapper,CompanyMapper companyMapper,
                                    ApplyMapper applyMapper){
        this.advertisementMapper = advertisementMapper;
        this.companyMapper = companyMapper;
        this.applyMapper = applyMapper;
    }

    @Override
    public Boolean insertNewAd(Advertisement advertisement) {
        int flag = advertisementMapper.insert(advertisement);
        if(flag != 0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean deleteAd(String adId) {
        int flag = advertisementMapper.deleteByPrimaryKey(adId);
        if(flag != 0)
            return true;

        applyMapper.deleteByAdId(adId);
        return false;
    }

    @Override
    public Boolean updateAd(Advertisement newAd) {
        int flag = advertisementMapper.updateByPrimaryKeySelective(newAd);
        if(flag != 0)
            return true;
        else
            return false;
    }

    @Override
    public List<Advertisement> getAllAd() {
        return advertisementMapper.listAll();
    }

    @Override
    public List<Advertisement> getAdByName(String name) {
        return advertisementMapper.selectByName(name);
    }

    @Override
    public List<Advertisement> getAdByCompanyId(String companyId) {
        List<Advertisement> advertisementList = advertisementMapper.listAll();
        List<Advertisement> resultList = new ArrayList<>();
        for (int i = 0; i < advertisementList.size(); i++)
        {
            if(advertisementList.get(i).getAdCompanyId().equals(companyId))
                resultList.add(advertisementList.get(i));
        }
        return resultList;
    }

    @Override
    public int checkAdIdentity(String adId, Boolean status) {
        if(status == false) {
            advertisementMapper.deleteByPrimaryKey(adId);
            return 1;
        }
        Advertisement ad = new Advertisement();
        ad.setAdId(adId);
        ad.setAdStatus(status);
        return advertisementMapper.updateByPrimaryKeySelective(ad);
    }

    @Override
    public Company getCompanyByComId(String companyId) {
        return companyMapper.selectByPrimaryKey(companyId);
    }

    @Override
    public List<Apply> getAppliedUser(String companyId) {
        int i,j,k;
        List<Advertisement> advertisementList = advertisementMapper.listAll();
        List<Advertisement> newList = new ArrayList<>();
        List<String> adIdList = new ArrayList<>();
        List<Apply> applyList = applyMapper.listAll();
        List<Apply> resultList = new ArrayList<>();

        for(i =0;i<advertisementList.size();i++){
            if(advertisementList.get(i).getAdCompanyId().equals(companyId))
                newList.add(advertisementList.get(i));
        }
        for(j =0; j< newList.size();j++){
            adIdList.add(newList.get(j).getAdId());
        }

        for(i=0;i<adIdList.size();i++){
            for(j=0;j<applyList.size();j++){
                if(applyList.get(j).getApplyAdId().equals(adIdList.get(i)))
                    resultList.add(applyList.get(j));
            }
        }
        return resultList;
    }

    @Override
    public Advertisement selectByPrimaryKey(String adId) {
        return advertisementMapper.selectByPrimaryKey(adId);
    }


}
