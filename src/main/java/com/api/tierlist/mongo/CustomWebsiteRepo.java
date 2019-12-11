package com.api.tierlist.mongo;

import com.mongodb.client.result.UpdateResult;

public interface CustomWebsiteRepo {
    UpdateResult updateWebsiteInfo(String website, int updatedCount);
}
