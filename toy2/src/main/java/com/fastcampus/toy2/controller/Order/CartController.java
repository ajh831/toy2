package com.fastcampus.toy2.controller.Order;

import com.fastcampus.toy2.domain.Order.CartItemDto;
import com.fastcampus.toy2.domain.User.MemberDto;
import com.fastcampus.toy2.service.Order.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/order")
public class CartController {

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


    // 장바구니 버튼을 클릭한다.
    @RequestMapping("/cart")
    public String getCartList(Model model, HttpSession session, HttpServletRequest request) throws Exception {

        CartService cartService = new CartService();

        return "/order/cart";
    }

    // 주문하기 버튼을 클릭한다.
    @RequestMapping("/pay")
    public String getOrderList(Model model, HttpSession session, HttpServletRequest request) throws Exception {

        CartService cartService = new CartService();

        return "/order/pay";
    }
}
