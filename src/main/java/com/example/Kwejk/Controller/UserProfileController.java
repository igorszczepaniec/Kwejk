//package com.example.Kwejk.Controller;
//
//
//import com.example.Kwejk.Repository.FileRepository;
//import com.example.Kwejk.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class UserProfileController {
//
//    @Autowired
//    FileRepository fileRepository;
//    @Autowired
//    UserRepository userRepository;
//
//    @GetMapping("/userProfile/{userName}")
//    private String userProfile(ModelMap map, String userName){
//
//        userRepository.findByUserName(userName)
//        map.put("files", fileRepository.findAllByUserId())
//    }
//
//}
