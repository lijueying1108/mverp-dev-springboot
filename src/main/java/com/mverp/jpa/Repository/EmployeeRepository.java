package com.mverp.jpa.Repository;

import com.mverp.jpa.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {
    List<EmployeeEntity> findEmployeeInfoByName(String name);
    EmployeeEntity findEmpById(String id);
}
