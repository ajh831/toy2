package com.fastcampus.toy2.controller.Order;

import com.fastcampus.toy2.domain.Order.CartItemDto;
import com.fastcampus.toy2.domain.Order.CartItemInfoDto;
import com.fastcampus.toy2.service.Order.CartService;
import com.fastcampus.toy2.service.Order.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class CartController {

    @Autowired
    CartService cartService;

    /*
        크게 장바구니를 나누어서 생각한다면?

        1. 장바구니에 담고나서 로그인 하는 경우
        2. 로그인 하고 장바구니에 담는 경우
    */

    // 바로구매하기 버튼을 클릭한다
    @PostMapping("/buyToItem")
    public String buyToItem(@RequestParam("style_num") String styleNum,
                            @RequestParam("price") Integer price,
                            @RequestParam("size") String size,
                            @RequestParam("count") Integer quantity,
                            Model model, HttpSession session) throws Exception {


        return "/order/buy";
    }


    /*
        장바구니 페이지로 이동하는 경우.
        1. 세션에서 장바구니 리스트를 불러온다.
        2. 장바구니 리스트를 모델에 담아서 cart.jsp 페이지로 넘긴다.
            - cartItem에서 다루는 정보 : sytle_num, p_size
            - 판매 상태를 다루기 위해서는 product_size 테이블의 판매 상태 코드 필요
              (품절인 경우 때문)
            - 상품 가격정보를 알기위해서는 product 테이블에서 가격정보(실판가)를 가져와야 됨
    */
    @RequestMapping("/cart")
    public String getCartList(Model model, HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        List<CartItemDto> cartItemDtoList = (List<CartItemDto>) session.getAttribute("cartList");

        // 테스트
        if (cartItemDtoList == null) {
            cartItemDtoList = new ArrayList<>();
            CartItemDto sample = new CartItemDto();
            sample.setStyle_num("7K17664_K01");
            sample.setP_size(230);
            sample.setCount(2);
            cartItemDtoList.add(sample);

            CartItemDto sample2 = new CartItemDto();
            sample2.setStyle_num("7K27661_B00");
            sample2.setP_size(255);
            sample2.setCount(3);
            cartItemDtoList.add(sample2);
        }

        List<CartItemInfoDto> cartItemInfoDtoList = cartService.getCartProduct(cartItemDtoList);

        session.setAttribute("cartList", cartItemDtoList);
        model.addAttribute("cartList", cartItemInfoDtoList);

        return "/order/cart";
    }

    // 주문하기 버튼을 클릭한다.
    @RequestMapping("/pay")
    public String getOrderList(Model model, HttpSession session, HttpServletRequest request) throws Exception {

        CartServiceImpl cartServiceImpl = new CartServiceImpl();

        return "/order/pay";
    }
}
