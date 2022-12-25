package com.qfedu.fmmall.controller;

import com.qfedu.fmmall.service.ProductCommentsService;
import com.qfedu.fmmall.service.ProductService;
import com.qfedu.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
@CrossOrigin
@Api(value = "商品信息相关接口",tags = "商品管理")
public class ProductController {
    @Resource
    private ProductService productService;
    @Resource
    private ProductCommentsService productCommentsService;

    @ApiOperation("商品基本信息查询接口")
    @GetMapping("/detail/{id}")
    public ResultVO getProductBasicInfo(@PathVariable("id") String id){
        return productService.getProductBasicInfo(id);
    }

    @ApiOperation("商品参数信息查询接口")
    @GetMapping("/params/{id}")
    public ResultVO getProductParamInfo(@PathVariable("id") String id){
        return productService.getProductParamsById(id);
    }

    @ApiOperation("商品评论信息查询接口")
    @GetMapping("/comments/{id}")
    //@PathVariable接收请求路径中占位符的值
    public ResultVO getProductComments(@PathVariable("id") String id,int pageNum,int limit){
        return productCommentsService.listCommentsByProductId(id,pageNum,limit);
    }

    @ApiOperation("商品评论分类查询接口")
    @GetMapping("/goodorbad/{id}")
    //@PathVariable接收请求路径中占位符的值
    public ResultVO getProductgoodorbadComments(@PathVariable("id") String id){
        return productCommentsService.getcommentscount(id);
    }
}
