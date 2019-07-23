package com.example.pictureproject.service.impl;

import com.example.pictureproject.dao.YwYjtpDao;
import com.example.pictureproject.service.YwYjtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository ("ywYjtpService")
public class YwYjtpServiceImpl implements YwYjtpService {

    @Autowired
    private YwYjtpDao ywYjtpDao;

    @Override
    public void doSavePic(String zdid, String pname, String pdescribe, String path, String creater) {
        ywYjtpDao.doSavePic(zdid, pname, pdescribe, path, creater);
    }


}
