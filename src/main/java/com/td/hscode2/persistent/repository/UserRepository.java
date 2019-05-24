package com.td.hscode2.persistent.repository;

import com.td.hscode2.persistent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
