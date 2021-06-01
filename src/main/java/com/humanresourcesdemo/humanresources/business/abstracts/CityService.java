package com.humanresourcesdemo.humanresources.business.abstracts;

import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.entities.concretes.City;
import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();
    Result add(City city);
    Result update(City city);
    Result delete (City city);
}
