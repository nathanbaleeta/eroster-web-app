package org.unicef.eroster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.eroster.exception.RecordNotFoundException;
import org.unicef.eroster.model.Relative;
import org.unicef.eroster.repository.RelativeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RelativeService {
    @Autowired
    RelativeRepository repository;

    public List<Relative> getAllRelatives()
    {
        List<Relative> relativeList = repository.findAll();

        if(relativeList.size() > 0) {
            return relativeList;
        } else {
            return new ArrayList<Relative>();
        }
    }

    public Relative getRelativeById(Long id) throws RecordNotFoundException
    {
        Optional<Relative> relative = repository.findById(id);

        if(relative.isPresent()) {
            return relative.get();
        } else {
            throw new RecordNotFoundException("No relative record exists for given id");
        }
    }

    public Relative createOrUpdateRelative(Relative entity) throws RecordNotFoundException
    {
        Optional<Relative> relative = repository.findById(entity.getId());

        if(relative.isPresent())
        {
            Relative newEntity = relative.get();
            newEntity.setName(entity.getName());
            newEntity.setRelationship(entity.getRelationship());
            newEntity.setInternationalOrganization(entity.getInternationalOrganization());

            newEntity = repository.saveAndFlush(newEntity);

            return newEntity;
        } else {
            entity = repository.saveAndFlush(entity);
            return entity;
        }
    }

    public void deleteRelativeById(Long id) throws RecordNotFoundException
    {
        Optional<Relative> relative = repository.findById(id);

        if(relative.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No relative record exists for given id");
        }
    }
}
