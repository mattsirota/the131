package com.the131.backend;

import org.springframework.web.bind.annotation.*;


@RestController
public class COEController {
    private COEService service;

    public COEController(COEService service){
        this.service = service;
    }

    @PostMapping("/ChangeEnrollment")
    ChangeEnrollment postCOE(@RequestBody ChangeEnrollment newCOE){
        return service.postCOE(newCOE);
    }

    @GetMapping("/ChangeEnrollment/{id}")
    ChangeEnrollment getCOE(@PathVariable Long id) throws Exception {
        return service.getCOE(id);
}

}
