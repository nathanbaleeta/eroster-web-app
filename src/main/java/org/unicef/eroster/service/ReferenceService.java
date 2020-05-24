package org.unicef.eroster.service;

import org.unicef.eroster.exception.RecordNotFoundException;
import org.unicef.eroster.model.Reference;
import org.unicef.eroster.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReferenceService {
    @Autowired
    ReferenceRepository repository;

    public List<Reference> getAllReferences()
    {
        List<Reference> referenceList = repository.findAll();

        if(referenceList.size() > 0) {
            return referenceList;
        } else {
            return new ArrayList<Reference>();
        }
    }

    public Reference getReferenceById(Long id) throws RecordNotFoundException
    {
        Optional<Reference> reference = repository.findById(id);

        if(reference.isPresent()) {
            return reference.get();
        } else {
            throw new RecordNotFoundException("No reference record exists for given id");
        }
    }
}
