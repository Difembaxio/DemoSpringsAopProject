package ru.difembaxio.springaspects.springsaopproject.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ProductDto {

  @NotNull(message = "Идентификатор продукта не может быть null")
  private int id;
  @NotBlank(message = "Название продукта не может быть пустым")
  private String name;
  @NotNull(message = "Цена не может быть пустой")
  private double price;
}
