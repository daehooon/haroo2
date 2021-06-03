package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.domain.Post;

public interface FeedService {

  int add(Post post, List<AttachedFile> files, Feed feed) throws Exception;

  List<Feed> list(int no) throws Exception;

  Feed get(int no) throws Exception;

  Feed getCheck(int no) throws Exception;

  int update(Post post, List<AttachedFile> files) throws Exception;

  int getLike(int feedNo, int memberNo) throws Exception;

  int addLike(int feedNo, int memberNo) throws Exception;

  int deleteLike(int feedNo, int memberNo) throws Exception;
}