package com.fastcampus.toy2.domain.Order;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class CartDto {
    private String cart_id;
    private String mbr_id;
    private String nm_id;
    private char crt_st;

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getMbr_id() {
        return mbr_id;
    }

    public void setMbr_id(String mbr_id) {
        this.mbr_id = mbr_id;
    }

    public String getNm_id() {
        return nm_id;
    }

    public void setNm_id(String nm_id) {
        this.nm_id = nm_id;
    }

    public char getCrt_st() {
        return crt_st;
    }

    public void setCrt_st(char crt_st) {
        this.crt_st = crt_st;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "cart_id='" + cart_id + '\'' +
                ", mbr_id='" + mbr_id + '\'' +
                ", nm_id='" + nm_id + '\'' +
                ", crt_st=" + crt_st +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDto cartDto = (CartDto) o;
        return crt_st == cartDto.crt_st && Objects.equals(cart_id, cartDto.cart_id) && Objects.equals(mbr_id, cartDto.mbr_id) && Objects.equals(nm_id, cartDto.nm_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart_id, mbr_id, nm_id, crt_st);
    }
}
