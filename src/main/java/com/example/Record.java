package com.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

/**
 * Created by volyx on 10.11.16.
 */
@Document
public class Record {
    @Id
    private String id;
    @DBRef
    private List<Image> images;

    public Record(String id, List<Image> images) {
        this.id = id;
        this.images = images;
    }

    public Record() {
    }


    public String getId() {
        return id;
    }

    public List<Image> getImages() {
        return images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(id, record.id) &&
                Objects.equals(images, record.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, images);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Record{");
        sb.append("id='").append(id).append('\'');
        sb.append(", images=").append(images);
        sb.append('}');
        return sb.toString();
    }
}
