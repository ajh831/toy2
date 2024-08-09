package com.fastcampus.toy2.domain.Product;

import java.util.Date;
import java.util.Objects;

public class ProductColorDto {
    private String color_code;
    private String english_color;
    private String korean_color;
    private Date created_dt;
    private String created_id;
    private Date updated_dt;
    private String updated_id;

    @Override
    public String toString() {
        return "ProductColorDto{" +
                "color_code='" + color_code + '\'' +
                ", english_color='" + english_color + '\'' +
                ", korean_color='" + korean_color + '\'' +
                ", created_dt=" + created_dt +
                ", created_id='" + created_id + '\'' +
                ", updated_dt=" + updated_dt +
                ", updated_id='" + updated_id + '\'' +
                '}';
    }

    private ProductColorDto() {
    }

    public ProductColorDto(Builder builder) {
        this.color_code = builder.color_code;
        this.english_color = builder.english_color;
        this.korean_color = builder.korean_color;
        this.created_id = builder.created_id;
        this.updated_id = builder.updated_id;
    }

    public String getColor_code() {
        return color_code;
    }

    public String getEnglish_color() {
        return english_color;
    }

    public String getKorean_color() {
        return korean_color;
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

    public static class Builder {
        private String color_code;
        private String english_color;
        private String korean_color;
        private String created_id;
        private String updated_id;

        public Builder() {
        }

        public Builder color_code(String color_code) {
            this.color_code = color_code;
            return this;
        }

        public Builder english_color(String english_color) {
            this.english_color = english_color;
            return this;
        }

        public Builder korean_color(String korean_color) {
            this.korean_color = korean_color;
            return this;
        }

        public Builder created_id(String created_id) {
            this.created_id = created_id;
            return this;
        }

        public Builder updated_id(String updated_id) {
            this.updated_id = updated_id;
            return this;
        }

        public ProductColorDto build() {
            return new ProductColorDto(this);
        }
    }
}
