package com.fastcampus.toy2.domain.Order;

import java.sql.Timestamp;

public class CartItemDto {
    private Long crt_id;
    private Integer crt_seq;
    private String style_num;
    private Integer p_size;
    private Integer count;
    private Timestamp crt_item_date;
    private char state;

    CartItemDto() {

    }

    CartItemDto(Builder builder) {
        this.crt_id = builder.crt_id;
        this.crt_seq = builder.crt_seq;
        this.style_num = builder.style_num;
        this.p_size = builder.p_size;
        this.count = builder.count;
        this.crt_item_date = builder.crt_item_date;
        this.state = builder.state;
    }

    public Long getCrt_id() {
        return crt_id;
    }

    public Integer getcrt_seq() {
        return crt_seq;
    }

    public String getStyle_num() {
        return style_num;
    }

    public Integer getP_size() {
        return p_size;
    }

    public Integer getCount() {
        return count;
    }

    public Timestamp getCrt_item_date() {
        return crt_item_date;
    }

    public char getState() {
        return state;
    }

    public static class Builder {
        private Long crt_id;
        private Integer crt_seq;
        private String style_num;
        private Integer p_size;
        private Integer count;
        private Timestamp crt_item_date;
        private char state;

        public Builder crt_id(Long crt_id) {
            this.crt_id = crt_id;
            return this;
        }

        public Builder crt_seq(Integer crt_seq) {
            this.crt_seq = crt_seq;
            return this;
        }

        public Builder style_num(String style_num) {
            this.style_num = style_num;
            return this;
        }

        public Builder p_size(Integer p_size) {
            this.p_size = p_size;
            return this;
        }

        public Builder count(Integer count) {
            this.count = count;
            return this;
        }

        public Builder crt_item_date(Timestamp crt_item_date) {
            this.crt_item_date = crt_item_date;
            return this;
        }

        public Builder state(char state) {
            this.state = state;
            return this;
        }

        public CartItemDto build() {
            return new CartItemDto(this);
        }
    }

}
