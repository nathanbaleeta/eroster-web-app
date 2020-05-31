package org.unicef.eroster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unicef.eroster.model.Publication;
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
}
