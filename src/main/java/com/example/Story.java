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
public class Story {

    @Id
    private String id;

    private String title;
    @DBRef
    private List<Record> records;

    public Story(String id, String title, List<Record> records) {
        this.id = id;
        this.title = title;
        this.records = records;
    }

    public Story() {
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Record> getRecords() {
        return records;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return Objects.equals(id, story.id) &&
                Objects.equals(title, story.title) &&
                Objects.equals(records, story.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, records);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Story{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", records=").append(records);
        sb.append('}');
        return sb.toString();
    }
}
