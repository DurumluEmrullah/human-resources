package com.humanresourcesdemo.humanresources.business.concretes;

import com.humanresourcesdemo.humanresources.business.abstracts.PositionService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessResult;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.PositionDao;
import com.humanresourcesdemo.humanresources.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PositionManager implements PositionService {

    private PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult<>(this.positionDao.findAll(),"Pozisyonlar listelendi.");
    }

    @Override
    public Result add(Position entity) {

        ArrayList<Result> rules = new ArrayList<>(Arrays.asList(/*rules*/));

        for(int i =0;i<rules.size();i++){
            if(!rules.get(i).isSuccess()){
                return rules.get(i);
            }
        }

        positionDao.save(entity);
        return new SuccessResult("Pozisyon eklendi.");
    }

    @Override
    public Result update(Position entity) {
        return null;
    }

    @Override
    public Result delete(Position entity) {
        return null;
    }
}
