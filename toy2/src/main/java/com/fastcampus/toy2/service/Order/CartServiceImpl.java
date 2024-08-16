package com.fastcampus.toy2.service.Order;


import com.fastcampus.toy2.dao.Order.CartDao;
import com.fastcampus.toy2.dao.Order.CartItemDao;
import com.fastcampus.toy2.dao.Order.CartItemHistoryDao;
import com.fastcampus.toy2.dao.Product.ProductColorDao;
import com.fastcampus.toy2.dao.Product.ProductDao;
import com.fastcampus.toy2.domain.Order.CartItemDto;
import com.fastcampus.toy2.domain.Order.CartItemInfoDto;
import com.fastcampus.toy2.domain.Product.ProductColorDto;
import com.fastcampus.toy2.domain.Product.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    @Autowired
    CartItemDao cartItemDao;

    @Autowired
    CartItemHistoryDao cartItemHistoryDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    ProductColorDao productColorDao;

    /*
        장바구니에 상품 정보를 보여주는 메서드
        1. 장바구니 상품에서 스타일 번호를 가지고 온다.
        2. 스타일 번호에서 "_"를 기준으로 앞쪽이 product_id이므로 상품 아이디를 분리한다.
        3. 상품아이디로 product테이블의 정보를 가지고 온다.
    */
    @Override
    public List<CartItemInfoDto> getCartProduct(List<CartItemDto> cartItemDtoList) throws Exception {
        if (cartItemDtoList == null || cartItemDtoList.isEmpty()) {
            return new ArrayList<>(); // 빈 리스트 반환
        }

        // 장바구니에 담은 상품만큼의 장바구니와 상품 정보를 한번에 담을 cartItemInfo 리스트 생성
        List<CartItemInfoDto> cartItemInfoDtoList = new ArrayList<>();

        for (CartItemDto cartItemDto : cartItemDtoList) {
            CartItemInfoDto cartItemInfoDto = new CartItemInfoDto();

            cartItemInfoDto.setCartItemDto(cartItemDto);

            String style_num = cartItemDto.getStyle_num();
            String[] product_id_color = style_num.split("_");
            String product_id = product_id_color[0]; // id
            String color_code = product_id_color[1]; // color

            ProductDto productDto = productDao.selectById(product_id);
            ProductColorDto productColorDto = productColorDao.selectByColorCode(color_code);

            cartItemInfoDto.setProductDto(productDto);
            cartItemInfoDto.setProductColorDto(productColorDto);

            cartItemInfoDtoList.add(cartItemInfoDto);
        }

        return cartItemInfoDtoList;
    }

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
//    public HttpSession addToCart(HttpSession session) throws Exception {
//
//
//    }


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


    /*
        장바구니에서 상품을 삭제하는 경우
    */
    public String removeItems(List<Map<String, String>> items, HttpSession session) throws Exception {
        // 세션에서 장바구니 리스트 가져오기
        List<CartItemDto> cartList = (List<CartItemDto>) session.getAttribute("cartList");

        if (cartList == null) {
            return "장바구니가 비어 있습니다.";
        }

        // items 리스트에 있는 style_num과 p_size를 이용해 해당 아이템을 삭제
        for (Map<String, String> item : items) {
            String style_num = item.get("style_num");
            System.out.println("style_num = " + style_num);

            String p_size = item.get("p_size");
            System.out.println("p_size = " + p_size);

            // 삭제 조건이 정확한지 확인하기 위해 로그 추가
            boolean removed = cartList.removeIf(cartItem -> style_num.equals(cartItem.getStyle_num()) && p_size.equals(String.valueOf(cartItem.getP_size())));
            System.out.println("Item removed: " + removed);
        }

        // 세션에 업데이트된 장바구니 리스트 저장
        session.setAttribute("cartList", cartList);
        System.out.println("Updated cartList: " + cartList);

        return "상품 삭제 성공";
    }
}
