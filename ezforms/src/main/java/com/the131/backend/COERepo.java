package com.the131.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface COERepo extends JpaRepository<COE, Long> {
    List<COE> findAllBy();
}
