package org.unicef.eroster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unicef.eroster.exception.RecordNotFoundException;
import org.unicef.eroster.model.Reference;
import org.unicef.eroster.service.ReferenceService;

import java.sql.Ref;
import java.util.List;

@RestController
@RequestMapping("references")
public class ReferenceController {
    @Autowired
    ReferenceService service;

    @GetMapping
    public ResponseEntity<List<Reference>> getAllReferences() {
        List<Reference> list = service.getAllReferences();

        return new ResponseEntity<List<Reference>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reference> getReferenceById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Reference entity = service.getReferenceById(id);

        return new ResponseEntity<Reference>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteReferenceById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteReferenceById(id);
        return HttpStatus.FORBIDDEN;
    }

}
