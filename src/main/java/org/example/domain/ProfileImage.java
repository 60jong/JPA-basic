package org.example.domain;

import javax.persistence.Embeddable;

@Embeddable
public class ProfileImage {
    private String url;

    public ProfileImage() {
    }

    public ProfileImage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
