package com.fastcampus.toy2.domain.Order;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class CartDto {
//    @NonNull
    private String crt_id;
    private String mbr_id;
    private char crt_st;

    CartDto() {

    }

    CartDto(Builder builder) {
        this.crt_id = builder.crt_id;
        this.mbr_id = builder.mbr_id;
    }

    public String getCrt_id() {
        return crt_id;
    }

    public String getMbr_id() {
        return mbr_id;
    }

    public char getCrt_st() {
        return crt_st;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "crt_id='" + crt_id + '\'' +
                ", mbr_id='" + mbr_id + '\'' +
                ", crt_st=" + crt_st +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDto cartDto = (CartDto) o;
        return crt_st == cartDto.crt_st && Objects.equals(crt_id, cartDto.crt_id) && Objects.equals(mbr_id, cartDto.mbr_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crt_id, mbr_id, crt_st);
    }

    public static class Builder {
        private String crt_id;
        private String mbr_id;

        public Builder crt_id(String crt_id) {
            this.crt_id = crt_id;
            return this;
        }

        public Builder mbr_id(String mbr_id) {
            this.mbr_id = mbr_id;
            return this;
        }

        public CartDto build() {
            return new CartDto(this);
        }
    }
}
