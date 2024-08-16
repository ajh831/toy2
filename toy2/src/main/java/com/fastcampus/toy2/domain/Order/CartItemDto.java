package com.fastcampus.toy2.domain.Order;

public class CartItemDto {
    private String crt_id;
    private Integer crt_seq;
    private String style_num;
    private Integer p_size;
    private Integer count;
    private char ord_st;
    private char state;

    CartItemDto() {

    }

    CartItemDto(Builder builder) {
        this.crt_id = builder.crt_id;
        this.crt_seq = builder.crt_seq;
        this.style_num = builder.style_num;
        this.p_size = builder.p_size;
        this.count = builder.count;
        this.ord_st = builder.ord_st;
        this.state = builder.state;
    }

    public String getCrt_id() {
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

    public char getOrd_st() {
        return ord_st;
    }

    public char getState() {
        return state;
    }

    public static class Builder {
        private String crt_id;
        private Integer crt_seq;
        private String style_num;
        private Integer p_size;
        private Integer count;
        private char ord_st;
        private char state;

        public Builder crt_id(String crt_id) {
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

        public Builder ord_st(char ord_st) {
            this.ord_st = ord_st;
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
