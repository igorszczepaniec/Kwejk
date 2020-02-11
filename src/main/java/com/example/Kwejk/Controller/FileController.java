package com.example.Kwejk.Controller;

import com.example.Kwejk.Model.Comment;
import com.example.Kwejk.Repository.CommentRepository;
import com.example.Kwejk.Repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FileController {


    @Autowired
    FileRepository fileRepository;
/*    @Autowired
    CommentRepository commentRepository;*/


    @GetMapping("/file/{title}")
    private String fileView(@ModelAttribute Comment comment, @PathVariable String title, ModelMap map) {
        map.put("file", fileRepository.findByTitle(title));
        Integer id = fileRepository.findByTitle(title).getId();
/*    AJAX    map.put("comments", commentRepository.findAllByFileId(id));
        map.put("comment",new Comment());
        map.put("saveComment",commentRepository.save(comment));*/
        return "view";
    }
}

