package com.example.pictureproject.entity;


import java.io.Serializable;
import java.sql.Date;

public class YwYjtp implements Serializable {


    private int id;
    private int zdid;
    private String pname;
    private String describe;
    private String creater;
    private Date createtime;
    private String bz;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZdid() {
        return zdid;
    }

    public void setZdid(int zdid) {
        this.zdid = zdid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
