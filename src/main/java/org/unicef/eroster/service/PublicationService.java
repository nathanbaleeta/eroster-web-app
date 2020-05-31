package org.unicef.eroster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.eroster.model.Publication;
import org.unicef.eroster.repository.PublicationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicationService {
    @Autowired
    PublicationRepository repository;

    public List<Publication> getAllPublications()
    {
        List<Publication> publicationList = repository.findAll();

        if(publicationList.size() > 0) {
            return publicationList;
        } else {
            return new ArrayList<Publication>();
        }
    }
}
