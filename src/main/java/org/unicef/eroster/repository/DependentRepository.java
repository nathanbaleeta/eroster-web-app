package org.unicef.eroster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unicef.eroster.model.Dependent;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Long> {
}
