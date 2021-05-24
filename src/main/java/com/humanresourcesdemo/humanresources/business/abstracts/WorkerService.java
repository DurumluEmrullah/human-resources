package com.humanresourcesdemo.humanresources.business.abstracts;

import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.entities.concretes.Worker;

import java.util.List;

public interface WorkerService {

    DataResult<List<Worker>> getAll();
    Result add(Worker worker);
    Result update(Worker worker);
    Result delete(Worker worker);
}
