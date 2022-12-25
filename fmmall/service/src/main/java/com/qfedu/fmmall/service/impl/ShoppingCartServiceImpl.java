package com.qfedu.fmmall.service.impl;

import com.qfedu.fmmall.dao.ShoppingCartMapper;
import com.qfedu.fmmall.entity.ShoppingCart;
import com.qfedu.fmmall.entity.ShoppingCartVO;
import com.qfedu.fmmall.service.ShoppingCartService;
import com.qfedu.fmmall.vo.ResStatus;
import com.qfedu.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public ResultVO addshoppingcart(ShoppingCartVO cart) {
        int insert = shoppingCartMapper.insert(cart);
        if (insert>0){
            return new ResultVO(ResStatus.OK,"添加成功",null);
        }else{
            return new ResultVO(ResStatus.NO,"添加失败",null);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)//表示支持当前事务，如果没有事务，就以非事务的方式执行
    public ResultVO selectshoppingcart(int userId) {
        List<ShoppingCartVO> cartVOS = shoppingCartMapper.selectShopcartByUserId(userId);
        return new ResultVO(ResStatus.OK,"查询成功",cartVOS);
    }
}
