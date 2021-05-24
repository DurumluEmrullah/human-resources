package com.humanresourcesdemo.humanresources.business.abstracts;

import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.entities.concretes.Employer;


import java.util.List;

public interface EmployerService {

    DataResult<List<Employer> >getAll();
    Result add(Employer employer);
    Result update(Employer employer);
    Result delete(Employer employer);
}
