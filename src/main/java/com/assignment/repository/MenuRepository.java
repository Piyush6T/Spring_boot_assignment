package com.assignment.repository;

import com.assignment.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
