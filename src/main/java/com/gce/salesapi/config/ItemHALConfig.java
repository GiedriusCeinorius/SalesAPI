package com.gce.salesapi.config;

import com.gce.salesapi.model.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

@Configuration
public class ItemHALConfig {

    @Value("${server.port}")
    private String port;

    @Bean
    public ResourceProcessor<Resource<Item>> itemProcessor() {
        return new ResourceProcessor<Resource<Item>>() {
            @Override
            public Resource<Item> process(Resource<Item> itemResource) {
                itemResource.add(new Link("http://localhost:" + port + "/sales/items/" + itemResource.getContent().getId() + "/addComments"));
                return itemResource;
            }
        };
    }
}
