package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.SkillService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/skills")
public class SkillsController extends BaseController<SkillService,Skill> {

    private SkillService skillService;
    @Autowired
    public SkillsController(SkillService skillService) {
        super(skillService);
        this.skillService=skillService;

    }

}
