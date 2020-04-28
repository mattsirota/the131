package com.the131.backend;

import org.springframework.stereotype.Service;

@Service
public class COEService {
    COERepo repository;

    public COEService(COERepo repository){
        this.repository = repository;
    }

    COE postCOE(COE postCOE){
        return repository.save(postCOE);
    }

    COE getCOE(Long id) throws Exception {
        try{
            return repository.findOne(id);
        }catch(Error e){
            throw new Exception(e);
        }
    }

}
