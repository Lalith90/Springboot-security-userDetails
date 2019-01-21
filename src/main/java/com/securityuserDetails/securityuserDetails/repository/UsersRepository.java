package com.securityuserDetails.securityuserDetails.repository;

import com.securityuserDetails.securityuserDetails.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByUsername(String username);
}
