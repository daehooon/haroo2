package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.Feed;

public interface FeedService {

  List<Feed> list() throws Exception;

  Feed get(int no) throws Exception;
}
