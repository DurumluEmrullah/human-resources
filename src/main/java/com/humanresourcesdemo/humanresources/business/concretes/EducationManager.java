package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.EducationService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.EducationDao;
import com.humanresourcesdemo.humanresources.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<>(this.educationDao.findAll(),"Eğitim bilgileri listelendi.");
    }

    @Override
    public Result add(Education entity) {
        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }

        educationDao.save(entity);
        return new SuccessResult("Eğitim bilgisi eklendi.");
    }

    @Override
    public Result update(Education entity) {
        return null;
    }

    @Override
    public Result delete(Education entity) {
        return null;
    }

    @Override
    public DataResult<List<Education>> getByCvIdAndOrderByGraduateDateDesc(int cvId) {
        Sort sort =Sort.by(Sort.Direction.DESC,"graduateDate");
        return new SuccessDataResult<>(this.educationDao.findByNameOrderByGraduateDateDescAndByCv(sort,cvId),"Öğrenim geçmişi kronolojik sraya göre tertn sıralandı.");
    }
}
