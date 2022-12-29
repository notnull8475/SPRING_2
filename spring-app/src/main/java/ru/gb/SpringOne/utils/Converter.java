package ru.gb.SpringOne.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.db.springone.market.api.ProductDto;
import ru.db.springone.market.api.AppUserDto;
import ru.gb.SpringOne.models.AppUser;
import ru.gb.SpringOne.models.Product;

@Component
@RequiredArgsConstructor
public class Converter {
    public Product productDtoToProduct(ProductDto productDto) {
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

    public AppUserDto appUserToDto(AppUser appUser) {
        return AppUserDto.builder()
                .id(appUser.getId())
                .email(appUser.getEmail())
                .username(appUser.getUsername())
                .firstname(appUser.getFirstname())
                .lastname(appUser.getLastname())
                .enabled(appUser.isEnabled())
                .build();

    }

    public AppUser dtoToAppUser(AppUserDto appUserDto) {
        return AppUser.builder()
                .id(appUserDto.getId())
                .email(appUserDto.getEmail())
                .username(appUserDto.getUsername())
                .firstname(appUserDto.getFirstname())
                .lastname(appUserDto.getLastname())
                .enabled(appUserDto.isEnabled())
                .build();
    }


}
