package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.CompanyService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.CompanyDao;
import com.humanresourcesdemo.humanresources.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class CompanyManager implements CompanyService {


    private CompanyDao companyDao;

    @Autowired
    public CompanyManager(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }


    @Override
    public DataResult<List<Company>> getAll() {
        return new SuccessDataResult<>(this.companyDao.findAll(),"Şirketler listelendi.");
    }

    @Override
    public Result add(Company entity) {
        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }

        companyDao.save(entity);
        return new SuccessResult("Şirket eklendi.");
    }

    @Override
    public Result update(Company entity) {
        return null;
    }

    @Override
    public Result delete(Company entity) {
        return null;
    }
}
