package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.ForeignLanguageService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.ForeignLanguageDao;
import com.humanresourcesdemo.humanresources.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {


    private ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        this.foreignLanguageDao = foreignLanguageDao;
    }


    @Override
    public DataResult<List<ForeignLanguage>> getAll() {
        return new SuccessDataResult<>(foreignLanguageDao.findAll(),"Yabancı diller listelendi");
    }

    @Override
    public Result add(ForeignLanguage entity) {

        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }
        foreignLanguageDao.save(entity);
        return new SuccessResult("Yabancı dil eklendi");
    }

    @Override
    public Result update(ForeignLanguage entity) {
        return null;
    }

    @Override
    public Result delete(ForeignLanguage entity) {
        return null;
    }
}
