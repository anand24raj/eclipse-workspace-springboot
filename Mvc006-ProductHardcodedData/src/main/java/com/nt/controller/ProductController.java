package com.nt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/product")
    public String showProduct(Model model) 
    {
    	Map<String,Object> map=new HashMap<>();
    	map.put("id",1001);
    	map.put("name","Laptop");
    	map.put("brand","Lenevo");
    	map.put("price",65000);
    	model.addAllAttributes(map);

        return "Product";
    }
}
