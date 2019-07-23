package com.example.pictureproject.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository ("ywYjtpDao")
public interface YwYjtpDao {
    void doSavePic(@Param ("zdid") String zdid, @Param ("pname") String pname, @Param ("pdescribe") String pdescribe,
                   @Param ("path") String path, @Param ("creater") String creater);
}
