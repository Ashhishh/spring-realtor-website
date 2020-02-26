package com.example.demo.repository;

import com.example.demo.model.Pg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PgRepository")
public interface PgRepository extends CrudRepository<Pg, Integer> {
 Pg findById(int user_id);
}	