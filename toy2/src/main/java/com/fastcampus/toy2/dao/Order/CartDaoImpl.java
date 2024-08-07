package com.fastcampus.toy2.dao.Order;

import com.fastcampus.toy2.domain.Order.CartDto;

public interface CartDaoImpl {
    int count() throws Exception;

    int deleteAll() throws Exception;

    int insert(CartDto cartDto) throws Exception;

    int update(CartDto cartDto) throws Exception;
}
