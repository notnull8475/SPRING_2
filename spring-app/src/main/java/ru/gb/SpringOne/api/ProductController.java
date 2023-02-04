package ru.gb.SpringOne.api;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.db.springone.market.api.ProductDto;
import ru.db.springone.market.api.ResourceNotFoundException;
import ru.gb.SpringOne.models.Product;
import ru.gb.SpringOne.services.ProductService;
import ru.gb.SpringOne.converters.ProductConverter;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final ProductConverter converter;

    public ProductController(ProductService productService, ProductConverter converter) {
        this.productService = productService;
        this.converter = converter;
    }


    @GetMapping
    public Page<ProductDto> getProducts(
            @RequestParam(name = "rows", required = false, defaultValue = "5") int rows,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "min_price", required = false) Long minPrice,
            @RequestParam(name = "max_price", required = false) Long maxPrice,
            @RequestParam(name = "title_part", required = false) String titlePart
    ) {
        if (rows < 1) rows = 5;
        if (page < 1) page = 1;
        return productService.getProducts(rows, page, minPrice, maxPrice, titlePart).map(converter::productToProductDto);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        Product p = productService.getProduct(id).orElseThrow(() -> new ResourceNotFoundException("Продукт не найден, id: " + id));
        return converter.productToProductDto(p);
    }


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
