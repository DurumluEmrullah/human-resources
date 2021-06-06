package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.DepartmantService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.DepartmantDao;
import com.humanresourcesdemo.humanresources.entities.concretes.Departmant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DepartmantManager implements DepartmantService {

    private DepartmantDao departmantDao;

    @Autowired
    public DepartmantManager(DepartmantDao departmantDao) {
        this.departmantDao = departmantDao;
    }


    @Override
    public DataResult<List<Departmant>> getAll() {
        return new SuccessDataResult<>(this.departmantDao.findAll(),"Bölümler listelendi.");
    }

    @Override
    public Result add(Departmant entity) {
        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }
        departmantDao.save(entity);
        return new SuccessResult("Bölüm eklendi.");
    }

    @Override
    public Result update(Departmant entity) {
        return null;
    }

    @Override
    public Result delete(Departmant entity) {
        return null;
    }
}
