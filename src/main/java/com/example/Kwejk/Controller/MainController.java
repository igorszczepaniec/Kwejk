package com.example.Kwejk.Controller;


import com.example.Kwejk.Model.Category;
import com.example.Kwejk.Model.File;
import com.example.Kwejk.Repository.CategoryRepository;
import com.example.Kwejk.Repository.FileRepository;
import com.example.Kwejk.Repository.TestRepository;
import com.example.Kwejk.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    private String home(@PathVariable(required = false) Integer pageId, ModelMap map, Authentication authentication) {


        if (pageId == null)
            pageId = 0;
        map.put("test", fileRepository.findAll(PageRequest.of(pageId, 4, Sort.by(Sort.Direction.DESC, "localDate")).first()));
        map.put("categories", categoryRepository.findAll());


// https://stackoverflow.com/questions/12371770/spring-mvc-checking-if-user-is-already-logged-in-via-spring-security
        if (SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                !(SecurityContextHolder.getContext().getAuthentication()
                        instanceof AnonymousAuthenticationToken)) {
            String email = authentication.getName();
            map.put("user", userRepository.findByEmail(email));
            return "logged";
        } else {
            return "home";
        }


    }

    // todo - implement those two as one, i know this is a bad practice but for some reason i cant manage to make it work as a single method

    @GetMapping("/{pageId}")
    private String test(@PathVariable int pageId, ModelMap map, Authentication authentication) {
        map.put("test", fileRepository.findAll(PageRequest.of(pageId, 4)));
        map.put("categories", categoryRepository.findAll());
        if (SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                !(SecurityContextHolder.getContext().getAuthentication()
                        instanceof AnonymousAuthenticationToken)) {
            String email = authentication.getName();
            map.put("user", userRepository.findByEmail(email));
            return "logged";
        } else {
            return "home";
        }
    }
}

