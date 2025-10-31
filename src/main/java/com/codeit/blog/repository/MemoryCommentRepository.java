package com.codeit.blog.repository;

import com.codeit.blog.entity.Comment;
import com.codeit.blog.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryCommentRepository implements CommentRepository {

    private final Map<Long, Post> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1L);


    @Override
    public Optional<Comment> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Comment save(Comment comment) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Comment> findByPostId(Long postId) {
        return List.of();
    }
}
