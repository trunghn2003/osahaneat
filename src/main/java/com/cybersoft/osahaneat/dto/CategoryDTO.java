package com.cybersoft.osahaneat.dto;

import java.util.List;

public class CategoryDTO {
    private String name_cate;
    public boolean isFreeship;

    List<MenuDTO> listMenuDTO;

    public boolean isFreeship() {
        return isFreeship;
    }

    public void setFreeship(boolean freeship) {
        isFreeship = freeship;
    }

    public String getName_cate() {
        return name_cate;
    }

    public void setName_cate(String name_cate) {
        this.name_cate = name_cate;
    }

    public List<MenuDTO> getListMenuDTO() {
        return listMenuDTO;
    }

    public void setListMenuDTO(List<MenuDTO> listMenuDTO) {
        this.listMenuDTO = listMenuDTO;
    }
}
