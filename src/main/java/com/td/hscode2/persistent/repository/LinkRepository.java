package com.td.hscode2.persistent.repository;


import com.td.hscode2.persistent.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface LinkRepository extends JpaRepository<Link,Integer>{

}

