package com.gce.salesapi.service;

import com.gce.salesapi.model.Item;
import com.gce.salesapi.repository.ItemRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentToItemServiceImpl implements CommentToItemSevice {

    ItemRepository itemRepository;

    public CommentToItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addCommentsToItem(String id, List<String> comments) {
        Item item = itemRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        item.getComments().addAll(comments);
        itemRepository.save(item);
        return item;
    }
}
