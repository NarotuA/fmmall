package com.qfedu.fmmall.service;

import com.qfedu.fmmall.entity.ShoppingCartVO;
import com.qfedu.fmmall.vo.ResultVO;

public interface ShoppingCartService {
     public ResultVO addshoppingcart(ShoppingCartVO cart);

     public ResultVO selectshoppingcart(int userId);
}
