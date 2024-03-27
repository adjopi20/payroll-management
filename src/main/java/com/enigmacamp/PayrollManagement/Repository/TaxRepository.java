package com.enigmacamp.PayrollManagement.Repository;

import com.enigmacamp.PayrollManagement.Entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Tax,String> {
}
