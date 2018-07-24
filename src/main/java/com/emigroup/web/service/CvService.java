package com.emigroup.web.service;

import com.emigroup.web.dao.CvMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Service
@Transactional
public class CvService {

    @Resource
    CvMapper cvMapper;
    public static final String UserImgPath=File.separator+"userImg";

    public String getFilePath(MultipartFile file, HttpServletRequest request){

        String originalName = file.getOriginalFilename();
        // generate file name
        String localFileName = System.currentTimeMillis() + "-" + originalName;
        // get project path
        String projectRealPath = request.getSession().getServletContext().getRealPath("");
        // get the real path to store received images
        String realPath = projectRealPath + UserImgPath;
        File imageDir = new File(realPath);
        if(!imageDir.exists()) {
            imageDir.mkdirs();
        }

        String localFilePath = realPath + File.separator + localFileName;
        try {
            file.transferTo(new File(localFilePath));
        } catch (IllegalStateException e) {
            e.printStackTrace();
            // log here
        } catch (IOException e) {
            e.printStackTrace();
            // log here
        }

        String imageContextPath = request.getContextPath() + UserImgPath + File.separator + localFileName;
        System.out.println("received file original name: " + originalName);
        System.out.println("stored local file name: " + localFileName);
        System.out.println("file stored path: " + localFilePath);
        System.out.println("returned url: " + imageContextPath);

        return imageContextPath;
    }

    public String insert(MultipartFile file,String name,String position,String userdes,String email,String interest,String office,String award,HttpServletRequest request){

        String imgpath = getFilePath(file,request);
        cvMapper.insert(name,position,userdes,imgpath,email,interest,office,award);
        return "success";
    }
}
