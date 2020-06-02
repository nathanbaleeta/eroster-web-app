package org.unicef.eroster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unicef.eroster.exception.RecordNotFoundException;
import org.unicef.eroster.model.Dependent;
import org.unicef.eroster.service.DependentService;

import java.util.List;

@RestController
@RequestMapping("api/dependents")
public class DependentController {
    @Autowired
    DependentService service;

    @GetMapping
    public ResponseEntity<List<Dependent>> getAllDependents() {
        List<Dependent> list = service.getAllDependents();

        return new ResponseEntity<List<Dependent>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dependent> getDependentById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Dependent entity = service.getDependentById(id);

        return new ResponseEntity<Dependent>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Dependent> createOrUpdateDependent(Dependent dependent)
            throws RecordNotFoundException {
        Dependent updated = service.createOrUpdateDependent(dependent);
        return new ResponseEntity<Dependent>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteDependentById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteDependentById(id);
        return HttpStatus.FORBIDDEN;
    }

}
