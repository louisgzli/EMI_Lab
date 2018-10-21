package com.emigroup.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.emigroup.web.service.CvService;
import com.emigroup.web.vo.Cv;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping("/cv")
@Controller
public class UploadCvController {
    @Resource
    CvService cvService;
    @ResponseBody
    @RequestMapping(value={"/addcv"},method=RequestMethod.POST)
    public String addcv(@RequestParam("imgfile") MultipartFile file, @RequestParam("name") String name, @RequestParam("position") String position,
                        @RequestParam("describe") String describe,@RequestParam("email")String email,@RequestParam("interest")String interest,@RequestParam("office")String office,@RequestParam("award")String award, HttpServletRequest request){
        System.out.println("name: = "+name);
        System.out.println("position: = "+position);
        System.out.println("describe: = "+describe);
        System.out.println("email: = "+email);
        System.out.println("interest: = "+interest);
        System.out.println("office: = "+office);
        System.out.println("award: = "+award);

            cvService.insert(file,name,position,describe,email,interest,office,award,request);

    return "success";
    }


    @ResponseBody
    @RequestMapping(value={"/getcv"},method=RequestMethod.POST)
    public List<Cv> getcv(){
        return cvService.findAll();
    }

    @ResponseBody
    @RequestMapping(value={"/getbyid"},method=RequestMethod.POST)
    public Cv getCvById(int id){
        return cvService.findById(id);
    }
    @ResponseBody
    @RequestMapping(value={"/updatecv"},method=RequestMethod.POST)
    public String updateNews(Cv cv){
        cvService.update(cv);
        return "success";


    }
    @ResponseBody
    @RequestMapping(value={"/deletecv"},method=RequestMethod.POST)
    public String deleteById(int id){
        cvService.deleteById(id);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value={"/jsontest"},method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String testJson(@RequestParam(value="awards",required = true)JSONObject awards){
        System.out.println(awards);

        return "successful";


    }


}
