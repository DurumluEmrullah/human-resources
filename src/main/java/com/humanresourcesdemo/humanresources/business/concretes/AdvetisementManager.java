package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.AdvertisementService;
import com.humanresourcesdemo.humanresources.business.constants.Messages;
import com.humanresourcesdemo.humanresources.core.business.abstracts.BaseService;
import com.humanresourcesdemo.humanresources.core.utilities.results.*;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.AdvertisementDao;
import com.humanresourcesdemo.humanresources.entities.concretes.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class AdvetisementManager implements AdvertisementService {


    private AdvertisementDao advertisementDao;

    @Autowired
    public AdvetisementManager(AdvertisementDao advertisementDao){
        this.advertisementDao=advertisementDao;
    }

    @Override
    public DataResult<List<Advertisement>> getAll() {
        return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.findAll(),"İş ilanları Listelenmiştir.");
    }

    @Override
    public DataResult<List<Advertisement>> findByIsActiveTrue() {
        return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.findByIsActiveTrue(),"Aktif tüm iş ilanları listelendi");
    }

    @Override
    public DataResult<List<Advertisement>> findByIsActiveTrueAndOrderByCreatedDateDesc() {
        Sort sort =Sort.by(Sort.Direction.DESC,"createdDate");
        return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.findByOrderByCreatedDateAscAndIsActive(sort,true),"Aktif tüm iş ilanları oluşturulma tarihine göre listelendi");
    }

    @Override
    public DataResult<List<Advertisement>> getByCityId(int cityId) {
        return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByCity_CityId(cityId),"Tüm iş ilanları şehir adına göre listelendi");
    }

    @Override
    public DataResult<List<Advertisement>> getByJobId(int jobId) {
        return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByJob_Id(jobId),"Tüm iş ilanları meslek adına göre listelendi");
    }

    @Override
    public DataResult<List<Advertisement>> findByEmployerId(int id) {
        return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.findByEmployer_Id(id),"Tüm iş ilanları ilan sahibi şirket adına göre listelendi");
    }

    @Override
    public DataResult<List<Advertisement>> getByDescriptionContains(String description) {
        return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByDescriptionContains(description),description+" içeren tüm iş ilanlari listelendi");
    }

    @Override
    public Result add(Advertisement advertisement) {

        advertisement.setCreatedDate((new Date()));
        ArrayList<Result> rules =new ArrayList<Result>(Arrays.asList(advertisementValidation(advertisement)));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }
        this.advertisementDao.save(advertisement);
        return new SuccessResult(Messages.addedAdvertisement);
    }

    @Override
    public Result update(Advertisement advertisement) {
        return null;
    }

    @Override
    public Result delete(Advertisement advertisement) {
        return null;
    }

    private Result advertisementValidation(Advertisement advertisement){

        if(advertisement.getDescription().equals("") ){
            return new ErrorResult("Açıklama alanı boş geçilemez !!");
        }
        if( !(advertisement.getNumberOfOffer()>0)){
            return  new ErrorResult("Lütfen açık pozisyon adedini doğru bir şekilde giriniz!");
        }

        return  new SuccessResult("İlan tüm kurallara uygundur.");
    }
}
