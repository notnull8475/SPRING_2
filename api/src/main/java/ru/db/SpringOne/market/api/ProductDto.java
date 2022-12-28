package ru.db.SpringOne.market.api;

public class ProductDto {
    private Long id;
    private String title;
    private Long price;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductDto(String title, Long price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public ProductDto() {
    }
}
