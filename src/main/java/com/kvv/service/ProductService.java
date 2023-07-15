package com.kvv.service;

import com.kvv.config.FeatureFlags;
import com.kvv.dto.ProductDto;
import com.kvv.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.togglz.core.manager.FeatureManager;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    FeatureManager featureManager;


    @GetMapping("{id}/info")
    public ProductDto getInfo(Long id) {
        final var optionalProduct = productRepository.findById(id);
        return optionalProduct
                .map(product -> ProductDto
                        .builder()
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .build())
                .map(this::process)
                .orElse(ProductDto.builder().build());

    }

    private ProductDto process(ProductDto product) {
        if (featureManager.isActive(FeatureFlags.PRICE_INCREASE)) {
            product.setPrice(product.getPrice() * 1.5);
        }

        if (featureManager.isActive(FeatureFlags.START_SALES)) {
            product.setPrice(product.getPrice() * 0.8);
            product.setWithDiscount(true);
        }
        return product;
    }
}
