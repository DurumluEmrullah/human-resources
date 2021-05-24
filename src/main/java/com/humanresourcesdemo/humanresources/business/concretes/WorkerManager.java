package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.MernisService;
import com.humanresourcesdemo.humanresources.business.abstracts.WorkerService;
import com.humanresourcesdemo.humanresources.core.utilities.results.*;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.WorkerDao;
import com.humanresourcesdemo.humanresources.entities.concretes.Employer;
import com.humanresourcesdemo.humanresources.entities.concretes.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class WorkerManager implements WorkerService {

    private WorkerDao workerDao;
    private MernisService mernisService;

    @Autowired
    public WorkerManager(WorkerDao workerDao,MernisService mernisService) {
        this.workerDao = workerDao;
        this.mernisService=mernisService;
    }

    @Override
    public DataResult<List<Worker>> getAll() {
        return new SuccessDataResult<List<Worker>>(this.workerDao.findAll(),"İşçiler listelenmiştir.");
    }

    @Override
    public Result add(Worker worker) {

        ArrayList<Result> results=new ArrayList<Result>( Arrays.asList(workerValidator(worker),
                existEmail(worker.getEmail()),existIdentityNumber(worker.getIdentificationNumber()),this.mernisService.verifyMernis(worker)));


        for(int i =0;i<results.size();i++){
            if(!results.get(i).isSuccess()){
                return results.get(i);
            }
        }

        worker.setEmailVerify(false);
        this.workerDao.save(worker);
        return new SuccessResult("Kayıt işlemi alınmıştır. Lütfen email doğrulaması yapınız.");
    }

    @Override
    public Result update(Worker worker) {
        return null;
    }

    @Override
    public Result delete(Worker worker) {
        return null;
    }


    private Result workerValidator(Worker worker){
        if (!worker.getFirstName().trim().equals("")
                &&!worker.getLastName().trim().equals("")
                &&!(worker.getBirthYear()<18)
                &&!worker.getEmail().trim().equals("")
                &&!worker.getPassword().trim().equals("")
                &&!worker.getIdentificationNumber().trim().equals(""))
        {
            return new SuccessResult("Validasyondan geçmiştir");
        }
        return new ErrorResult("Tüm Alanların doldurulması gerekmektedir.");
    }

    private Result existEmail(String newEmail){
        List<Worker> workers = this.workerDao.findAll();
        for (int i=0;i<workers.size();i++) {
            String email =workers.get(i).getEmail().replace(" ","").toLowerCase(Locale.ROOT);
            if(newEmail.replace(" ","").toLowerCase(Locale.ROOT).equals(email)){
                return  new ErrorResult("Bu kullanıcı  zaten mevcuttur.");
            }
        }
        return new SuccessResult("Lütfen Email doğrulaması yapınız.");

    }

    private Result existIdentityNumber(String newIdentityNumber){
        List<Worker> workers =this.workerDao.findAll();

        for(int i =0; i< workers.size();i++){
            String identityNumber=workers.get(i).getIdentificationNumber();
            if(newIdentityNumber.equals(identityNumber)){
                return  new ErrorResult("Bu kullanıcı  zaten mevcuttur.");
            }
        }

        return new SuccessResult("Lütfen Email doğrulaması yapınız.");
    }


}
