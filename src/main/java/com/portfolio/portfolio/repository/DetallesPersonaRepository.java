package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.model.DetallesPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesPersonaRepository extends JpaRepository<DetallesPersona, Long>{
    
}
