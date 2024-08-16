package com.fastcampus.toy2.dao.Product;

import com.fastcampus.toy2.domain.Product.ProductStockDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductStockDao {
    @Autowired
    private SqlSession sqlSession;
    private static String namespace = "com.fastcampus.toy2.dao.Product.ProductStockMapper.";

    List<ProductStockDto> selectByStyleNum(String style_num) {
        return sqlSession.selectList(namespace + "selectByStyleNum", style_num);
    }
}
