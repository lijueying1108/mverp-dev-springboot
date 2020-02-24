package com.mverp.jpa.Repository;

import com.mverp.jpa.entity.SysRoleEntity;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysRoleRepository extends JpaRepository<SysRoleEntity,String> {
    @Query(nativeQuery = true, value="select b.id, b.name FROM sys_role b, sys_user a,sys_user_role c where c.sys_role_id = b.id and c.sys_user_id = a.id and a.username=:username")
    List<SysRoleEntity> findRoleByUsername (@Param("username") String username);
}
