package com.fastcampus.toy2.dao.Order;

import com.fastcampus.toy2.domain.Order.CartDto;

public interface CartDao {
    int count() throws Exception;

    int deleteAll() throws Exception;

    int insert(CartDto cartDto) throws Exception;

    int update(String crt_id) throws Exception;

    CartDto selectCartId(String crt_id) throws Exception;

    String maxCartSeq(String datePart) throws Exception;

    CartDto selectUserCartActive(String mbr_id) throws Exception;
}
