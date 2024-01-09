package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.entity.Category;
import com.cybersoft.osahaneat.entity.Food;
import com.cybersoft.osahaneat.entity.Restaurant;
import com.cybersoft.osahaneat.repository.FoodRepository;
import com.cybersoft.osahaneat.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class MenuService implements MenuServiceImpl {
    @Autowired
    FileService fileService;
    @Autowired
    FoodRepository foodRepository;
    @Override
    public boolean createMenu(MultipartFile multipartFile, String title, boolean is_freeship, String time_ship, double price, int cate_id) {
        boolean isSucess = fileService.saveFile(multipartFile);
        boolean isInsertSucess = false;
        if (isSucess) {
            Food food = new Food();
            food.setTitle(title);
            food.setImage(multipartFile.getOriginalFilename());
            food.setPrice(price)  ;
            food.setTimeShip(time_ship);

            Category category = new Category();
            category.setId(cate_id);
            food.setCategory(category);
            foodRepository.save(food);

            isInsertSucess = true;
        }
        return isInsertSucess;

//        return false;
    }
}
