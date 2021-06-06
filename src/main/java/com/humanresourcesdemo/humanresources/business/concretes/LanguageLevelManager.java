package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.LanguageLevelService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.LanguageLevelDao;
import com.humanresourcesdemo.humanresources.entities.concretes.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LanguageLevelManager implements LanguageLevelService {

    private LanguageLevelDao languageLevelDao;

    @Autowired
    public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
        this.languageLevelDao = languageLevelDao;
    }

    @Override
    public DataResult<List<LanguageLevel>> getAll() {
        return new SuccessDataResult<>(this.languageLevelDao.findAll(),"Dil seviyeleri listelendi.");
    }

    @Override
    public Result add(LanguageLevel entity) {
        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }

        languageLevelDao.save(entity);
        return new SuccessResult("Seviye eklendi.");
    }

    @Override
    public Result update(LanguageLevel entity) {
        return null;
    }

    @Override
    public Result delete(LanguageLevel entity) {
        return null;
    }
}
