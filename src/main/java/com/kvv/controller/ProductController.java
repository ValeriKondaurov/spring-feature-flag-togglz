package com.kvv.controller;

import com.kvv.dto.ProductDto;
import com.kvv.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

  @Autowired
  ProductService productService;

  @Autowired
  FeatureManager featureManager;

  @GetMapping("{id}/info")
  public ProductDto info(@PathVariable Long id) {
    return productService.getInfo(id);

  }
  
}
