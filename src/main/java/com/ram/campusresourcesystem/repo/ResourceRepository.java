package com.ram.campusresourcesystem.repo;
import com.ram.campusresourcesystem.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}