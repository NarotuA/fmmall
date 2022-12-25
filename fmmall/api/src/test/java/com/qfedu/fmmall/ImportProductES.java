package com.qfedu.fmmall;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class ImportProductES {
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Test
    public void testcreateindex() throws Exception{
        //创建索引库存放商品信息
        //注：创建索引请求中内容必须为小些否则报错
        CreateIndexRequest indexRequest = new CreateIndexRequest("fmmallproductsindex");
        //得到响应
        CreateIndexResponse indexResponse = restHighLevelClient.indices().create(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.isAcknowledged());
    }
    @Test
    public void importdata(){
        //将数据导入到es中


        //将查询到的数据写入到es中
    }
}
