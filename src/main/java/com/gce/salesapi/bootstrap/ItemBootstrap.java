package com.gce.salesapi.bootstrap;

import com.gce.salesapi.model.Item;
import com.gce.salesapi.model.Location;
import com.gce.salesapi.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ItemBootstrap implements CommandLineRunner {

    private final ItemRepository itemRepository;

    public ItemBootstrap(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) {

        List<Item> items = new ArrayList<>();

        Location pumaShoesLocation = Location.builder()
                .country("Lithuania")
                .city("Kėdainiai")
                .gpsCoorinates(Arrays.asList(25.5665, 25.3644))
                .build();

        Item pumaShoes = Item.builder()
                .id("5cd567afe329ed7ec4b8a43e")
                .title("PumaShoes")
                .description("Various brand new shoes")
                .comments(Arrays.asList("very, good", "it has been better", "the best"))
                .location(pumaShoesLocation)
                .price(23.00)
                .stock(56)
                .build();

        Location addidasShoesLocation = Location.builder()
                .country("Lithuania")
                .city("Kaunas")
                .gpsCoorinates(Arrays.asList(25.5569, 24.3245))
                .build();

        Item addidasShoes = Item.builder()
                .id("5cd56801e329ed505c88fb64")
                .title("AddidasShoes")
                .description("Various used addidas shoes")
                .comments(Arrays.asList("small sizes", "depends on the price, but goot for all"))
                .location(addidasShoesLocation)
                .price(50.00)
                .stock(56)
                .build();

        items.add(pumaShoes);
        items.add(addidasShoes);
        itemRepository.saveAll(items);

    }
}
