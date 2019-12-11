package com.api.tierlist.mongo;

import com.api.tierlist.weblist.WebsiteInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebsiteRepository extends MongoRepository<WebsiteInfo, String> {
    WebsiteInfo findFirstByWebsiteName(String websiteName);
}
