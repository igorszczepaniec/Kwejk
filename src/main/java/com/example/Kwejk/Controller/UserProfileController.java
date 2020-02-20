package com.example.Kwejk.Controller;



import com.example.Kwejk.Repository.FileRepository;
import com.example.Kwejk.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserProfileController {

    @Autowired
    FileRepository fileRepository;



/*    @GetMapping("/user/{email}")
    private String share(@PathVariable String email, ModelMap map, Authentication authentication){

     email = authentication.getName();
    map.put("userfiles", fileRepository.findAllByUserEmail(email));

        return "userfiles";
    }*/



    }



