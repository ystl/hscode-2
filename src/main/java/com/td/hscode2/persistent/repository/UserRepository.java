package com.td.hscode2.persistent.repository;

import com.td.hscode2.persistent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {

}
