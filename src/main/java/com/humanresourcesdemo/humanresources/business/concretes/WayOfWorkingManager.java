package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.WayOfWorkingService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.WayOfWorkingDao;
import com.humanresourcesdemo.humanresources.entities.concretes.WayOfWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WayOfWorkingManager implements WayOfWorkingService {

    private WayOfWorkingDao wayOfWorkingDao;

    @Autowired
    public WayOfWorkingManager(WayOfWorkingDao wayOfWorkingDao) {
        this.wayOfWorkingDao = wayOfWorkingDao;
    }

    @Override
    public DataResult<List<WayOfWorking>> getAll() {
        return new SuccessDataResult<>(wayOfWorkingDao.findAll());
    }

    @Override
    public Result add(WayOfWorking entity) {

        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }
        wayOfWorkingDao.save(entity);
        return new SuccessResult("Çalışma Biçimi eklenmiştir");
    }

    @Override
    public Result update(WayOfWorking entity) {
        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }
        wayOfWorkingDao.save(entity);
        return new SuccessResult("Çalışma Biçimi Güncellenmiştir");
    }

    @Override
    public Result delete(WayOfWorking entity) {
        wayOfWorkingDao.delete(entity);
        return new SuccessResult("Çalışma Şekli silindi");
    }
}
