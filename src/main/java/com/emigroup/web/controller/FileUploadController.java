package com.emigroup.web.controller;

import com.emigroup.web.service.AttachmentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/addimage")
@Controller
public class FileUploadController {

    @Resource
    AttachmentServiceImpl attachmentService;
    @RequestMapping("/uploadImage.do")
    @ResponseBody
    public Map<String, String> receiveImage(@RequestPart("upload") MultipartFile file, HttpServletRequest request) {
        return attachmentService.ckEditorUploadImage(file, request);
    }



}
