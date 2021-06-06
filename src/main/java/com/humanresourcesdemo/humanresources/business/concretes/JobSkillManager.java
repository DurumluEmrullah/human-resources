package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.JobSkillService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.JobSkillDao;
import com.humanresourcesdemo.humanresources.entities.concretes.JobSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobSkillManager implements JobSkillService {

    private JobSkillDao jobSkillDao;

    @Autowired
    public JobSkillManager(JobSkillDao jobSkillDao){
        this.jobSkillDao=jobSkillDao;
    }


//    @Override
//    public DataResult<List<JobSkill>> getByCvId(int cvId) {
//        return new SuccessDataResult<List<JobSkill>>(this.jobSkillDao.getByCurriculumVitae_CvId(cvId),"Yetenekler CV Id'sine ye göre listelendi");
//    }

    @Override
    public DataResult<List<JobSkill>> getAll() {
        return new SuccessDataResult<List<JobSkill>>(this.jobSkillDao.findAll(),"Yetenekler listelendi");
    }

    @Override
    public Result add(JobSkill entity) {
        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }

        jobSkillDao.save(entity);
        return new SuccessResult("Yetenek eklendi.");
    }

    @Override
    public Result update(JobSkill entity) {
        return null;
    }

    @Override
    public Result delete(JobSkill entity) {
        return null;
    }
}
