package com.qfedu.fmmall;

import com.github.pagehelper.PageHelper;
import com.qfedu.fmmall.controller.ProductController;
import com.qfedu.fmmall.controller.ShoppingCartController;
import com.qfedu.fmmall.dao.CategoryMapper;
import com.qfedu.fmmall.dao.ProductCommentsMapper;
import com.qfedu.fmmall.dao.ShoppingCartMapper;
import com.qfedu.fmmall.entity.*;
import com.qfedu.fmmall.service.CategoryService;
import com.qfedu.fmmall.service.ProductCommentsService;
import com.qfedu.fmmall.service.ShoppingCartService;
import com.qfedu.fmmall.vo.ResultVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest(classes = ApiApplication.class)
@RunWith(SpringRunner.class)
public class ApiApplicationTest {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private CategoryService categoryService;
    @Resource
    private ProductCommentsMapper productCommentsMapper;
    @Resource
    private ProductController ProductController;
    @Resource
    private ProductCommentsService productCommentsService;
    @Resource
    private ShoppingCartMapper shoppingCartMapper;
    @Resource
    private ShoppingCartService shoppingCartService;
    @Resource
    private ShoppingCartController shoppingCartController;
    @Test
    public void testselectFirstLevelCategories(){
        List<CategoryVO> vos = categoryMapper.selectFirstLevelCategories();
        for (CategoryVO vo : vos) {
            System.out.println(vo);
        }
    }
    //使用数组进行分页查询
    @Test
    public void testselectcategorybyarray(){

    }

    @Test
    //使用分页插件进行分页
    public void testselectcategorybypage(){
        //定义开始页面和页面数量
        int pageNum = 1;
        int pageSize = 10;
        PageHelper.startPage(pageNum,pageSize);

    }
    //评论接口测试
    @Test
    public void testselectCommontsByProductId(){
        ResultVO resultVO = ProductController.getProductComments("3",1,2);
        System.out.println(resultVO.getData());
    }
    @Test
    public void testgetcommentscount(){
        ResultVO resultVO = productCommentsService.getcommentscount("3");
        System.out.println(resultVO);
    }
//    @Test
//    public void testshoppingcart(){
//        //查询userID为2的用户的购物车信息
//        List<ShoppingCartVO> shoppingCartVOS = shoppingCartMapper.selectShopcartByUserId(1);
//        System.out.println(shoppingCartVOS);
//    }
    @Test
    public void testshoppingservice(){
        ShoppingCartVO cart = new ShoppingCartVO(1,"2","2021-05-12 09:37:15","2","40","3","40","口味:烧烤");
        ResultVO resultVO = shoppingCartService.addshoppingcart(cart);
        System.out.println(resultVO);
    }
//    @Test
//    public void testshoppingcontrol(){
//        ShoppingCartVO cart = new ShoppingCartVO(1,"2","3","2","40","2021-05-12 09:18:35",40.000,"口味:烧烤");
//        ResultVO vo = shoppingCartController.addshoppingcart(cart, "eyJhbGciOiJIUzI1NiJ9.eyJrZXkxIjoidmFsdWUxIiwia2V5MiI6InZhbHVlMiIsImV4cCI6MTY3MDEzNzc1OX0.ZTkKX_D1-Qb88efC-4pH3m6NEZmjEDJWnr1XIMriCD4");
//        System.out.println(vo);
//    }
}