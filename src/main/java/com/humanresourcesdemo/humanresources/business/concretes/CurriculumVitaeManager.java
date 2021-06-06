package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.CurriculumVitaeService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.CurriculumVitaeDao;
import com.humanresourcesdemo.humanresources.entities.concretes.CurriculumVitae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

    private CurriculumVitaeDao curriculumVitaeDao;


    @Autowired
    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
        this.curriculumVitaeDao = curriculumVitaeDao;
    }


    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<>(this.curriculumVitaeDao.findAll(),"Sistemdeki CV\' ler listelendi");
    }

    @Override
    public Result add(CurriculumVitae entity) {
        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }

        this.curriculumVitaeDao.save(entity);
        return new SuccessResult("CV Sisteme kayıt edildi.");
    }

    @Override
    public Result update(CurriculumVitae entity) {
        return null;
    }

    @Override
    public Result delete(CurriculumVitae entity) {
        return null;
    }
}
