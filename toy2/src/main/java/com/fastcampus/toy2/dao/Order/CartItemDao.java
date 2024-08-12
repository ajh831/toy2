package com.fastcampus.toy2.dao.Order;

import com.fastcampus.toy2.domain.Order.CartDto;
import com.fastcampus.toy2.domain.Order.CartItemDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CartItemDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.fastcampus.toy2.dao.CartItemMapper.";

    int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    int insert(Map map) throws Exception {
        return session.insert(namespace + "insert", map);
    }

    int updateOption(CartItemDto cartItemDto) throws Exception {
        return session.update(namespace + "updateOption", cartItemDto);
    }

    int countCartItem(Long crt_id) throws Exception {
        return session.selectOne(namespace + "countCartItem", crt_id);
    }

    int deleteCartItem(Map map) throws Exception {
        return session.delete(namespace + "deleteCartItem", map);
    }

    int updateNewCartItem(Long crt_id) throws Exception {
        return session.update(namespace + "updateNewCartItem", crt_id);
    }

    Integer maxCartCrtSeq(Long crt_id) throws Exception {
        return session.selectOne(namespace + "maxCartCrtSeq", crt_id);
    }

    int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    CartItemDto selectCartItem(CartItemDto cartItemDto) throws Exception {
        return session.selectOne(namespace + "selectCartItem", cartItemDto);
    }

    List<Integer> selectCrtSeqListByCrtId(Long crt_id) throws Exception {
        return session.selectList(namespace + "selectCrtSeqListByCrtId", crt_id);
    }

}
