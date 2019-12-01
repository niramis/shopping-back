package com.shop.repository;

import com.shop.model.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDao extends JpaRepository<DAOUser, Long> {

    DAOUser findByUsername(String username);

    List<DAOUser> findUsersByUsername(String username);

/*
	Optional<User> findByEmail(String email);

	Optional<User> findByUsernameOrEmail(String username, String email);

	List<User> findByIdIn(List<Long> userIds);

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	*/
}