package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.MernisService;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.entities.concretes.Employer;
import com.humanresourcesdemo.humanresources.entities.concretes.User;
import org.springframework.stereotype.Service;

@Service
public class MernisManager implements MernisService {
    @Override
    public Result verifyMernis(User user) {
        return new SuccessResult("Mernis Doğrulama gerçekleştirilmiştir.");
    }
}
