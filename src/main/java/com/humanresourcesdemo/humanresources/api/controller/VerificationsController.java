package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.VerifyService;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/verfications")
public class VerificationsController {

    private VerifyService verifyService;

    @Autowired
    public VerificationsController(VerifyService verifyService) {
        this.verifyService = verifyService;
    }

    @GetMapping("verifyworkeremail")
    public Result verifyWorkerEmail(String email){
        return this.verifyService.emailVeriifyForWorker(email);
    }

    @GetMapping("verifyemployeremail")
    public Result verifyEmployerEmail(String email){
        return this.verifyService.emailVeriifyForEmployer(email);
    }

    @GetMapping("verifyadmin")
    public Result verifyAdmin(String email){
        return this.verifyService.adminVerify(email);
    }
}
