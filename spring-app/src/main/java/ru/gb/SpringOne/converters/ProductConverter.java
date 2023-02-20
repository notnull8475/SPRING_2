package ru.gb.SpringOne.converters;

import org.springframework.stereotype.Component;
import ru.db.springone.market.api.ProductDto;
import ru.gb.SpringOne.models.Product;

@Component
public class ProductConverter {
    public Product productDtoToProduct(ProductDto productDto) {
//        Использование builder
        return Product.builder()
                .id(productDto.getId())
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();
    }

    public ProductDto productToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());

        return productDto;
    }
}
