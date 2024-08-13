<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
    <link rel="stylesheet" type="text/css" href="/css/cart.css">
</head>
<body>
<div class="shopping-bag">
    <h2>SHOPPING BAG</h2>
    <div class="shopping-bag-container">
        <div class="left">
            <!-- 전체 선택, 선택 삭제 -->
            <div class="head">
                <input type="checkbox" class="cb__style1" id="checkAll" name="checkAll" onclick="CheckedAll3(form1);" />
                <label for="checkAll">전체선택 <span id="checkproductcount">0</span>/7</label>
                <button type="button" class="delete__btn" onclick="CheckedDel();void(0);">품절상품 삭제</button>
                <button type="button" class="delete__btn" onclick="CheckedSoldOut();void(0);" style="margin-right:20px;">선택 삭제</button>
            </div>
            <hr />
            <!-- NEPA 상품 전체선택 섹션 -->
            <div class="nepa-selection">
                <input type="checkbox" class="cb__style1" id="checkBrandNP" data-brand="NP" data-fee="2500" data-limit="30000" />
                <label for="checkBrandNP">NEPA 상품 전체선택 <span id="selectCntNP">0</span>/<span id="totalCntNP">7</span></label>
            </div>
            <hr />
            <!-- 장바구니 리스트 -->
            <ul class="order__list">
                <!-- 첫 번째 상품 -->
                <li class="product-item">
                    <div class="chk">
                        <input type="checkbox" class="cb__style1" id="checkProduct0" name="checkwish" value="35172^M01^270" />
                        <label for="checkProduct0"></label>
                    </div>
                    <div class="photo">
                        <img src="https://via.placeholder.com/100" alt="상품 이미지" />
                    </div>
                    <div class="info">
                        <p class="brand">NEPA</p>
                        <p class="name">남성 ASLON R 24 애슬론 리조트 24</p>
                        <p class="color">NAVY(M01) / 270</p>
                        <p class="qty">수량 : 3</p>
                        <p class="price">￦ 417,000</p>
                    </div>
                    <div class="btn-box">
                        <a href="#" class="option__btn white">옵션변경</a>
                        <a href="#" class="buy__btn black">바로구매</a>
                    </div>
                </li>
                <!-- 두 번째 상품 -->
                <li class="product-item">
                    <div class="chk">
                        <input type="checkbox" class="cb__style1" id="checkProduct1" name="checkwish" value="35172^C01^255" />
                        <label for="checkProduct1"></label>
                    </div>
                    <div class="photo">
                        <img src="https://via.placeholder.com/100" alt="상품 이미지" />
                    </div>
                    <div class="info">
                        <p class="brand">NEPA</p>
                        <p class="name">남성 ASLON T 24 애슬론 트래블 24</p>
                        <p class="color">BLACK(C01) / 255</p>
                        <p class="qty">수량 : 1</p>
                        <p class="price">￦ 89,000</p>
                    </div>
                    <div class="btn-box">
                        <a href="#" class="option__btn white">옵션변경</a>
                        <a href="#" class="buy__btn black">바로구매</a>
                    </div>
                </li>
                <!-- 세 번째 상품 -->
                <li class="product-item">
                    <div class="chk">
                        <input type="checkbox" class="cb__style1" id="checkProduct2" name="checkwish" value="35172^C01^250" />
                        <label for="checkProduct2"></label>
                    </div>
                    <div class="photo">
                        <img src="https://via.placeholder.com/100" alt="상품 이미지" />
                    </div>
                    <div class="info">
                        <p class="brand">NEPA</p>
                        <p class="name">여성 BENITA 베니타</p>
                        <p class="color">BLACK(C01) / 250</p>
                        <p class="qty">수량 : 3</p>
                        <p class="price">￦ 225,000</p>
                    </div>
                    <div class="btn-box">
                        <a href="#" class="option__btn white">옵션변경</a>
                        <a href="#" class="buy__btn black">바로구매</a>
                    </div>
                </li>
            </ul>
        </div>
        <div class="right">
            <div class="total-box">
                <dl>
                    <dt>상품수량</dt>
                    <dd><span id="productqty">4</span>개</dd>
                </dl>
                <dl>
                    <dt>총 주문금액</dt>
                    <dd><span class="won">￦</span>&nbsp;<span id="productprice">506,000</span></dd>
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
                        <dd><span class="won">￦</span>&nbsp;<span id="productpay">506,000</span></dd>
                    </dl>
                </div>
                <a href="#" class="buy__btn on">
                    <span class="num">총 2건</span>
                    <span class="price">결제하기&nbsp&nbsp|&nbsp&nbsp<i class="won">￦</i>&nbsp;<span id="producttotalpay">506,000</span></span>
                </a>
            </div>
            <p class="info-text">장기간 보관하신 상품은 시간이 지남에 따라 가격과 혜택이 변동 될 수 있으며, 최대 30일동안 보관됩니다.</p>
        </div>
    </div>
</div>
</body>
</html>