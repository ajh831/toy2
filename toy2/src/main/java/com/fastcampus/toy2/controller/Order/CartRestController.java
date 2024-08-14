package com.fastcampus.toy2.controller.Order;

import com.fastcampus.toy2.domain.Order.CartItemDto;
import com.fastcampus.toy2.service.Order.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class CartRestController {

    @Autowired
    CartService cartService;

    /*
        고객(회원, 비회원)이 장바구니에 상품을 추가하는 경우
        바로 장바구니에 저장하는 것이 아닌 세션에 list로 저장
    */

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@Valid @RequestBody CartItemDto cartItemDto,
                                            BindingResult bindingResult,
                                            HttpServletRequest request) throws Exception {

        // 유효성 검사에서 오류가 발생한 경우
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append("\n"));
            return new ResponseEntity<>(errorMessage.toString().trim(), HttpStatus.BAD_REQUEST);
        }

        HttpSession session = request.getSession();

        // 세션에서 cartList 호출
        List<CartItemDto> cartItemDtoList = (List<CartItemDto>) session.getAttribute("cartItemList");

        // 세션에 cartListdp 장바구니에 담으려는 정보를 list로 저장
        session.setAttribute("cartItemList", cartItemDtoList.add(cartItemDto));

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

//    @PostMapping("/cart/removeItems")
//    @ResponseBody
//    public ResponseEntity<String> removeItems(@RequestBody List<Map<String, String>> items, HttpSession session) {
//        try {
//            // 세션에서 장바구니 리스트 가져오기
//            List<CartItemDto> cartList = (List<CartItemDto>) session.getAttribute("cartList");
//
//            // items 리스트에 있는 style_num과 p_size를 이용해 해당 아이템을 삭제
//            for (Map<String, String> item : items) {
//                String style_num = item.get("style_num");
//                System.out.println("style_num = " + style_num);
//
//                String p_size = item.get("p_size");
//
//                System.out.println("p_size = " + p_size);
//
//                cartList.removeIf(cartItem -> style_num.equals(cartItem.getStyle_num()) && p_size.equals(String.valueOf(cartItem.getP_size())));
//            }
//
//            // 세션에 업데이트된 장바구니 리스트 저장
//            session.setAttribute("cartList", cartList);
//            System.out.println("Updated cartList: " + cartList);
//
//            return new ResponseEntity<>("상품 삭제 성공", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("상품 삭제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    /*
        장바구니에서 상품을 삭제할 때
    */
    @PostMapping("/cart/removeItems")
    @ResponseBody
    public ResponseEntity<String> removeItems(@RequestBody List<Map<String, String>> items, HttpSession session) {
        try {
            // 세션에서 장바구니 리스트 가져오기
            List<CartItemDto> cartList = (List<CartItemDto>) session.getAttribute("cartList");

            if (cartList == null) {
                return new ResponseEntity<>("장바구니가 비어 있습니다.", HttpStatus.BAD_REQUEST);
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

            return new ResponseEntity<>("상품 삭제 성공", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("상품 삭제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}