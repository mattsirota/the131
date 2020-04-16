package com.the131.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface COERepo extends JpaRepository<ChangeEnrollment, Long> {

}
