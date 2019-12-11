package com.api.tierlist.mongo;

import com.api.tierlist.weblist.WebsiteInfo;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class CustomWebsiteRepoImpl implements CustomWebsiteRepo {

    @Autowired
    MongoTemplate template;

    @Override
    public UpdateResult updateWebsiteInfo(String website, int updatedCount) {
        Query query = new Query(Criteria.where("websiteName").is(website));
        Update update = new Update();
        update.set("voteCount", updatedCount);

        return template.updateFirst(query, update, WebsiteInfo.class);
    }
}
