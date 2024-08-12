package com.fastcampus.toy2.dao.Product;

import com.fastcampus.toy2.domain.Product.ProductColorDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductColorDaoImpl implements ProductColorDao {
    @Autowired
    private SqlSession sqlSession;
    private String namespace = "com.fastcampus.toy2.dao.Product.ProductColorMapper.";

    @Override
    public int count() throws Exception {
        return sqlSession.selectOne(namespace + "count");
    }

    @Override
    public ProductColorDto selectByColorCode(String color_code) throws Exception {
        return sqlSession.selectOne(namespace + "selectByColorCode", color_code);
    }

    @Override
    public List<ProductColorDto> selectAll() throws Exception {
        return sqlSession.selectList(namespace + "selectAll");
    }

    @Override
    public int insert(ProductColorDto productColorDto) throws Exception {
        return sqlSession.insert(namespace + "insert", productColorDto);
    }

    @Override
    public int update(ProductColorDto productColorDto) throws Exception {
        return sqlSession.update(namespace + "update", productColorDto);
    }

    @Override
    public int delete(ProductColorDto productColorDto) throws Exception {
        return sqlSession.update(namespace + "delete", productColorDto);
    }

    @Override
    public int deleteAll() throws Exception {
        return sqlSession.delete(namespace + "deleteAll");
    }
}
