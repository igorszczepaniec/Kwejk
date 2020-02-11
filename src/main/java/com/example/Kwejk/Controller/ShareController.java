package com.example.Kwejk.Controller;


import com.example.Kwejk.Model.File;
import com.example.Kwejk.Repository.CategoryRepository;
import com.example.Kwejk.Repository.FileRepository;

import com.example.Kwejk.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShareController {

    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    public FileRepository fileRepository;
    @Autowired
    public UserRepository userRepository;





    @GetMapping("/share")
    private String share(@ModelAttribute File file, ModelMap map ){
        map.put("file",new File());
        map.put("category", categoryRepository.findAll());
        return "share";
    }

    @PostMapping("/shared")
    private String shared(@ModelAttribute File file,  Authentication authentication){
        String email = authentication.getName();
        file.setUser(userRepository.findByEmail(email));
        fileRepository.save (file);
        return "shared";
    }




}
