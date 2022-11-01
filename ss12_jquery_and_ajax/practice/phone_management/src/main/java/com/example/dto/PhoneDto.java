package com.example.dto;

public class PhoneDto {
    private Long id;
    private String producerPhone;
    private String modelPhone;
    private double pricePhone;

    public PhoneDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducerPhone() {
        return producerPhone;
    }

    public void setProducerPhone(String producerPhone) {
        this.producerPhone = producerPhone;
    }

    public String getModelPhone() {
        return modelPhone;
    }

    public void setModelPhone(String modelPhone) {
        this.modelPhone = modelPhone;
    }

    public double getPricePhone() {
        return pricePhone;
    }

    public void setPricePhone(double pricePhone) {
        this.pricePhone = pricePhone;
    }
}
