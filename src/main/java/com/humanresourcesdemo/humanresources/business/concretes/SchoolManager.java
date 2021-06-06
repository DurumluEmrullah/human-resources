package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.SchoolService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.SchoolDao;
import com.humanresourcesdemo.humanresources.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<>(this.schoolDao.findAll(),"Okullar listelendi.");
    }

    @Override
    public Result add(School entity) {

        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }

        this.schoolDao.save(entity);
        return new SuccessResult("Okul eklendi.");
    }

    @Override
    public Result update(School entity) {
        return null;
    }

    @Override
    public Result delete(School entity) {
        return null;
    }
}
