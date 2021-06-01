package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.EmployerService;

import com.humanresourcesdemo.humanresources.core.utilities.results.*;

import com.humanresourcesdemo.humanresources.dataAccess.abstracts.EmployerDao;
import com.humanresourcesdemo.humanresources.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        super();
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>>getAll() {

        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelenmiştir.");
    }

    @Override
    public Result add(Employer employer) {
        ArrayList<Result> rules=new ArrayList<Result>( Arrays.asList(employerValidator(employer),
                        existEmail(employer.getEmail()),
                        domainControl(employer.getEmail(),employer.getWebSite()))) ;

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }

        employer.setAdminVerify(false);
        employer.setEmailVerify(false);
        employerDao.save(employer);
        return new SuccessResult("Email doğrulamasını yapıp adminin kayıdınızı onaylamasını bekleyiniz.");
    }

    @Override
    public Result update(Employer employer) {
        return null;
    }

    @Override
    public Result delete(Employer employer) {
        return null;
    }


    private Result employerValidator(Employer employer){
        if (!employer.getCompanyName().trim().equals("")
                &&!employer.getPhoneNumber().trim().equals("")
                &&!employer.getWebSite().trim().equals("")
                &&!employer.getEmail().trim().equals("")
                &&!employer.getPassword().trim().equals(""))
        {
         return new SuccessResult("Validasyondan geçmiştir");
        }
        return new ErrorResult("Tüm Alanların doldurulması gerekmektedir.");
    }

    private Result domainControl(String email,String webSite)
    {
        if(webSite.indexOf('.')!=-1){
            String domain =webSite.substring(webSite.indexOf('.')+1);

            if(email.endsWith(domain)){
                return new SuccessResult("Kayıt gerçekleşmiştir email onayınızı yaptıktan sonra admin onayını beklemeniz gerekmektedir.");
            }
        }
        return new ErrorResult("Web sitesi ile mail adresinin domaini farklı olamaz.");
    }

    private Result existEmail(String email){
        List<Employer> employers = this.employerDao.findAll();
        for (int i=0;i<employers.toArray().length;i++) {
            String emailOfDb =employers.get(i).getEmail().replace(" ","").toLowerCase(Locale.ROOT);
            if(email.replace(" ","").toLowerCase(Locale.ROOT).equals(emailOfDb)){
                return  new ErrorResult("Bu kullanıcı  zaten mevcuttur.");
            }
        }

        return new SuccessResult("Kayıt talebi alınmıştır. Email doğrulaması yaptıktan sonra admin onayını bekleyiniz.");
    }
}
