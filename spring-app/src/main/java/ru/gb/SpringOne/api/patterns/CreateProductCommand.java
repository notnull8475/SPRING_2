package ru.gb.SpringOne.api.patterns;

import ru.db.springone.market.api.ProductDto;
import ru.gb.SpringOne.converters.ProductConverter;
import ru.gb.SpringOne.models.Product;
import ru.gb.SpringOne.services.ProductService;

public class CreateProductCommand implements Command {
    private final ProductService productService;
    private final ProductConverter converter;
    private final ProductDto productDto;

    public CreateProductCommand(ProductService productService, ProductConverter converter, ProductDto productDto) {
        this.productService = productService;
        this.converter = converter;
        this.productDto = productDto;
    }

    @Override
    public Product execute() {
       return productService.save(converter.productDtoToProduct(productDto));
    }
}
