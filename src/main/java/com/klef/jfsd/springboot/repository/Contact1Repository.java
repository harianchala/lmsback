package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Contact1;

@Repository

public interface Contact1Repository extends JpaRepository<Contact1,Integer>{

	
}
