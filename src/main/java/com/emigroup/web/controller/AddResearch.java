package com.emigroup.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.emigroup.web.service.ResearhService;
import com.emigroup.web.vo.Research;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/research")
@Controller
public class AddResearch {
    @Resource
    ResearhService researhService;
    @ResponseBody
    @RequestMapping(value={"/addresearch"},method=RequestMethod.POST)
    public String addcv(@RequestParam("imgfile") MultipartFile file, @RequestParam("title") String title, @RequestParam("abs") String abs,
                        @RequestParam("text") String text,HttpServletRequest request){
        System.out.println("tile: = "+title);
        System.out.println("abs: = "+abs);
        System.out.println("text: = "+text);


        researhService.insert(file,title,abs,text,request);

        return "success";
    }


    @ResponseBody
    @RequestMapping(value={"/getresearch"},method=RequestMethod.POST)
    public List<Research> getcv(){
        return researhService.findAll();
    }

    @ResponseBody
    @RequestMapping(value={"/getbyid"},method=RequestMethod.POST)
    public Research getCvById(int id){
        return researhService.findById(id);
    }
    @ResponseBody
    @RequestMapping(value={"/updatecv"},method=RequestMethod.POST)
    public String updateNews(Research research){
        researhService.update(research);
        return "success";


    }
    @ResponseBody
    @RequestMapping(value={"/deleteResearch"},method=RequestMethod.POST)
    public String deleteById(int id){
        researhService.deleteById(id);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value={"/jsontest"},method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String testJson(@RequestParam(value="awards",required = true)JSONObject awards){
        System.out.println(awards);

        return "successful";


    }
}
