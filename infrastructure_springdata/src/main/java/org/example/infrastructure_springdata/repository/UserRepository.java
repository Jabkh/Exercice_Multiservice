package org.example.infrastructure_springdata.repository;

import org.example.infrastructure_springdata.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}