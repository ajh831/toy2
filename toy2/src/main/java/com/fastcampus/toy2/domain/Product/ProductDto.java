package com.fastcampus.toy2.domain.Product;

import java.util.Date;
import java.util.Objects;

public class ProductDto {
    private String product_id;
    private String p_name;
    private String p_gender;
    private Integer p_origin_price;
    private Integer p_sale_price;
    private Integer p_discount_per;
    private Integer member_benefit_price;
    private Float p_average_grade;
    private String p_brief_text;
    private String materials_care_methods;
    private String sale_state;
    private String main_image_url;
    private String p_season;
    private Integer category_id;
    private Date created_dt;
    private String created_id;
    private Date updated_dt;
    private String updated_id;

    @Override
    public String toString() {
        return "ProductDto{" +
                "product_id='" + product_id + '\'' +
                ", p_name='" + p_name + '\'' +
                ", p_gender='" + p_gender + '\'' +
                ", p_origin_price=" + p_origin_price +
                ", p_sale_price=" + p_sale_price +
                ", p_discount_per=" + p_discount_per +
                ", member_benefit_price=" + member_benefit_price +
                ", p_average_grade=" + p_average_grade +
                ", p_brief_text='" + p_brief_text + '\'' +
                ", materials_care_methods='" + materials_care_methods + '\'' +
                ", sale_state='" + sale_state + '\'' +
                ", main_image_url='" + main_image_url + '\'' +
                ", p_season='" + p_season + '\'' +
                ", category_id=" + category_id +
                ", created_dt=" + created_dt +
                ", created_id='" + created_id + '\'' +
                ", updated_dt=" + updated_dt +
                ", updated_id='" + updated_id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto productDto = (ProductDto) o;
        return
                Objects.equals(product_id, productDto.getProduct_id()) &&
                        Objects.equals(p_name, productDto.getP_name()) &&
                        Objects.equals(p_gender, productDto.getP_gender()) &&
                        Objects.equals(p_origin_price, productDto.getP_origin_price()) &&
                        Objects.equals(p_sale_price, productDto.getP_sale_price()) &&
                        Objects.equals(p_discount_per, productDto.getP_discount_per()) &&
                        Objects.equals(member_benefit_price, productDto.getMember_benefit_price()) &&
                        Objects.equals(p_average_grade, productDto.getP_average_grade()) &&
                        Objects.equals(p_brief_text, productDto.getP_brief_text()) &&
                        Objects.equals(materials_care_methods, productDto.getMaterials_care_methods()) &&
                        Objects.equals(sale_state, productDto.getSale_state()) &&
                        Objects.equals(main_image_url, productDto.getMain_image_url()) &&
                        Objects.equals(p_season, productDto.getP_season()) &&
                        Objects.equals(category_id, productDto.getCategory_id()) &&
                        Objects.equals(created_id, productDto.getCreated_id()) &&
                        Objects.equals(updated_id, productDto.getUpdated_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, p_name, p_origin_price);
    }

    private ProductDto() {
    }

    public ProductDto(Builder builder) {
        this.product_id = builder.product_id;
        this.p_name = builder.p_name;
        this.p_gender = builder.p_gender;
        this.p_origin_price = builder.p_origin_price;
        this.p_sale_price = builder.p_sale_price;
        this.p_discount_per = builder.p_discount_per;
        this.member_benefit_price = builder.member_benefit_price;
        this.p_average_grade = builder.p_average_grade;
        this.p_brief_text = builder.p_brief_text;
        this.materials_care_methods = builder.materials_care_methods;
        this.sale_state = builder.sale_state;
        this.main_image_url = builder.main_image_url;
        this.p_season = builder.p_season;
        this.category_id = builder.category_id;
        this.created_dt = builder.created_dt;
        this.created_id = builder.created_id;
        this.updated_dt = builder.updated_dt;
        this.updated_id = builder.updated_id;
    }

    public static class Builder {
        private String product_id;
        private String p_name;
        private String p_gender;
        private Integer p_origin_price;
        private Integer p_sale_price;
        private Integer p_discount_per;
        private Integer member_benefit_price;
        private Float p_average_grade;
        private String p_brief_text;
        private String materials_care_methods;
        private String sale_state;
        private String main_image_url;
        private String p_season;
        private Integer category_id;
        private Date created_dt;
        private String created_id;
        private Date updated_dt;
        private String updated_id;

        public Builder() {
        }

        public Builder product_id(String product_id) {
            this.product_id = product_id;
            return this;
        }

        public Builder p_name(String p_name) {
            this.p_name = p_name;
            return this;
        }

        public Builder p_gender(String p_gender) {
            this.p_gender = p_gender;
            return this;
        }

        public Builder p_origin_price(Integer p_origin_price) {
            this.p_origin_price = p_origin_price;
            return this;
        }

        public Builder p_sale_price(Integer p_sale_price) {
            this.p_sale_price = p_sale_price;
            return this;
        }

        public Builder p_discount_per(Integer p_discount_per) {
            this.p_discount_per = p_discount_per;
            return this;
        }
