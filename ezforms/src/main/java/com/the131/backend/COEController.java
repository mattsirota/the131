package com.the131.backend;

import org.springframework.web.bind.annotation.*;


@RestController
public class COEController {
    private COEService service;

    public COEController(COEService service){
        this.service = service;
    }

    @PostMapping("/ChangeEnrollment")
    COE postCOE(@RequestBody COE newCOE){
        return service.postCOE(newCOE);
    }

    @GetMapping("/ChangeEnrollment/{id}")
    COE getCOE(@PathVariable Long id) throws Exception {
        return service.getCOE(id);
}

}
