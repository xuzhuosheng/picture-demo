package com.example.pictureproject.service.impl;


import com.example.pictureproject.dao.YwZdglDao;
import com.example.pictureproject.entity.YwZdgl;
import com.example.pictureproject.service.YwZdglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository ("ywZdglService")
public class YwZdglServiceImpl implements YwZdglService {

    @Autowired
    private YwZdglDao ywZdglDao;

    private List<YwZdgl> dataList;

    @Override
    public List<YwZdgl> getZdglData() {
        dataList = new ArrayList<>();
        dataList = ywZdglDao.getZdglData();
        return dataList;
    }

    @Override
    public void insertZdgl(String sname, String sdescribe, String surl, String username) {
        ywZdglDao.insertZdgl(sname, sdescribe, surl, username);
    }
}
