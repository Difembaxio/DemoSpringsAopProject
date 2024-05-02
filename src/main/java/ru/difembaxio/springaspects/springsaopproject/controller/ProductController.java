package ru.difembaxio.springaspects.springsaopproject.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.difembaxio.springaspects.springsaopproject.dto.ProductDto;
import ru.difembaxio.springaspects.springsaopproject.service.ProductService;


@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @PostMapping
  public ProductDto addProduct(@RequestBody ProductDto productDto) {
    return productService.addProduct(productDto);
  }

  @GetMapping("/{productId}")
  public ProductDto getById(@PathVariable Long productId) {
    return productService.getById(productId);
  }
}
