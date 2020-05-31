package org.unicef.eroster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unicef.eroster.model.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
