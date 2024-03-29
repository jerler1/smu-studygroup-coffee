package com.company.CoffeeChat.dao;

import com.company.CoffeeChat.dto.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    List<Coffee> findByRoasterId(Integer roasterId);
    List<Coffee> findByType(String type);
    List<Coffee> findByTypeAndRoasterId(String type, Integer roasterId);
}
