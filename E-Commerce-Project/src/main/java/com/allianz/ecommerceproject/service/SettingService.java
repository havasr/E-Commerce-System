package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.SettingEntity;
import com.allianz.ecommerceproject.database.repository.SettingEntityRepository;
import com.allianz.ecommerceproject.mapper.SettingMapper;
import com.allianz.ecommerceproject.model.SettingDTO;
import com.allianz.ecommerceproject.model.requestDTO.SettingRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import com.allianz.ecommerceproject.util.IBaseMapper;
import com.allianz.ecommerceproject.util.dbutil.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class SettingService extends BaseService<SettingDTO,SettingEntity,SettingRequestDTO,
        SettingEntityRepository, SettingMapper> {

    @Autowired
    SettingEntityRepository settingEntityRepository;

    @Autowired
    SettingMapper settingMapper;

    @Override
    protected SettingMapper getBaseMapper() {
        return settingMapper;
    }

    @Override
    protected SettingEntityRepository getBaseRepository() {
        return settingEntityRepository;
    }
}
