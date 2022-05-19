package com.fa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.Entity.NgEntity;


@Repository
public interface NgRepository extends JpaRepository<NgEntity, Long> {
	

}
