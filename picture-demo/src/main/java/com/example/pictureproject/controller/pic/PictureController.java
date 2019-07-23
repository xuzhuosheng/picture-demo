package com.example.pictureproject.controller.pic;


import com.example.pictureproject.entity.TXtUser;
import com.example.pictureproject.entity.YwYjtp;
import com.example.pictureproject.entity.YwZdgl;
import com.example.pictureproject.service.YwYjtpService;
import com.example.pictureproject.service.YwZdglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class PictureController {


    private ModelAndView view;
    private ModelMap map;
    private List<YwYjtp> dataList;

    @Value ("${uploadFilePath}")
    private String uploadFilePath;

    @Autowired
    private YwZdglService ywZdglService;

    @Autowired
    private YwYjtpService ywYjtpService;

    @RequestMapping ("toPicIndex")
    public ModelAndView toPicIndex(HttpServletRequest request, ModelMap map) {
        view = new ModelAndView();
        String searchContent = request.getParameter("searchContent");
        String zdid = request.getParameter("zdid");
        try {
            List<YwZdgl> ywZdglList = new ArrayList<>();
            dataList = ywYjtpService.getYjtpData(searchContent, zdid);
            ywZdglList = ywZdglService.getZdglData("");
            map.put("ywZdglList", ywZdglList);
            map.put("dataList", dataList);
            map.put("searchContent", searchContent);
            map.put("zdid", zdid);
            view.setViewName("pic/pic_index");

        } catch (Exception e) {
            e.printStackTrace();
        }


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
                              @RequestParam (value = "file", required = false) MultipartFile multipartFile,
                              HttpSession session) {
        map = new ModelMap();
        String zdid = request.getParameter("zdid");
        String pname = request.getParameter("pname");
        String pdescribe = request.getParameter("pdescribe");
        TXtUser user = (TXtUser) session.getAttribute("user");
        String creater = user.getUsername();
        String path = "";
        try {

            if (multipartFile.getSize() > 0) {
                String imgFileName = multipartFile.getOriginalFilename();
                Date date = new Date();
                long time = date.getTime();
                path = time + "_" + imgFileName;
                File targetFile = new File(uploadFilePath, path);
                multipartFile.transferTo(targetFile);
            }

            ywYjtpService.doSavePic(zdid, pname, pdescribe, path, creater);

            map.put("msg", "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "保存失败！");
        }

        return map;
    }


    @RequestMapping (value = "doPicDel", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap doPicDel(HttpServletRequest request) {
        map = new ModelMap();
        String ids = request.getParameter("ids");
        try {
            String idArr[] = ids.split(",");
            List<String> idList = Arrays.asList(idArr);
            ywYjtpService.doPicDel(idList);
            map.put("msg", "删除成功！");

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "删除失败！" + e.getMessage());
        }
        return map;

    }

    @RequestMapping (value = "toPicEdit", method = RequestMethod.GET)
    public ModelAndView toPicEdit(HttpServletRequest request, ModelMap map) {
        String id = request.getParameter("id");
        try {
            view = new ModelAndView();
            view.setViewName("pic/pic_edit");
            dataList = new ArrayList<>();
            dataList = ywYjtpService.getYjtpDataById(id);
            List<YwZdgl> ywZdglList = new ArrayList<>();
            ywZdglList = ywZdglService.getZdglData("");
            map.put("dataList", dataList);
            map.put("ywZdglList", ywZdglList);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());

        }
        return view;
    }


    /*-----------------------------------*/
    @RequestMapping (value = "toEjtpIndex")
    public ModelAndView toEjtpIndex(HttpServletRequest request, ModelMap map) {
        view = new ModelAndView();
        view.setViewName("pic/ejpic_index");
        return view;
    }

}
