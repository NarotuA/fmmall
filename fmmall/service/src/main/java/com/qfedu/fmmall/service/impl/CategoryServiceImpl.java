package com.qfedu.fmmall.service.impl;

import com.qfedu.fmmall.dao.CategoryMapper;
import com.qfedu.fmmall.entity.Category;
import com.qfedu.fmmall.entity.CategoryVO;
import com.qfedu.fmmall.service.CategoryService;
import com.qfedu.fmmall.vo.ResStatus;
import com.qfedu.fmmall.vo.ResultVO;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询分类列表（包含三个级别的分类）
     * @return
     */
    public ResultVO listCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }

    /**
     * 查询所有一级分类，同时查询当前一级分类下销量最高的6个商品
     * @return
     */
    public ResultVO listFirstLevelCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }
//数组分页
    @Override
    public List<Category> findpagebyarray(int pageNow, int pageSize) {
        int startNum = (pageNow-1)*pageSize;
        int lastNum = pageSize*pageNow;
        List<Category> categories = categoryMapper.selectcategorybyarray();
        return categories.subList(startNum,lastNum);
    }
    //sql分页

    @Override
    public List<Category> findpagebysql(int currPage, int pageSize) {
        HashMap<String, Integer> map = new HashMap<>();
        //  注:传进来的pageNum与配置文件中不要保持一致
            map.put("currIndex",(currPage-1)*pageSize);
            map.put("pageSize",pageSize);
        return categoryMapper.selectcategorybysql(map);
    }
}
