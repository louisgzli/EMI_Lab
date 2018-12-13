package com.emigroup.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.emigroup.web.service.PaperService;
import com.emigroup.web.vo.Paper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/addpub")
public class AddPubController {
    @Resource
    PaperService paperService;


    @ResponseBody
    @RequestMapping(value = {"/addpub"}, method = RequestMethod.POST)
    public String addpub(Model model, Paper paper) {
        paperService.addPaper(paper);

        System.out.println(paper);
        

        return "{\"hello\":true}";


    }

    @ResponseBody
    @RequestMapping(value={"/findyear"},method=RequestMethod.POST)
    public List<Integer> findYear(Model model){
        //自定义Comparator对象，自定义排序
        Comparator invertDictOrder = new Comparator<Integer>() {//倒序
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                if((int)o1<(int)o2)
                    return 1;
                    //注意！！返回值必须是一对相反数，否则无效。jdk1.7以后就是这样。
                    //		else return 0; //无效
                else return -1;
            }
        };

        System.out.println("findyear started");
        ArrayList<Integer>yearList = new ArrayList<Integer>(paperService.findYear());
        Collections.sort(yearList,invertDictOrder);
        model.addAttribute("yearList",yearList);
        System.out.println(yearList);
        return yearList;
    }

    @ResponseBody
    @RequestMapping(value={"/findpaper"},method=RequestMethod.POST)
    public List<Paper> findPaper(Model model){
        return paperService.findPaper();
    }

    @ResponseBody
    @RequestMapping(value={"/findbyid"},method=RequestMethod.POST)
    public Paper findById(int id){
        return paperService.findById(id);

    }
    @ResponseBody
    @RequestMapping(value={"/findpub"},method=RequestMethod.POST)
    public JSONObject findPub(){
        Comparator invertDictOrder = new Comparator<Integer>() {//倒序
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                if((int)o1<(int)o2)
                    return 1;
                    //注意！！返回值必须是一对相反数，否则无效。jdk1.7以后就是这样。
                    //		else return 0; //无效
                else return -1;
            }
        };
        JSONObject jsonObject = new JSONObject();
        ArrayList<Integer>yearList = new ArrayList<Integer>(paperService.findYear());
        Collections.sort(yearList,invertDictOrder);

        List<Paper> paperList = paperService.findPaper();
        jsonObject.put("yearList",yearList);
        jsonObject.put("paperList",paperList);
        return jsonObject;



    }
    @ResponseBody
    @RequestMapping(value={"/updatepaper"},method=RequestMethod.POST)
    public String updateNews(Paper paper){
        paperService.update(paper);
        return "success";


    }
    @ResponseBody
    @RequestMapping(value={"/deletepaper"},method=RequestMethod.POST)
    public String deleteById(int id){
        paperService.deleteById(id);
        return "success";
    }


}
