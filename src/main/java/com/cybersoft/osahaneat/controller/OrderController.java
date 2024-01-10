package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.payload.request.OrderRequest;
import com.cybersoft.osahaneat.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;
    @PostMapping("")
    public ResponseEntity<?> getAllUser (@RequestBody OrderRequest orderRequest){


        return new ResponseEntity<>(orderService.insertOrder(orderRequest), HttpStatus.OK);
    }
}
