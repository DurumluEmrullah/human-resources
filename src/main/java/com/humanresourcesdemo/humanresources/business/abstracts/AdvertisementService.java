package com.humanresourcesdemo.humanresources.business.abstracts;

import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.entities.concretes.Advertisement;


import java.util.List;

public interface AdvertisementService {

    DataResult<List<Advertisement>> getAll();
    Result add(Advertisement advertisement);
    Result update(Advertisement advertisement);
    Result delete (Advertisement advertisement);
}
