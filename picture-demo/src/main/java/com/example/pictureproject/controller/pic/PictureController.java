package com.example.pictureproject.controller.pic;


import com.example.pictureproject.entity.YwZdgl;
import com.example.pictureproject.service.YwZdglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PictureController {


    private ModelAndView view;
    private ModelMap map;

    @Autowired
    private YwZdglService ywZdglService;

    @RequestMapping ("toPicIndex")
    public ModelAndView toPicIndex() {
        view = new ModelAndView();
        view.setViewName("pic/pic_index");
        return view;
    }

    @RequestMapping ("toPicAdd")
    public ModelAndView toPicAdd(ModelMap map) {
        view = new ModelAndView();

        try {
            List<YwZdgl> ywZdglList = new ArrayList<>();
            ywZdglList = ywZdglService.getZdglData("");
            map.put("ywZdglList", ywZdglList);
            view.setViewName("pic/pic_add");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }


    @RequestMapping (value = "doSavePic", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap doSavePic(HttpServletRequest request,
                              @RequestParam (value = "file", required = false) MultipartFile multipartFile) {
        map = new ModelMap();
        String zdid = request.getParameter("zdid");
        String pname = request.getParameter("pname");
        String pdescribe = request.getParameter("pdescribe");

        try {
            System.out.println();
            map.put("msg", "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "保存失败！");
        }

        return map;
    }


}
