package org.unicef.eroster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.eroster.exception.RecordNotFoundException;
import org.unicef.eroster.model.Publication;
import org.unicef.eroster.model.Reference;
import org.unicef.eroster.repository.PublicationRepository;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
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

    public Publication createOrUpdatePublication(Publication entity) throws RecordNotFoundException
    {
        Optional<Publication> publication = repository.findById(entity.getId());

        if(publication.isPresent())
        {
            Publication newEntity = publication.get();
            newEntity.setTitle(entity.getTitle());
            newEntity.setPublisher(entity.getPublisher());
            newEntity.setDatePublished(entity.getDatePublished());
            newEntity.setCityPublished(entity.getCityPublished());
            newEntity.setCountry(entity.getCountry());

            newEntity = repository.saveAndFlush(newEntity);

            return newEntity;
        } else {
            entity = repository.saveAndFlush(entity);
            return entity;
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
