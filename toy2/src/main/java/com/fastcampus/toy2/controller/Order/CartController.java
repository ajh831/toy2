package com.fastcampus.toy2.controller.Order;

import com.fastcampus.toy2.service.Order.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class CartController {

    // 1. 메뉴의 장바구니 버튼을 클릭한다.
    @RequestMapping("/cart")
    public String getList(Model model, HttpSession session, HttpServletRequest request) throws Exception {

        CartService cartService = new CartService();

        return "작성필요";
    }
}
