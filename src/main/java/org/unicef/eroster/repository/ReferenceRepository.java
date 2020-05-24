package org.unicef.eroster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unicef.eroster.model.Reference;

@Repository
public interface ReferenceRepository extends JpaRepository<Reference, Long> {
}
