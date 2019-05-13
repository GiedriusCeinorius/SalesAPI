package com.gce.salesapi.service;

import com.gce.salesapi.model.Item;

import java.util.List;

public interface CommentToItemSevice {

    Item addCommentsToItem(String id, List<String> comments);
}
