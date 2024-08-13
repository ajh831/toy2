package com.fastcampus.toy2.service.Order;

import com.fastcampus.toy2.dao.Order.CartDao;
import com.fastcampus.toy2.dao.Order.CartItemDao;
import com.fastcampus.toy2.dao.Order.CartItemHistoryDao;
import com.fastcampus.toy2.domain.Order.CartDto;
import com.fastcampus.toy2.domain.Order.CartItemDto;
import com.fastcampus.toy2.domain.User.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Service
public class CartService {

    @Autowired
    CartDao cartDao;

    @Autowired
    CartItemDao cartItemDao;

    @Autowired
    CartItemHistoryDao cartItemHistoryDao;

     /*
        1. 장바구니에 담는 경우
            1.1. 상품 상세에서 옵션을 선택한다.
            1.2. 장바구니에 담는 버튼을 누른다.
                - 회원의 장바구니를 확인한다.
            1.3. 장바구니가 존재하는 회원인 경우
                - 장바구니를 생성한다. 생성과 동시에 바로 번호 확인 가능
            1.4. 장바구니가 존재하지 않는 회원인 경우
                - 회원의 장바구니 번호를 조회하여 가지고 온다.
            1.5. 장바구니 번호에 상품을 담는다.
     */
    public Integer addToCart(MemberDto memberDto, CartItemDto cartItemDto) throws Exception {

        CartDto cartDto = cartDao.selectUserCart(memberDto.getMbr_id());
        Long crt_id = cartDto.getCrt_id();

        if (memberDto.getMbr_id() != null && crt_id == null) { // 로그인했지만 장바구니가 없는 경우
            cartDto = new CartDto.Builder().mbr_id(memberDto.getMbr_id()).build();
            cartDao.insert(cartDto);

            cartItemDto.setCrt_id(crt_id);

            Integer crt_seq = cartItemDao.maxCartCrtSeq(cartDto.getCrt_id());

            if(crt_seq == null) {
                crt_seq = 1;
            } else {
                crt_seq += 1;
            }

            cartItemDto.setCrt_seq(crt_seq);

            Map<String, Object> map = new HashMap<>();
            map.put("cart_item", cartItemDto);
            map.put("member", memberDto);

            cartItemDao.insert(map);
            cartItemHistoryDao.insert(map);
            return 1;
        } else if (memberDto.getMbr_id() != null && crt_id != null) { // 로그인했지만 장바구니가 있는 경우
            System.out.println("로그인했지만 장바구니 없음");
            System.out.println("crt_id = " + crt_id);
            cartDto = new CartDto.Builder().mbr_id(memberDto.getMbr_id()).build();

            cartItemDto.setCrt_id(crt_id);
            System.out.println("cartItemDto의 crt_id = " + cartItemDto.getCrt_id());

            Integer crt_seq = cartItemDao.maxCartCrtSeq(crt_id);
            System.out.println("crt_seq = " + crt_seq);
            if(crt_seq == null) {
                crt_seq = 1;
            } else {
                crt_seq += 1;
            }

            cartItemDto.setCrt_seq(crt_seq);

            Map<String, Object> map = new HashMap<>();
            map.put("cart_item", cartItemDto);
            map.put("member", memberDto);

            cartItemDao.insert(map);

            return 2;
        } else if (memberDto.getMbr_id() == null && crt_id == null) { // 로그인 안한 경우

            return 3;
        } else {
            return 0;
        }
    }


    /*
        2. 장바구니에 들어가서 보는 경우
            2.1. 회원 장바구니를 들어간다.
            2.2. 회원 장바구니에 담겨있는 정보들을 불러온다. -> 장바구니 정보 세션에 저장(브라우저 종료시 장바구니 내역 사라짐)

     */


    /*
        3. 바로 구매하기를 클릭하는 경우
            3.1. 로그인 한 경우
            3.2. 비로그인인 경우
    */
}
