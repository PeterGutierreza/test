package com.coralogix.calculator.repository;

import com.coralogix.calculator.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddRepository extends JpaRepository<Result, Long> {

}
