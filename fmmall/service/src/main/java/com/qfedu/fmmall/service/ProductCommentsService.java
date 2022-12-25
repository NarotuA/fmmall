package com.qfedu.fmmall.service;

import com.qfedu.fmmall.vo.ResultVO;

public interface ProductCommentsService {
    public ResultVO listCommentsByProductId(String productId,int start,int limit);
    //商品统计接口
    public ResultVO getcommentscount(String productId);
}
