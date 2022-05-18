package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{
    
}
