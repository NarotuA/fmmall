package com.qfedu.fmmall.service.impl;

import com.qfedu.fmmall.dao.ProductCommentsMapper;
import com.qfedu.fmmall.entity.ProductComments;
import com.qfedu.fmmall.entity.ProductCommentsVO;
import com.qfedu.fmmall.service.ProductCommentsService;
import com.qfedu.fmmall.utils.PageHelper;
import com.qfedu.fmmall.vo.ResStatus;
import com.qfedu.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductCommentsServiceImple implements ProductCommentsService {
    @Resource
    private ProductCommentsMapper productCommentsMapper;
    @Override
    public ResultVO listCommentsByProductId(String productId,int pageNum,int limit) {
//        List<ProductCommentsVO> result = productCommentsMapper.selectCommontsByProductId(productId,start,limit);
        //分别查询出总记录数，总页数和分页数据
        Example example = new Example(ProductComments.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        int count = productCommentsMapper.selectCountByExample(example);//总记录数
        //总页数，总记录数除以每页显示的数量
        int pageSize = count%limit==0?count/limit:(count/limit+1);
        //分页数据,由于需要用户信息，所以需要连表查询

        int start = (pageNum-1)*limit; // ,start表示从具体那一条数据开始进行查询
        List<ProductCommentsVO> vos = productCommentsMapper.selectCommontsByProductId(productId, start, limit);
        return new ResultVO(ResStatus.OK,"商品评论信息查询成功",new PageHelper<ProductCommentsVO>(count,pageSize,vos));
    }

    @Override
    public ResultVO getcommentscount(String productId) {
        //先查询出当前商品的评论的总数
        Example example = new Example(ProductComments.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        int totalcomment = productCommentsMapper.selectCountByExample(example);//评价总数
        map.put("totalcomment",totalcomment);
//        好评评价数
        criteria.andEqualTo("commType",1);
        int goodcomments = productCommentsMapper.selectCountByExample(example);
        map.put("goodcomments",goodcomments);
//        中评评价数
        Example example1 = new Example(ProductComments.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("productId",productId);
        criteria1.andEqualTo("commType",0);
        int midcomments = productCommentsMapper.selectCountByExample(example1);
        map.put("midcomments",midcomments);
    //差评评价数,拼接查询条件
        Example example2 = new Example(ProductComments.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("productId",productId);
        criteria2.andEqualTo("commType",-1);
        int badcomments = productCommentsMapper.selectCountByExample(example2);
        map.put("badcomments",badcomments);
    //好评率
        double dou = Double.parseDouble(goodcomments+"")/Double.parseDouble(totalcomment+"");
        String goodradio = String.format("%.4f", dou);
        map.put("goodradio",goodradio);
    //
        return new ResultVO(ResStatus.OK,"查询成功",map);
    }
}
