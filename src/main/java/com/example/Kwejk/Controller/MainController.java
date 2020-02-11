package com.example.Kwejk.Controller;


import com.example.Kwejk.Model.Category;
import com.example.Kwejk.Model.File;
import com.example.Kwejk.Repository.CategoryRepository;
import com.example.Kwejk.Repository.FileRepository;
import com.example.Kwejk.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private FileRepository fileRepository;


    @GetMapping("/")
    private String home(@PathVariable(required = false) Integer page, ModelMap map) {
        if (page == null)
            page = 0;
        map.put("test", fileRepository.findAll(PageRequest.of(page, 4).first()));
        return "home";
    }


    @GetMapping("/{page}")
    private String test(@PathVariable int page, ModelMap map) {
        map.put("test", fileRepository.findAll(PageRequest.of(page, 4)));
        return "home";
    }
}

