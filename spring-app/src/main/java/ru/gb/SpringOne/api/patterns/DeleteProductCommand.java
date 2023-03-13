package ru.gb.SpringOne.api.patterns;

import ru.db.springone.market.api.ProductDto;
import ru.gb.SpringOne.converters.ProductConverter;
import ru.gb.SpringOne.models.Product;
import ru.gb.SpringOne.services.ProductService;

public class DeleteProductCommand implements Command {
    private final ProductService productService;
    private final ProductConverter converter;
    private final Product product;

    public DeleteProductCommand(ProductService productService, ProductConverter converter, Product product) {
        this.productService = productService;
        this.converter = converter;
        this.product = product;
    }

    @Override
    public Object execute() {
        productService.deleteProduct(product.getId());
        return null;
    }
}
