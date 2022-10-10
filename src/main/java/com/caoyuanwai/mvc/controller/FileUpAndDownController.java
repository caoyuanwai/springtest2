package com.caoyuanwai.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
public class FileUpAndDownController {
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        InputStream is = new FileInputStream(realPath);
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        is.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
//        获取上传的文件的文件名
        String fileName = photo.getOriginalFilename();
//        获取上传的文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        将UUID作为文件名
        String uuid = UUID.randomUUID().toString();
        fileName = uuid+suffixName;
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finlPath = photoPath+File.separator+fileName;
        photo.transferTo(new File(finlPath));

        return "success";
    }
}
