package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.payload.ResponseData;
import com.cybersoft.osahaneat.service.impl.FileServiceImpl;
import com.cybersoft.osahaneat.service.impl.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.Date;
@CrossOrigin("*")
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    FileServiceImpl fileService;
    @Autowired
    RestaurantServiceImpl restaurantService;
    @PostMapping("")
    public ResponseEntity<?> createRetaurant(@RequestParam MultipartFile multipartFile
            ,@RequestParam String  title
            ,@RequestParam String  subtitle
            ,@RequestParam String  description
//            ,@RequestParam String   image
            ,@RequestParam boolean is_freeship
            ,@RequestParam String   address
            ,@RequestParam String openDate){
        boolean isSucess = false;
        ResponseData responseData = new ResponseData();
        try {
             isSucess = restaurantService.insertRestaurant(multipartFile, title, subtitle, description, is_freeship, address, openDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }
    @GetMapping("")
    public ResponseEntity<?> getHomePageRestaurant(){
        ResponseData responseData= new ResponseData();
        responseData.setData(restaurantService.getAllRestaurant());

        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }
    @GetMapping("file/{filename:.+}")
    public ResponseEntity<?> getFileRestaurant  (@PathVariable String filename){
        Resource resource =  fileService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" +
                                resource.getFilename() + "\"").body(resource);

    }

    // lay thong tin restaurant tu id
    @GetMapping("/detail")
    public ResponseEntity<?> getDetailRestaurant(@RequestParam int id){
        ResponseData responseData= new ResponseData();
//        List<Re>
//
        responseData.setData(restaurantService.getDetailRestaurant(id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

}
