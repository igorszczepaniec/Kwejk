package com.example.Kwejk.Repository;


import com.example.Kwejk.Model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Integer> {
    List<Comment>findAllByFileId(Integer id);
}
