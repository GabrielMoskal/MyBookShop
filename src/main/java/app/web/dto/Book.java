package app.web.dto;

/**
 * Created by Gabriel on 04.04.2017.
 */
public class Book {
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

    private Book() {
    }

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

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDevices() {
        return devices;
    }

    public void setDevices(String devices) {
        this.devices = devices;
    }

    public String getPrinting() {
        return printing;
    }

    public void setPrinting(String printing) {
        this.printing = printing;
    }

    public String getCopying() {
        return copying;
    }

    public void setCopying(String copying) {
        this.copying = copying;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (translator != null ? !translator.equals(book.translator) : book.translator != null) return false;
        if (publisher != null ? !publisher.equals(book.publisher) : book.publisher != null) return false;
        if (year != null ? !year.equals(book.year) : book.year != null) return false;
        if (language != null ? !language.equals(book.language) : book.language != null) return false;
        if (pages != null ? !pages.equals(book.pages) : book.pages != null) return false;
        if (format != null ? !format.equals(book.format) : book.format != null) return false;
        if (devices != null ? !devices.equals(book.devices) : book.devices != null) return false;
        if (printing != null ? !printing.equals(book.printing) : book.printing != null) return false;
        if (copying != null ? !copying.equals(book.copying) : book.copying != null) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;
        if (category != null ? !category.equals(book.category) : book.category != null) return false;
        return imgUrl != null ? imgUrl.equals(book.imgUrl) : book.imgUrl == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (translator != null ? translator.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (devices != null ? devices.hashCode() : 0);
        result = 31 * result + (printing != null ? printing.hashCode() : 0);
        result = 31 * result + (copying != null ? copying.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        return result;
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

        public Builder index(Long index) {
            this.index = index;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder translator(String translator) {
            this.translator = translator;
            return this;
        }

        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder year(Integer year) {
            this.year = year;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public Builder pages(Integer pages) {
            this.pages = pages;
            return this;
        }

        public Builder format(String format) {
            this.format = format;
            return this;
        }

        public Builder devices(String devices) {
            this.devices = devices;
            return this;
        }

        public Builder printing(String printing) {
            this.printing = printing;
            return this;
        }

        public Builder copying(String copying) {
            this.copying = copying;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder imgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
