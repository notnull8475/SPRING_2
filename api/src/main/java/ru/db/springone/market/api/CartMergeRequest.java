package ru.db.springone.market.api;

public class CartMergeRequest {
    String username;
    String UUID;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public CartMergeRequest(String username, String UUID) {
        this.username = username;
        this.UUID = UUID;
    }

    public CartMergeRequest() {
    }
}
