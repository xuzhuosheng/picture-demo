package com.example.pictureproject.controller.pic;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PictureController {


    private ModelAndView view;

    @RequestMapping ("toPicIndex")
    public ModelAndView toPicIndex() {
        view = new ModelAndView();
        view.setViewName("pic/pic_index");
        return view;
    }

    @RequestMapping ("toPicAdd")
    public ModelAndView toPicAdd() {
        view = new ModelAndView();
        view.setViewName("pic/pic_add");
        return view;
    }

}
