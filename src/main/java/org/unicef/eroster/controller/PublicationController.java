package org.unicef.eroster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unicef.eroster.exception.RecordNotFoundException;
import org.unicef.eroster.model.Publication;
import org.unicef.eroster.model.Reference;
import org.unicef.eroster.service.PublicationService;

import java.util.List;

@RestController
@RequestMapping("api/publications")
public class PublicationController {

    @Autowired
    PublicationService service;

    @GetMapping
    public ResponseEntity<List<Publication>> getAllPublications() {
        List<Publication> list = service.getAllPublications();

        return new ResponseEntity<List<Publication>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publication> getPublicationById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Publication entity = service.getPublicationById(id);

        return new ResponseEntity<Publication>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePublicationById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deletePublicationById(id);
        return HttpStatus.FORBIDDEN;
    }
}
