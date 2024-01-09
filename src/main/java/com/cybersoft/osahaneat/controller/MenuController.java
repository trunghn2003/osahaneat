package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.payload.ResponseData;
import com.cybersoft.osahaneat.service.impl.CategoryServiceImpl;
import com.cybersoft.osahaneat.service.impl.FileServiceImpl;
import com.cybersoft.osahaneat.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;

@CrossOrigin("*")
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuServiceImpl menuService;
    @Autowired
    CategoryServiceImpl categoryService;
    @Autowired
    FileServiceImpl fileService;
    @PostMapping("")
    public ResponseEntity<?> createMenu(@RequestParam MultipartFile multipartFile
            , @RequestParam String  title

//            ,@RequestParam String   image
            , @RequestParam boolean is_freeship
            , @RequestParam String  time_ship
            , @RequestParam double price
            , @RequestParam int cate_id){
        boolean isSucess = false;
        ResponseData responseData = new ResponseData();
        isSucess = menuService.createMenu(multipartFile, title, is_freeship, time_ship, price, cate_id);
        responseData.setData(isSucess);


        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping("file/{filename:.+}")
    public ResponseEntity<?> getFileFood(@PathVariable String filename){
        Resource resource =  fileService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" +
                                resource.getFilename() + "\"").body(resource);

    }


}
