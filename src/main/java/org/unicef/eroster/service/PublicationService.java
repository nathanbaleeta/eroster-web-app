package org.unicef.eroster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.eroster.exception.RecordNotFoundException;
import org.unicef.eroster.model.Publication;
import org.unicef.eroster.model.Reference;
import org.unicef.eroster.repository.PublicationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Publication getPublicationById(Long id) throws RecordNotFoundException
    {
        Optional<Publication> publication = repository.findById(id);

        if(publication.isPresent()) {
            return publication.get();
        } else {
            throw new RecordNotFoundException("No publication record exists for given id");
        }
    }

    public void deletePublicationById(Long id) throws RecordNotFoundException
    {
        Optional<Publication> publication = repository.findById(id);

        if(publication.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No publication record exists for given id");
        }
    }
}
