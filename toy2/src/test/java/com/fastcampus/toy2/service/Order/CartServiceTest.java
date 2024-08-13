package com.fastcampus.toy2.service.Order;

import com.fastcampus.toy2.dao.Order.CartDao;
import com.fastcampus.toy2.dao.Order.CartItemDao;
import com.fastcampus.toy2.domain.Order.CartItemDto;
import com.fastcampus.toy2.domain.User.MemberDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class CartServiceTest {

    @Autowired
    CartDao cartDao;

    @Autowired
    CartItemDao cartItemDao;

    @Autowired
    CartService cartService;

    @Test
    public void 로그인한_회원이_장바구니에_상품을_처음_추가() throws Exception {
        MemberDto memberDto = new MemberDto();
        memberDto.setMbr_id("asdf12345");

        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setStyle_num("123");
        cartItemDto.setP_size(230);
        cartItemDto.setCount(1);

        int result = cartService.addToCart(memberDto, cartItemDto);

        assertEquals(1, result);
    }


    @Test
    public void 로그인한_회원이_장바구니에_상품을_추가() throws Exception {
        MemberDto memberDto = new MemberDto();
        memberDto.setMbr_id("asdf12345");

        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setStyle_num("테스트");
        cartItemDto.setP_size(250);
        cartItemDto.setCount(1);

        int result = cartService.addToCart(memberDto, cartItemDto);
        System.out.println("result = " + result);
        assertEquals(2, result);

        CartItemDto checkCartItem = cartItemDao.selectCartItem(cartItemDto);

        assertTrue(cartItemDto.getStyle_num().equals(checkCartItem.getStyle_num()));
    }

    @Test
    public void 비로그인_회원이_장바구니에_상품을_추가() throws Exception {
        MemberDto memberDto = new MemberDto();

        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setStyle_num("비로그인_테스트");
        cartItemDto.setP_size(250);
        cartItemDto.setCount(1);

        int result = cartService.addToCart(memberDto, cartItemDto);
        System.out.println("result = " + result);
        assertEquals(3, result);

        CartItemDto checkCartItem = cartItemDao.selectCartItem(cartItemDto);

        assertTrue(cartItemDto.getStyle_num().equals(checkCartItem.getStyle_num()));
    }
}