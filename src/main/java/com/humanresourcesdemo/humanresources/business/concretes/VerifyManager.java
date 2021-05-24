package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.VerifyService;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.EmployerDao;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.WorkerDao;
import com.humanresourcesdemo.humanresources.entities.concretes.Employer;
import com.humanresourcesdemo.humanresources.entities.concretes.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyManager implements VerifyService {

    private EmployerDao employerDao;
    private WorkerDao workerDao;

    @Autowired
    public VerifyManager(EmployerDao employerDao, WorkerDao workerDao) {
        this.employerDao = employerDao;
        this.workerDao = workerDao;
    }

    @Override
    public Result adminVerify(String email) {
        Employer employer =employerDao.findByEmail(email);
        employer.setAdminVerify(true);
        employerDao.save(employer);
        return new SuccessResult("Uyeliginiz admin tarafından onaylanmıştır.");
    }

    @Override
    public Result emailVeriifyForWorker(String email) {
        Worker worker=workerDao.findByEmail(email);
        worker.setEmailVerify(true);
        workerDao.save(worker);
        return new SuccessResult("Email onaylama işlemi başarıyla gerçekleşmiştir.");
    }

    @Override
    public Result emailVeriifyForEmployer(String email) {
        Employer employer =employerDao.findByEmail(email);
        employer.setEmailVerify(true);
        employerDao.save(employer);
        return new SuccessResult("Email Doğrulama işlemi başarıyla gerçekleşmiştir.");
    }
}
