package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostConstructBean {

    private MongoTemplate mongoTemplate;

    public PostConstructBean(@Autowired MongoTemplate mongoTemplate) {

        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    public void init() {
        initMongo();
        final List<Story> stories = mongoTemplate.findAll(Story.class);
        System.out.println(stories.size());

    }

    private void initMongo() {
        if (mongoTemplate.findAll(Story.class).size() > 0) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            List<Record> records = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                List<Image> images = new ArrayList<>();
                for (int k = 0; k < 10; k++) {
                    final Image image = new Image(null, "url" + k);
                    mongoTemplate.save(image);
                    images.add(image);
                }
                Record record = new Record(null, images);
                mongoTemplate.save(record);
                records.add(record);
            }
            Story story = new Story(null, "Story-" + i, records);
            mongoTemplate.save(story);
        }
    }
}
