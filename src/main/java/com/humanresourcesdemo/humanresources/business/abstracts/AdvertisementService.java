package com.humanresourcesdemo.humanresources.business.abstracts;

import com.humanresourcesdemo.humanresources.core.business.abstracts.BaseService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.entities.concretes.Advertisement;


import java.util.List;

public interface AdvertisementService extends BaseService<Advertisement> {


    DataResult<List<Advertisement>> findByIsActiveTrue();
    DataResult<List<Advertisement>> findByIsActiveTrueAndOrderByCreatedDateDesc();
    DataResult<List<Advertisement>> getByCityId(int cityId);
    DataResult<List<Advertisement>> getByJobId(int jobId);
    DataResult<List<Advertisement>> findByEmployerId(int id);
    DataResult<List<Advertisement>> getByDescriptionContains(String description);

}
