package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.BlogEntity;

public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {

}
