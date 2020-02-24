package com.mverp.mybatis.domain.mapper;

import com.mverp.mybatis.domain.dao.Combobox;

import java.util.List;

public interface ComboboxMapper {
    List<Combobox> selectDepartNameList();
}
