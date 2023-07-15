package com.kvv.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

  String name;

  String description;

  Double price;

  Boolean withDiscount;
}
