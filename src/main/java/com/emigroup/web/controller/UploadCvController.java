package com.emigroup.web.controller;

import com.emigroup.web.service.CvService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RequestMapping("/addcv")
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


}
