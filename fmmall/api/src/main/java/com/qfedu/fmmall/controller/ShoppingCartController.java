package com.qfedu.fmmall.controller;

import com.qfedu.fmmall.entity.ShoppingCart;
import com.qfedu.fmmall.entity.ShoppingCartVO;
import com.qfedu.fmmall.service.ShoppingCartService;
import com.qfedu.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/shoppingcart")
@CrossOrigin
@Api(value = "提供购物车接口",tags = "购物车管理")
public class ShoppingCartController {
    @Resource
    private ShoppingCartService shoppingCartService;
    @PostMapping("/addshoppingcart")
    public ResultVO addshoppingcart(@RequestBody ShoppingCartVO cart, @RequestHeader("token")String token){
        return shoppingCartService.addshoppingcart(cart);
    }

//    @GetMapping("/list"),等价于以下的注解
    @RequestMapping(method = RequestMethod.GET,value = "/list")//拦截get请求提交的方法
    //参数说明
    @ApiImplicitParam(dataType = "int",name = "userId",value = "用户id",required = true)
    public ResultVO listshoppingcart(Integer userId,@RequestHeader("token") String token){//如果不加userID就会报错500使用int
        return shoppingCartService.selectshoppingcart(userId);

    }

}
