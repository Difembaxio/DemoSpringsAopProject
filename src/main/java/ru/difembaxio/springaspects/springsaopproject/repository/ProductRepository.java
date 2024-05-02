package ru.difembaxio.springaspects.springsaopproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.difembaxio.springaspects.springsaopproject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
