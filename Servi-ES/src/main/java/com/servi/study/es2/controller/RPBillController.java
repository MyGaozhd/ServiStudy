package com.servi.study.es2.controller;

import com.servi.study.es2.document.RPBillDocument;
import com.servi.study.es2.service.IRPBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class RPBillController {
    @Autowired
    private IRPBillService service;

    @GetMapping("/test")
    public String test() {
        return "Success";
    }

    @PostMapping("/createRPBillDocument")
    public ResponseEntity createRPBillDocument(@RequestBody RPBillDocument document) throws Exception {
        return new ResponseEntity(service.createRPBillDocument(document), HttpStatus.CREATED);
    }

    @PostMapping("/updateRPBill")
    public ResponseEntity updateRPBill(@RequestBody RPBillDocument document) throws Exception {
        return new ResponseEntity(service.updateRPBill(document), HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public RPBillDocument findById(@PathVariable String id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/findAll")
    public List<RPBillDocument> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping(value = "/api/v1/rpbill/billno-search")
    public List<RPBillDocument> searchByName(@RequestParam(value = "billno") String billno) throws Exception {
        return service.findRPBillByBillno(billno);
    }

    @GetMapping("/deleteRPBillDocument/{id}")
    public String deleteRPBillDocument(@PathVariable String id) throws Exception {
        return service.deleteRPBillDocument(id);
    }

    @GetMapping("/boolQuery")
    public List<RPBillDocument> boolQuery() throws Exception {
        return service.boolQuery();
    }
}
