package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.dto.RestaurantDTO;
import com.cybersoft.osahaneat.entity.RatingRestaurant;
import com.cybersoft.osahaneat.entity.Restaurant;
import com.cybersoft.osahaneat.repository.RestaurantRepository;
import com.cybersoft.osahaneat.service.impl.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Service
public class RestaurantService implements RestaurantServiceImpl {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    FileService fileService;

    @Override
    public boolean insertRestaurant(MultipartFile multipartFile, String title, String subtitle, String description, boolean is_freeship, String address, String openDate) {
        boolean isSucess = fileService.saveFile(multipartFile);
        boolean isInsertSucess = false;
        if (isSucess) {
            Restaurant restaurant = new Restaurant();
            restaurant.setTitle(title);
            restaurant.setSubtitle(subtitle);
            restaurant.setAddress(address);
            restaurant.setDesc(description);
            restaurant.setFreeship(is_freeship);
            restaurant.setImage(multipartFile.getOriginalFilename());
            SimpleDateFormat f = new SimpleDateFormat("yyyy-dd-MM hh:mm");
            try {
                restaurant.setOpen_Date(f.parse(openDate));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            restaurantRepository.save(restaurant);
            isInsertSucess = true;
        }
        return isInsertSucess;
    }

    @Override
    public List<RestaurantDTO> getAllRestaurant() {

        PageRequest pageRequest = PageRequest.of(0,6);
       Page<Restaurant> listRes = restaurantRepository.findAll(pageRequest);
       List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
       for(Restaurant i : listRes){
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setFreeship(i.isFreeship());

            restaurantDTO.setImage(i.getImage());
            restaurantDTO.setTitle(i.getTitle());
            restaurantDTO.setSubtitle(i.getSubtitle());
            restaurantDTO.setFreeship(i.isFreeship());
            restaurantDTO.setRating(caculatorRating(i.getListRatingRestaurant()));
            restaurantDTOList.add(restaurantDTO);
       }


       return restaurantDTOList;
    }
    private double caculatorRating(Set<RatingRestaurant> listRating){
        double res = 0;
        for(RatingRestaurant i : listRating){
            res += i.getRatePoint();
        }
        return res/listRating.size();
    }

}
