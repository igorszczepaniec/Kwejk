package com.example.Kwejk.Controller;

import com.example.Kwejk.Model.Category;
import com.example.Kwejk.Model.File;
import com.example.Kwejk.Repository.CategoryRepository;
import com.example.Kwejk.Repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class CategoryController {


    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    FileRepository fileRepository;

    @GetMapping("/categories")
    private String categories(ModelMap map, Category category){
        map.put("categories", categoryRepository.findAll());
        return "categories";
    }

    @GetMapping("/category/{categoryId}")
    private String category(@PathVariable Integer categoryId, ModelMap map){
        map.put("file",fileRepository.findByCategoryId(categoryId));
        return "category";
    }
}

