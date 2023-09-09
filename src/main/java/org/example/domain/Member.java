package org.example.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    private Long id;
    private String name;

    @ElementCollection
    @CollectionTable(
            name = "Profile_Image",
            joinColumns = @JoinColumn(name = "member_id")
    )
    private List<ProfileImage> profileImages = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProfileImage> getProfileImages() {
        return profileImages;
    }
}
