package com.fastcampus.toy2.dao.Product;

import com.fastcampus.toy2.domain.Product.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    SqlSession session;
    private static String namespace = "com.fastcampus.toy2.dao.Product.ProductMapper.";

    @Override
    public int count() throws SQLException {
        return session.selectOne(namespace + "count");
    }

    @Override
    public ProductDto selectOne(String product_id) throws SQLException {
        return session.selectOne(namespace + "selectOneById", product_id);
    }

    @Override
    public List<ProductDto> selectAll() throws SQLException {
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public List<ProductDto> selectSale() throws SQLException {
        return session.selectList(namespace + "selectSale");
    }

    @Override
    public int insert(ProductDto productDto) throws SQLException {
        return session.insert(namespace + "insert", productDto);
    }

    @Override
    public int update(ProductDto productDto) throws SQLException {
        System.out.println("update : " +productDto.toString());
        return session.update(namespace + "update", productDto);
    }

    @Override
    public int delete(ProductDto productDto) throws SQLException {
        return session.delete(namespace + "delete", productDto);
    }

    @Override
    public int deleteAll() throws SQLException {
        return session.delete(namespace + "deleteAll");
    }

}
