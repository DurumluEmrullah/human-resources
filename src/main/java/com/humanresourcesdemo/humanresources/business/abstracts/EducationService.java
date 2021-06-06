package com.humanresourcesdemo.humanresources.business.abstracts;

import com.humanresourcesdemo.humanresources.core.business.abstracts.BaseService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.entities.concretes.Education;

import java.util.*;
public interface EducationService extends BaseService<Education> {

    DataResult<List<Education>> getByCvIdAndOrderByGraduateDateDesc(int cvId);
}
