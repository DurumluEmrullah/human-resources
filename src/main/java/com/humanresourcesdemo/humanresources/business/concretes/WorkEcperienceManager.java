package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.WorkExperienceService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.WorkExperienceDao;
import com.humanresourcesdemo.humanresources.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WorkEcperienceManager implements WorkExperienceService {

    private WorkExperienceDao workExperienceDao;

    @Autowired
    public WorkEcperienceManager(WorkExperienceDao workExperienceDao) {
        this.workExperienceDao = workExperienceDao;
    }


    @Override
    public DataResult<List<WorkExperience>> getAll() {
        return new SuccessDataResult<>(this.workExperienceDao.findAll(),"İş tecrübeleri listelendi.");
    }

    @Override
    public Result add(WorkExperience entity) {
        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }

        this.workExperienceDao.save(entity);
        return new SuccessResult("İş tecrübesi kayıt edildi.");
    }

    @Override
    public Result update(WorkExperience entity) {
        return null;
    }

    @Override
    public Result delete(WorkExperience entity) {
        return null;
    }
}
