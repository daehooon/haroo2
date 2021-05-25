package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.domain.Post;

public interface FeedService {

  int add(Post post, Feed feed) throws Exception;

  List<Feed> list() throws Exception;

  Feed get(int no) throws Exception;
}