package com.humanresourcesdemo.humanresources.core.business.abstracts;

import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import java.util.*;

public interface BaseService <T>{

    DataResult<List<T>> getAll();
    Result add (T entity);
    Result update(T entity);
    Result delete (T entity);
}
