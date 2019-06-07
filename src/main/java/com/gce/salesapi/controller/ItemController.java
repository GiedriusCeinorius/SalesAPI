package com.gce.salesapi.controller;

import com.gce.salesapi.model.Item;
import com.gce.salesapi.service.CommentToItemSevice;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RepositoryRestController
@RequestMapping("/items")
public class ItemController {

    private final CommentToItemSevice commentToItemSevice;

    public ItemController(CommentToItemSevice commentToItemSevice) {
        this.commentToItemSevice = commentToItemSevice;
    }

    @PostMapping("/{id}/addComments")
    public ResponseEntity<PersistentEntityResource> addCommentsToItem(@PathVariable("id") String id,
                                                                      @RequestBody List<String> comments,
                                                                      PersistentEntityResourceAssembler assembler) {
        Item item = commentToItemSevice.addCommentsToItem(id, comments);
        return ResponseEntity.ok(assembler.toResource(item));
    }
}







