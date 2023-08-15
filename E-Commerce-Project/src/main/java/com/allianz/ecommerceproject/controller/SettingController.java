package com.allianz.ecommerceproject.controller;

import com.allianz.ecommerceproject.database.entity.SettingEntity;
import com.allianz.ecommerceproject.database.repository.SettingEntityRepository;
import com.allianz.ecommerceproject.mapper.SettingMapper;
import com.allianz.ecommerceproject.model.SettingDTO;
import com.allianz.ecommerceproject.model.requestDTO.SettingRequestDTO;
import com.allianz.ecommerceproject.service.SettingService;
import com.allianz.ecommerceproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("setting")
public class SettingController extends BaseController<SettingDTO, SettingEntity, SettingRequestDTO, SettingMapper,
        SettingEntityRepository, SettingService> {

    @Autowired
    private SettingService settingService;

    @Override
    protected SettingService getBaseService() {
        return settingService;
    }

}
