package app.web.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by Gabriel on 04.04.2017.
 */
@Getter
@EqualsAndHashCode
@ToString
public class Book {
    private final Long index;
    private final String title;
    private final String author;
    private final String translator;
    private final String publisher;
    private final Integer year;
    private final String language;
    private final Integer pages;
    private final String format;
    private final String devices;
    private final String printing;
    private final String copying;
    private final String description;
    private final String category;
    private final String imgUrl;

    private Book(Builder builder) {
        this.index = builder.index;
        this.title = builder.title;
        this.author = builder.author;
        this.translator = builder.translator;
        this.publisher = builder.publisher;
        this.year = builder.year;
        this.language = builder.language;
        this.pages = builder.pages;
        this.format = builder.format;
        this.devices = builder.devices;
        this.printing = builder.printing;
        this.copying = builder.copying;
        this.description = builder.description;
        this.category = builder.category;
        this.imgUrl = builder.imgUrl;
    }

    public static class Builder {
        private Long index;
        private String title;
        private String author;
        private String translator;
        private String publisher;
        private Integer year;
        private String language;
        private Integer pages;
        private String format;
        private String devices;
        private String printing;
        private String copying;
        private String description;
        private String category;
        private String imgUrl;

        public Builder index(final Long index) {
            this.index = index;
            return this;
        }

        public Builder title(final String title) {
            this.title = title;
            return this;
        }

        public Builder author(final String author) {
            this.author = author;
            return this;
        }

        public Builder translator(final String translator) {
            this.translator = translator;
            return this;
        }

        public Builder publisher(final String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder year(final Integer year) {
            this.year = year;
            return this;
        }

        public Builder language(final String language) {
            this.language = language;
            return this;
        }

        public Builder pages(final Integer pages) {
            this.pages = pages;
            return this;
        }

        public Builder format(final String format) {
            this.format = format;
            return this;
        }

        public Builder devices(final String devices) {
            this.devices = devices;
            return this;
        }

        public Builder printing(final String printing) {
            this.printing = printing;
            return this;
        }

        public Builder copying(final String copying) {
            this.copying = copying;
            return this;
        }

        public Builder description(final String description) {
            this.description = description;
            return this;
        }

        public Builder category(final String category) {
            this.category = category;
            return this;
        }

        public Builder imgUrl(final String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
