package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.SkillService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.SkillDao;
import com.humanresourcesdemo.humanresources.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SkillManager implements SkillService {

    private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        this.skillDao = skillDao;
    }


    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>(this.skillDao.findAll(),"Yetenekler listelendi");
    }

    @Override
    public Result add(Skill entity) {

        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }

        skillDao.save(entity);
        return new SuccessResult("Yetenek eklendi");
    }

    @Override
    public Result update(Skill entity) {
        return null;
    }

    @Override
    public Result delete(Skill entity) {
        return null;
    }
}
