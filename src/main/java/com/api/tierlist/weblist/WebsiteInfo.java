package com.api.tierlist.weblist;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "website_data")
public class WebsiteInfo {

    @Id
    private String id;

    public WebsiteInfo(String websiteName, String websiteDescription, int voteCount) {
        this.websiteName = websiteName;
        this.websiteDescription = websiteDescription;
        this.voteCount = voteCount;
    }

    private String websiteName;
    private String websiteDescription;
    private int voteCount;

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteDescription() {
        return websiteDescription;
    }

    public void setWebsiteDescription(String websiteDescription) {
        this.websiteDescription = websiteDescription;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
