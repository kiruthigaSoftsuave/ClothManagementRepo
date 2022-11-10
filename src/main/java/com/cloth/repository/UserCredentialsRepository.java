package com.cloth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cloth.entity.UserCredentials;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Integer>{
//	@Query("SELECT t FROM UserCredentials t WHERE t.email=:email AND t.password=:password" )
	public UserCredentials findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
//	@Query("SELECT t FROM UserCredentials t WHERE t.email=?1")
	public UserCredentials findByEmail(String email);

}
