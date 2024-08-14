<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
    <link rel="stylesheet" type="text/css" href="/css/cart.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/js/cart.js"></script>
</head>
<body>
<div class="shopping-bag">
    <h2>SHOPPING BAG</h2>
    <div class="shopping-bag-container">
        <div class="left">
            <!-- 전체 선택, 선택 삭제 -->
            <div class="head">
                <input type="checkbox" class="cb__style1 checkAll" id="checkAll" name="checkAll" />
                <label for="checkAll">전체선택 <span class="selectedCount">0</span>/${cartList.size()}</label>
                <button type="button" class="delete__btn soldout">품절상품 삭제</button>
                <button type="button" class="delete__btn select" style="margin-right:20px;">선택 삭제</button>
            </div>
            <hr />
            <c:choose>
                <c:when test="${empty cartList || cartList.size() == 0}">
                    <div class="empty-cart-message">
                        <p>쇼핑백에 등록된 상품이 없습니다.</p>
                    </div>
                </c:when>
                <c:otherwise>
                    <!-- 장바구니 리스트 -->
                    <ul class="order__list">
                        <c:forEach var="item" items="${cartList}">
                            <li class="product-item">
                                <div class="chk">
                                    <input type="checkbox" class="cb__style1 product-check"
                                           data-price="${item.productDto.p_origin_price * item.cartItemDto.count}"
                                           data-count="${item.cartItemDto.count}"
                                           data-stylenum="${item.cartItemDto.style_num}"
                                           data-psize="${item.cartItemDto.p_size}"
                                           id="checkProduct${item.cartItemDto.style_num}_${item.cartItemDto.p_size}"
                                           name="checkwish_${item.cartItemDto.style_num}_${item.cartItemDto.p_size}" />
                                    <label for="checkProduct${item.cartItemDto.crt_seq}"></label>
                                </div>
                                <div class="photo">
                                    <img src="https://via.placeholder.com/100" alt="상품 이미지" />
                                </div>
                                <div class="info">
                                    <p class="brand">NEPA</p>
                                    <p class="name">${item.productDto.p_name}</p>
                                    <p class="color size">
                                        <span class="color">${item.productColorDto.english_color}(${item.productColorDto.color_code})</span>
                                        <span class="size"> / ${item.cartItemDto.p_size}</span>
                                    </p>
                                    <p class="qty">수량 : ${item.cartItemDto.count}</p>
                                    <p class="price">￦ ${item.productDto.p_origin_price * item.cartItemDto.count}</p>
                                </div>
                                <div class="btn-box">
                                    <a href="#" class="option__btn white">옵션변경</a>
                                    <a href="#" class="buy__btn black">바로구매</a>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="right">
            <div class="total-box">
                <dl>
                    <dt>상품수량</dt>
                    <dd><span class="selectedCount">0</span>개</dd>
                </dl>
                <dl>
                    <dt>총 주문금액</dt>
                    <dd><span class="won">￦</span>&nbsp;<span class="selectedTotalPrice">0</span></dd>
                </dl>
                <dl>
                    <dt>배송비</dt>
                    <dd><span class="won">￦</span>&nbsp;<span id="productfee">0</span></dd>
                </dl>
                <dl>
                    <dt>할인금액</dt>
                    <dd><span class="won">￦</span>&nbsp;<span id="productsale">0</span></dd>
                </dl>
                <div class="total">
                    <dl>
                        <dt>총 결제금액</dt>
                        <dd><span class="won">￦</span>&nbsp;<span class="selectedTotalPrice">0</span></dd>
                    </dl>
                </div>
                <a href="#" class="buy__btn on">
                    <span class="num">총 <span class="selectedCount">0</span>건</span>
                    <span class="price">결제하기&nbsp&nbsp|&nbsp&nbsp<i class="won">￦</i>&nbsp;<span class="selectedTotalPrice">0</span></span>
                </a>
            </div>
            <p class="info-text">장기간 보관하신 상품은 시간이 지남에 따라 가격과 혜택이 변동 될 수 있으며, 최대 30일동안 보관됩니다.</p>
        </div>
    </div>
</div>
</body>
</html>