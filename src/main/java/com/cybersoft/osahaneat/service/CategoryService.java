package com.cybersoft.osahaneat.service;
import com.cybersoft.osahaneat.dto.CategoryDTO;
import com.cybersoft.osahaneat.dto.MenuDTO;
import com.cybersoft.osahaneat.entity.Category;
import com.cybersoft.osahaneat.entity.Food;
import com.cybersoft.osahaneat.repository.CategoryRepository;
import com.cybersoft.osahaneat.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService implements CategoryServiceImpl {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getCategoryHomepage() {
        PageRequest pageRequest = PageRequest.of(0,2);
        List<Category> categoryList =  categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for(Category i : categoryList){
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName_cate(i.getNameCate());
            categoryDTO.setFreeship(i.isFreeship());
            List<MenuDTO> menuDTOList = new ArrayList<>();
            for(Food j : i.getListFood()) {
                MenuDTO menuDTO = new MenuDTO();
                menuDTO.setImage(j.getImage());
                menuDTO.setTitle(j.getTitle());
//               menuDTO.setFreeShip(true);
                menuDTOList.add(menuDTO);
                categoryDTO.setListMenuDTO(menuDTOList);
            }
            categoryDTOList.add(categoryDTO);

        }
        System.out.println("ok");
        return  categoryDTOList;

//        return null;
    }
}
