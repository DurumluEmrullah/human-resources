package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.PositionService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/positions")
public class PositionsController extends BaseController<PositionService, Position> {

    private PositionService positionService;

    @Autowired
    public PositionsController(PositionService positionService) {
        super(positionService);
        this.positionService = positionService;
    }
}
