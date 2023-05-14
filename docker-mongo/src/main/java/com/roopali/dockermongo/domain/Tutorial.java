package com.roopali.dockermongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tutorials")
public class Tutorial {

    @Id
    private String id;

    private String tutorialName;
    private String desc;
    private String published;

    public Tutorial(String tutorialName, String desc, String published) {
        this.tutorialName = tutorialName;
        this.desc = desc;
        this.published = published;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTutorialName() {
        return tutorialName;
    }

    public void setTutorialName(String tutorialName) {
        this.tutorialName = tutorialName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tutorial{");
        sb.append("id='").append(id).append('\'');
        sb.append(", tutorialName='").append(tutorialName).append('\'');
        sb.append(", desc='").append(desc).append('\'');
        sb.append(", published='").append(published).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
