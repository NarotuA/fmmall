package com.qfedu.fmmall.service;

import com.qfedu.fmmall.entity.Category;
import com.qfedu.fmmall.entity.CategoryVO;
import com.qfedu.fmmall.vo.ResultVO;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    public ResultVO listCategories();

    public ResultVO listFirstLevelCategories();

    //使用limit进行分页,参数一为当前显示页数，参数二为页面显示数量
    public List<Category> findpagebyarray(int pageNow,int pageSize);
    //sql分页
    public List<Category> findpagebysql(int currPage,int pageSize);
    //rowbounds分页
}
