package com.api.tierlist;

import com.api.tierlist.mongo.CustomWebsiteRepo;
import com.api.tierlist.mongo.WebsiteRepository;
import com.api.tierlist.weblist.WebsiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TierlistController {

    @Autowired
    CustomWebsiteRepo customWebsiteRepo;

    @Autowired
    WebsiteRepository websiteRepository;

    @RequestMapping("healthcheck")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity healthcheck(){
        return ResponseEntity.ok("Tierlist API running");
    }

    @RequestMapping("addWebsite")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity addWebsite(@RequestHeader(value = "websiteName") String websiteName, @RequestHeader(value = "websiteDesc") String webSiteDesc){
        websiteRepository.insert(new WebsiteInfo(websiteName, webSiteDesc, 0));
        return ResponseEntity.ok("Successfully added entry to DB");
    }

    @RequestMapping("getAllWebsites")
    @ResponseStatus(HttpStatus.OK)
    public List<WebsiteInfo> getAllWebsites() {
        return websiteRepository.findAll();
    }

    @RequestMapping("vote")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity vote (@RequestHeader (value = "websiteName") String websiteName){
        WebsiteInfo websiteInfo = websiteRepository.findFirstByWebsiteName(websiteName);

        if (websiteInfo != null){
            int count = websiteInfo.getVoteCount() + 1;
            customWebsiteRepo.updateWebsiteInfo(websiteName, count);
            return ResponseEntity.ok("Successfully added to count");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
