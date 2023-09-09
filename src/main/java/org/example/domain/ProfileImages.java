package org.example.domain;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Embeddable
public class ProfileImages {
    @ElementCollection
    @CollectionTable(
            name = "Profile_Image",
            joinColumns = @JoinColumn(name = "member_id")
    )
    private List<ProfileImage> profileImages = new ArrayList<>();

    public List<String> getProfileImageUrls() {
        return profileImages.stream()
                .map(ProfileImage::getUrl)
                .collect(Collectors.toList());
    }
}
