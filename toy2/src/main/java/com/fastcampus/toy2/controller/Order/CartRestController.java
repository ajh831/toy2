package com.fastcampus.toy2.controller.Order;

import com.fastcampus.toy2.domain.Order.CartItemDto;
import com.fastcampus.toy2.domain.User.MemberDto;
import com.fastcampus.toy2.service.Order.CartService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@RestController
@RequestMapping("/order")
public class CartRestController {

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@Valid @RequestBody CartItemDto cartItemDto,
                                            BindingResult bindingResult,
                                            HttpSession session) throws Exception {

        // 유효성 검사에서 오류가 발생한 경우
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append("\n"));
            return new ResponseEntity<>(errorMessage.toString().trim(), HttpStatus.BAD_REQUEST);
        }

        // 세션에서 회원 정보 가져오기
        String mbr_id = (String) session.getAttribute("mbr_id");
        MemberDto memberDto = new MemberDto();
        memberDto.setMbr_id(mbr_id);

        // 장바구니에 상품 추가
        CartService cartService = new CartService();
        int result = cartService.addToCart(memberDto, cartItemDto);

        if (result != 1) {
            return new ResponseEntity<>("bad", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}