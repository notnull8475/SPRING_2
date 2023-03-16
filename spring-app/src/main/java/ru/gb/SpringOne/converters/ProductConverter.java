package ru.gb.SpringOne.converters;

import org.springframework.stereotype.Component;
import ru.db.springone.market.api.ProductDto;
import ru.gb.SpringOne.models.Product;

@Component
public class ProductConverter {
    public Product productDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return product;
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
