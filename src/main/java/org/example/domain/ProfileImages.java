package org.example.domain;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Embeddable
public class ProfileImages {
    @ElementCollection
    @CollectionTable(
            name = "Profile_Image",
            joinColumns = @JoinColumn(name = "member_id")
    )
    private Set<ProfileImage> profileImages = new HashSet<>();

    public Set<String> getProfileImageUrls() {
        return profileImages.stream()
                .map(ProfileImage::getUrl)
                .collect(Collectors.toSet());
    }

    public void removeUrl(String url) {
        ProfileImage toRemove = this.profileImages.stream()
                .filter(profileImage -> profileImage.getUrl().equals(url))
                .findAny().get();

        profileImages.remove(toRemove);
    }

}
