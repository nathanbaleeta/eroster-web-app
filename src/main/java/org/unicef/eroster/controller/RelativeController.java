package org.unicef.eroster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unicef.eroster.exception.RecordNotFoundException;
import org.unicef.eroster.model.Relative;
import org.unicef.eroster.service.RelativeService;

import java.util.List;

@RestController
@RequestMapping("api/relatives")
public class RelativeController {
    @Autowired
    RelativeService service;

    @GetMapping
    public ResponseEntity<List<Relative>> getAllRelatives() {
        List<Relative> list = service.getAllRelatives();

        return new ResponseEntity<List<Relative>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relative> getRelativeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Relative entity = service.getRelativeById(id);

        return new ResponseEntity<Relative>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Relative> createOrUpdateReference(Relative relative)
            throws RecordNotFoundException {
        Relative updated = service.createOrUpdateRelative(relative);
        return new ResponseEntity<Relative>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteRelativeById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteRelativeById(id);
        return HttpStatus.FORBIDDEN;
    }

}
