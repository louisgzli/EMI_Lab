package com.emigroup.web.controller;

import com.emigroup.web.service.PaperService;
import com.emigroup.web.vo.Paper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/addpub")
public class AddPubController {
    @Resource
    PaperService paperService;


    @ResponseBody
    @RequestMapping(value = {"/addpub"}, method = RequestMethod.POST)
    public String addpub(Model model, Paper paper) {
        paperService.andPaper(paper);
        System.out.println(paper);

        return "{\"hello\":true}";


    }

    @ResponseBody
    @RequestMapping(value={"/findyear"},method=RequestMethod.POST)
    public List<Integer> findYear(Model model){
        System.out.println("findyear started");
        ArrayList<Integer>yearList = new ArrayList<Integer>(paperService.findYear());
        model.addAttribute("yearList",yearList);
    System.out.println(yearList);
        return yearList;
    }

    @ResponseBody
    @RequestMapping(value={"/findpaper"},method=RequestMethod.POST)
    public List<Paper> findPaper(Model model){
        return paperService.findPaper();
    }


}
