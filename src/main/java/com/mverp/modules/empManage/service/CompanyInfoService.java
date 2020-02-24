package com.mverp.modules.empManage.service;

import com.mverp.mybatis.domain.dao.Combobox;

import java.util.List;

public interface CompanyInfoService {

    List<Combobox> selectDepartComboboxData();
}
