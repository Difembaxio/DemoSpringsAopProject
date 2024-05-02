package ru.difembaxio.springaspects.springsaopproject.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.difembaxio.springaspects.springsaopproject.dto.ProductDto;
import ru.difembaxio.springaspects.springsaopproject.dto.ProductMapper;
import ru.difembaxio.springaspects.springsaopproject.repository.ProductRepository;
import ru.difembaxio.springaspects.springsaopproject.utils.CustomCacheable;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public ProductDto addProduct(ProductDto productsDto) {
    return ProductMapper.toProductDto(productRepository.save(ProductMapper.toProduct(productsDto)));
  }

  @Override
  @CustomCacheable()
  public ProductDto getById(Long id) {
    return ProductMapper.toProductDto(productRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new));
  }
}
