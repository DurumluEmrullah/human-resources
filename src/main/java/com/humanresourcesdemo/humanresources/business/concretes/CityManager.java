package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.CityService;
import com.humanresourcesdemo.humanresources.core.utilities.results.*;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.CityDao;
import com.humanresourcesdemo.humanresources.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao){
        this.cityDao=cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Şehirler Listelendi");
    }

    @Override
    public Result add(City city) {
        ArrayList<Result> rules =new ArrayList<Result>(Arrays.asList(
                existCityName(city)
        ));

        for( int i =0; i< rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }

        this.cityDao.save(city);
        return new SuccessResult("Şehir eklenmiştir");
    }

    @Override
    public Result update(City city) {
        ArrayList<Result> rules =new ArrayList<Result>(Arrays.asList(
                existCityName(city),idControl(city.getCityId())
        ));

        for( int i =0; i< rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }
        this.cityDao.save(city);
        return new SuccessResult("Şehir Güncellendi.");
    }

    @Override
    public Result delete(City city) {
        this.cityDao.delete(city);
        return new SuccessResult("Şehir Silindi");
    }

    private Result existCityName(City city){
        List<City> cities = this.cityDao.findAll();
        String newCity = city.getCityName().toLowerCase(Locale.ROOT).trim();
        for (int i =0;i<cities.size();i++){
            if(newCity.equals(cities.get(i).getCityName().toLowerCase(Locale.ROOT).trim())){
                return new ErrorResult("Bu şehir zaten mevcut");
            }
        }

        return  new SuccessResult("Şehir eklendi.");
    }

    private Result idControl(int id){
        List<City> cities = this.cityDao.findAll();
        boolean result = true;
        for (int i =0;i<cities.size();i++){
            if(cities.get(i).getCityId() ==id){
                return  new SuccessResult();
            }
        }

        return  new ErrorResult("Böyle bir şehir yok.");
    }
}
