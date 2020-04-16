package com.the131.backend;

import javafx.scene.control.TextFormatter;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class COEService {
    COERepo repository;

    public COEService(COERepo repository){
        this.repository = repository;
    }

    ChangeEnrollment postCOE(@Valid ChangeEnrollment postCOE){
        return repository.save(postCOE);
    }

    ChangeEnrollment getCOE(@Valid Long id) throws Exception {
        try{
            return repository.findOne(id);
        }catch(Error e){
            throw new Exception(e);
        }
    }

}
