package com.humanresourcesdemo.humanresources.business.abstracts;

import com.humanresourcesdemo.humanresources.core.business.abstracts.BaseService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.entities.concretes.WorkExperience;

import java.util.*;

public interface WorkExperienceService extends BaseService<WorkExperience> {


    DataResult<List<WorkExperience>> orderByFinishDateDecs(int cvId);
}
