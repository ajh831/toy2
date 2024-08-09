package com.fastcampus.toy2.domain.Product;

import main.java.com.fastcampus.toy2.domain.Admin.AdminDto;

import java.util.Date;
import java.util.Objects;

public class ProductKindDto {
    private String Style_num;
    private String product_id;
    private String color_code;
    private String sale_state;
    private Date created_dt;
    private String created_id;
    private Date updated_dt;
    private String updated_id;

    public ProductKindDto(Builder builder) {
        this.Style_num = builder.Style_num;
        this.product_id = builder.product_id;
        this.color_code = builder.color_code;
        this.sale_state = builder.sale_state;
        this.created_dt = builder.created_dt;
        this.created_id = builder.created_id;
        this.updated_dt = builder.updated_dt;
        this.updated_id = builder.updated_id;
    }

    public String getStyle_num() {
        return Style_num;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getColor_code() {
        return color_code;
    }

    public String getSale_state() {
        return sale_state;
    }

    public Date getCreated_dt() {
        return created_dt;
    }

    public String getCreated_id() {
        return created_id;
    }

    public Date getUpdated_dt() {
        return updated_dt;
    }

    public String getUpdated_id() {
        return updated_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductKindDto that = (ProductKindDto) o;
        return Objects.equals(Style_num, that.Style_num) && Objects.equals(product_id, that.product_id) && Objects.equals(color_code, that.color_code) && Objects.equals(sale_state, that.sale_state) && Objects.equals(created_dt, that.created_dt) && Objects.equals(created_id, that.created_id) && Objects.equals(updated_dt, that.updated_dt) && Objects.equals(updated_id, that.updated_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Style_num, product_id, color_code, sale_state);
    }

    @Override
    public String toString() {
        return "ProductKindDto{" +
                "Style_num='" + Style_num + '\'' +
                ", product_id='" + product_id + '\'' +
                ", color_code='" + color_code + '\'' +
                ", sale_state='" + sale_state + '\'' +
                ", created_dt=" + created_dt +
                ", created_id='" + created_id + '\'' +
                ", updated_dt=" + updated_dt +
                ", updated_id='" + updated_id + '\'' +
                '}';
    }

    public static class Builder {
        private String Style_num;
        private String product_id;
        private String color_code;
        private String sale_state;
        private Date created_dt;
        private String created_id;
        private Date updated_dt;
        private String updated_id;

        public Builder() {
        }

        public Builder setStyle_num(String style_num) {
            Style_num = style_num;
            return this;
        }

        public Builder setProduct_id(String product_id) {
            this.product_id = product_id;
            return this;
        }

        public Builder setColor_code(String color_code) {
            this.color_code = color_code;
            return this;
        }

        public Builder setSale_state(String sale_state) {
            this.sale_state = sale_state;
            return this;
        }

        public Builder setCreated_dt(Date created_dt) {
            this.created_dt = created_dt;
            return this;
        }

        public Builder setCreated_id(String created_id) {
            this.created_id = created_id;
            return this;
        }

        public Builder setUpdated_dt(Date updated_dt) {
            this.updated_dt = updated_dt;
            return this;
        }

        public Builder setUpdated_id(String updated_id) {
            this.updated_id = updated_id;
            return this;
        }

        public ProductKindDto builder() {
            return new ProductKindDto(this);
        }
    }
}
