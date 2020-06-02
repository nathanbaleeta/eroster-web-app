package org.unicef.eroster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.eroster.exception.RecordNotFoundException;
import org.unicef.eroster.model.Dependent;
import org.unicef.eroster.repository.DependentRepository;
import org.unicef.eroster.repository.RelativeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DependentService {
    @Autowired
    DependentRepository repository;

    public List<Dependent> getAllDependents()
    {
        List<Dependent> dependentList = repository.findAll();

        if(dependentList.size() > 0) {
            return dependentList;
        } else {
            return new ArrayList<Dependent>();
        }
    }

    public Dependent getDependentById(Long id) throws RecordNotFoundException
    {
        Optional<Dependent> dependent = repository.findById(id);

        if(dependent.isPresent()) {
            return dependent.get();
        } else {
            throw new RecordNotFoundException("No dependent record exists for given id");
        }
    }

    public Dependent createOrUpdateDependent(Dependent entity) throws RecordNotFoundException
    {
        Optional<Dependent> dependent = repository.findById(entity.getId());

        if(dependent.isPresent())
        {
            Dependent newEntity = dependent.get();
            newEntity.setName(entity.getName());
            newEntity.setDateOfBirth(entity.getDateOfBirth());
            newEntity.setRelationship(entity.getRelationship());

            newEntity = repository.saveAndFlush(newEntity);

            return newEntity;
        } else {
            entity = repository.saveAndFlush(entity);
            return entity;
        }
    }

    public void deleteDependentById(Long id) throws RecordNotFoundException
    {
        Optional<Dependent> dependent = repository.findById(id);

        if(dependent.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No dependent record exists for given id");
        }
    }
}
