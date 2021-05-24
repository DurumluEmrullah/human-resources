package com.humanresourcesdemo.humanresources.business.abstracts;

import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.entities.concretes.Employer;
import com.humanresourcesdemo.humanresources.entities.concretes.User;
import com.humanresourcesdemo.humanresources.entities.concretes.Worker;

public interface VerifyService {

    Result adminVerify(String email);
    Result emailVeriifyForWorker(String email);
    Result emailVeriifyForEmployer(String email);
}
