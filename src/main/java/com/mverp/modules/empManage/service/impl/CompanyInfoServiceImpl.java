package com.mverp.modules.empManage.service.impl;

import com.mverp.modules.empManage.service.CompanyInfoService;
import com.mverp.mybatis.domain.dao.Combobox;
import com.mverp.mybatis.domain.mapper.ComboboxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Autowired
    private ComboboxMapper comboboxMapper;

    @Override
    public List<Combobox> selectDepartComboboxData() {
        return comboboxMapper.selectDepartNameList();
    }
}
