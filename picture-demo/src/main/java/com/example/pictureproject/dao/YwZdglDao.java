package com.example.pictureproject.dao;


import com.example.pictureproject.entity.YwZdgl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository ("ywZdglDao")
public interface YwZdglDao {
    List<YwZdgl> getZdglData();

    void insertZdgl(@Param ("sname") String sname, @Param ("sdescribe") String sdescribe, @Param ("surl") String surl,
                    @Param ("username") String username);
}
