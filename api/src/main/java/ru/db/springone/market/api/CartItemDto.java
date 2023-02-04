package ru.db.springone.market.api;

public class CartItemDto {
    private Long productId;
    private String productTitle;
    private int quantity;
    private Long pricePerProduct;
    private Long price;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getPricePerProduct() {
        return pricePerProduct;
    }

    public void setPricePerProduct(Long  pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
