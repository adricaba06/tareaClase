package com.salesianostriana.dam.rest.repository;

import com.salesianostriana.dam.rest.model.Monument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonumentRepository extends JpaRepository<Monument, Long> {
}
