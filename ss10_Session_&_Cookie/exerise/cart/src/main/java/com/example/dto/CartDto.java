package com.example.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto(){
    }

    public CartDto(Map<ProductDto, Integer> productDtoMap) {
        this.productMap = productDtoMap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto){
        if(productMap.containsKey(productDto)){
            //update value + 1
            Integer currentValue = productMap.get(productDto);

            productMap.replace(productDto, currentValue + 1 );
//            productMap.put(productDto, currentValue + 1); tương tự như replace
        }
        else {
            productMap.put(productDto, 1); // Lần đầu được thêm vào
        }
    }
    public void deleteProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            if (productMap.get(productDto) > 1) {
                Integer currentValue = productMap.get(productDto);
                productMap.replace(productDto, currentValue - 1);
            } else {
                productMap.remove(productDto);
            }
        }
    }
    public void deleteAllProduct(ProductDto productDto) {
        productMap.remove(productDto);
    }
}
