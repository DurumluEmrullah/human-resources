package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.LanguageService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.LanguageDao;
import com.humanresourcesdemo.humanresources.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }


    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<>(this.languageDao.findAll(),"Yabancı diller listelendi");
    }

    @Override
    public Result add(Language entity) {
        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }

        languageDao.save(entity);
        return new SuccessResult("Dil Eklendi.");
    }

    @Override
    public Result update(Language entity) {
        return null;
    }

    @Override
    public Result delete(Language entity) {
        return null;
    }
}
