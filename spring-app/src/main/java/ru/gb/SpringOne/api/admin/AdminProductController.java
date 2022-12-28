package ru.gb.SpringOne.api.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.gb.SpringOne.dto.ProductDto;
import ru.gb.SpringOne.services.ProductService;
import ru.gb.SpringOne.utils.Converter;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/products")
public class AdminProductController {
    private final ProductService productService;
    private final Converter converter;


    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return converter.productToProductDto(productService.save(converter.productDtoToProduct(productDto)));
    }

    @PutMapping
    public ProductDto update(@RequestBody ProductDto productDto) {
        return converter.productToProductDto(productService.update(converter.productDtoToProduct(productDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        productService.deleteProduct(id);
    }
}
