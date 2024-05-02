package ru.difembaxio.springaspects.springsaopproject.service;


import ru.difembaxio.springaspects.springsaopproject.dto.ProductDto;

public interface ProductService {

  ProductDto addProduct(ProductDto productDto);

  ProductDto getById(Long id);
}
