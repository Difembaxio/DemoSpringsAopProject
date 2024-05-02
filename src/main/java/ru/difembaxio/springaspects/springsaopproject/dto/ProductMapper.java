package ru.difembaxio.springaspects.springsaopproject.dto;


import ru.difembaxio.springaspects.springsaopproject.model.Product;

public class ProductMapper {

  public static Product toProduct(ProductDto productDto) {
    return Product.builder()
        .id(productDto.getId())
        .name(productDto.getName())
        .price(productDto.getPrice())
        .build();
  }

  public static ProductDto toProductDto(Product product) {
    return ProductDto.builder()
        .id(product.getId())
        .name(product.getName())
        .price(product.getPrice())
        .build();
  }

}

