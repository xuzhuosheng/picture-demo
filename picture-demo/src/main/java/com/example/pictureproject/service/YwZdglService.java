package com.example.pictureproject.service;

import com.example.pictureproject.entity.YwZdgl;

import java.util.List;

public interface YwZdglService {
    List<YwZdgl> getZdglData();

    void insertZdgl(String sname, String sdescribe, String surl,String username);
}
