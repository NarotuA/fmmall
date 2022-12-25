package com.qfedu.fmmall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 新增 productName、productImg
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shopping_cart")
public class ShoppingCartVO {
    private Integer cartId;
    private String productId;
    private String skuId;
    private String userId;
    private String cartNum;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String cartTime;
    private String productPrice;
    private String skuProps;
    //新增属性
//    private String productName;
//    private String productImg;
//    private double originalPrice;
//    private double sellPrice;
//    private String skuName;
//    private int skuStock;  //库存
}

