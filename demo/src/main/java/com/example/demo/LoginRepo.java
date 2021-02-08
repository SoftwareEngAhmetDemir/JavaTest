package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  LoginRepo extends CrudRepository<LoginEntity, Integer> {
	@Query(
			  value = "SELECT * FROM login u WHERE u.username = ?1", 
			  nativeQuery = true)
	LoginEntity findUserByStatusNative(String username);
}
