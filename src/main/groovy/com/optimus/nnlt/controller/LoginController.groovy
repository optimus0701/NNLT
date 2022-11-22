package com.optimus.nnlt.controller;

import com.optimus.nnlt.dto.UserDTO;
import com.optimus.nnlt.global.GlobalData;
import com.optimus.nnlt.model.Role;
import com.optimus.nnlt.model.User;
import com.optimus.nnlt.repository.RoleRepository;
import com.optimus.nnlt.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


@Controller
class LoginController {
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/login")
    String login(){
        GlobalData.cart.clear();
        return "login";
    }//page login

    @RequestMapping(value = "/forgotpassword", method = [RequestMethod.GET, RequestMethod.POST])
    String forgotPass(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "forgotpassword";
    }

    @GetMapping(value = "/register", produces = "text/html")
    String registerGet(Model model){
        return "register";
    }

    @PostMapping(value = "/register")
    String registerPost(@ModelAttribute User userModel, HttpServletRequest request) throws ServletException {
        String password = userModel.getPassword();
        userModel.setPassword(bCryptPasswordEncoder.encode(password));

        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(1).get());
        roles.add(roleRepository.findById(2).get());
        userModel.setRoles(roles);
        userRepository.save(userModel);

        request.login(userModel.getEmail(), password);
        return "redirect:/";
    }
}
