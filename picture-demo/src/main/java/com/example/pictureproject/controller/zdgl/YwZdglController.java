package com.example.pictureproject.controller.zdgl;


import com.example.pictureproject.entity.TXtUser;
import com.example.pictureproject.entity.YwZdgl;
import com.example.pictureproject.service.YwZdglService;
import com.sun.net.httpserver.HttpsConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class YwZdglController {

    private ModelAndView view;
    private ModelMap map;
    private List<YwZdgl> dataList;
    @Autowired
    private YwZdglService ywZdglService;

    @RequestMapping (value = "toZdglIndex")
    public ModelAndView toZdglIndex(ModelMap map) {
        view = new ModelAndView();

        try {
            dataList = new ArrayList<>();
            dataList = ywZdglService.getZdglData();
            map.put("dataList", dataList);
            view.setViewName("zdgl/zdgl_index");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        return view;
    }

    @RequestMapping ("toZdglAdd")
    public ModelAndView toZdglAdd() {
        view = new ModelAndView();
        view.setViewName("zdgl/zdgl_add");
        return view;
    }


    @RequestMapping (value = "doSaveZdgl", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap doSaveZdgl(HttpServletRequest request, HttpSession session) {
        map = new ModelMap();
        String sname = request.getParameter("sname");
        String sdescribe = request.getParameter("sdescribe");
        String surl = request.getParameter("surl");
        TXtUser tXtUser = (TXtUser) session.getAttribute("user");
        String username = tXtUser.getUsername();
        try {
            ywZdglService.insertZdgl(sname, sdescribe, surl, username);
            map.put("msg", "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "保存失败！" + e.getMessage());

        }

        return map;
    }
}
