package com.cybersoft.osahaneat.service.impl;

import com.cybersoft.osahaneat.dto.RestaurantDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface  RestaurantServiceImpl {
    boolean insertRestaurant( MultipartFile multipartFile, String  title, String  subtitle
            , String  description, boolean is_freeship
            , String   address, String openDate) throws ParseException;

    List<RestaurantDTO> getAllRestaurant();
}
