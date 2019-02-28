package com.emigroup.web.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/")
@Controller
public class AdminController {
    @RequestMapping(value = "/index")
    public ModelAndView hello(Model model) {
        model.addAttribute("name", "苏凌");
        return new ModelAndView("index");
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logininfo")
    public String login(HttpServletRequest req, HttpServletResponse res,
                        RedirectAttributes attr) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("action submitted");
        System.out.println(username);
        System.out.println(password);

        System.out.println(username.equals("emilab1"));
        System.out.println(password.equals("emilab1"));

        if (username.equals("emilab1") && password.equals("emilab1")){

                System.out.println("loginfo is correct");
                req.getSession().setAttribute("username",username);
                req.getSession().setAttribute("password",password);
                return "redirect:/emi.html";
            }

           else if(!(username.equals("emilab1")&&password.equals("emilab1"))){
            attr.addFlashAttribute("login_error_alert","用户名或密码错误");
               return "redirect:/login";
           }

           return "redirect:/emi.html";
    }

    @RequestMapping("/manage/showcv")
    public String showCv(){
        return "/manage/showcv";
    }
    @RequestMapping("/manage/showpaper")
    public String showPaper(){
        return "/manage/showpaper";
    }
    @RequestMapping("/manage/showresearch")
    public String showResearch(){
        return "/manage/showresearch";
    }
    @RequestMapping("/manage/shownew")
    public String showNews(){
        return "/manage/shownew";
    }


    @RequestMapping("/manage/addcv")
    public String addCv(){
        return "/manage/addcv";
    }
    @RequestMapping("/manage/addnew")
    public String addNew(){
        return "/manage/addnew";
    }
    @RequestMapping("/manage/addpub")
    public String addPub(){
        return "/manage/addpub";
    }
    @RequestMapping("/manage/addresearch")
    public String addResearch(){
        return "/manage/addresearch";
    }

    @RequestMapping("/manage/modifycv")
    public String modifyCv(){
        return "/manage/modifyCv";
    }
    @RequestMapping("/manage/modifynew")
    public String modifyNew(){
        return "/manage/modifynew";
    }
    @RequestMapping("/manage/modifypaper")
    public String modifyPaper(){
        return "/manage/modifypaper";
    }
    @RequestMapping("/.idea/**")
    public String workspace(){
        return "stop now!";
    }



}
