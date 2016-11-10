package com.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**
 * Created by volyx on 10.11.16.
 */
@Document
public class Image {

    @Id
    private String id;

    private String url;

    public Image(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public Image() {
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) &&
                Objects.equals(url, image.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Image{");
        sb.append("id='").append(id).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
