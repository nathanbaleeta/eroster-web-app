package org.unicef.eroster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unicef.eroster.model.Relative;

@Repository
public interface RelativeRepository extends JpaRepository<Relative, Long> {
}
