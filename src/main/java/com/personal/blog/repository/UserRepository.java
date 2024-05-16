package com.personal.blog.repository;

import com.personal.blog.model.UserModel;
import com.personal.blog.model.enumtype.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findByEmail(String email);
    UserModel findByRoles(RoleEnum roles);
}