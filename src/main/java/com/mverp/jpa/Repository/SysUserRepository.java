package com.mverp.jpa.Repository;

import com.mverp.jpa.entity.SysUserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SysUserRepository  extends JpaRepository<SysUserEntity, String> {
    SysUserEntity findByUsername(String username);
}
