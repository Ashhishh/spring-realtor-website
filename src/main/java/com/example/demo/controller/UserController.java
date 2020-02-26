
package com.example.demo.controller;



import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;

import com.example.demo.model.Pg;
import com.example.demo.model.User;
import com.example.demo.repository.PgRepository;
import com.example.demo.service.UserService;


@Controller
public class UserController {
	

    @Autowired
    private UserService userService;
//    private PgRepository pgRepository;
    
	    
	  @RequestMapping(value= "/index", method = RequestMethod.GET)
	  public String index(){
	      return "index";
	  }	
	  
	  @RequestMapping(value="/about", method = RequestMethod.GET)
	  public String about(){
	      return "about";
	  }
	  
	  
	  @RequestMapping(value="/portfolio", method = RequestMethod.GET)
	  public String portfolio(){
	      return "portfolio";
	  }
	  
	  @RequestMapping(value="/contact", method = RequestMethod.GET)
	  public String contact(){
	      return "contact";
	  }

    @RequestMapping(value={ "/login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }


    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public String registration(Model model){
    	System.out.println("hi");
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(@Valid User user, BindingResult bindingResult,Model model) {
        
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (!bindingResult.hasErrors()) {
            
            userService.saveUser(user);
            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", new User());
          

        }
        return "login";
    }

    @RequestMapping(value="/user/home", method = RequestMethod.GET)
    public String home(Model model){
     
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        model.addAttribute("adminMessage","Content Available Only for Users with Admin Role");
        
        return "home";
    }
    
    @RequestMapping(value = "/addPG", method = RequestMethod.GET)
    public String addPG(Model model) {
//    	System.out.println("hi");
    	Pg pg = new Pg();
        model.addAttribute("pg", pg);
        return "addPG";
    }
    
    @Autowired
    private PgRepository pgRepository;
    @RequestMapping(value = "/addPG", method = RequestMethod.POST)
    public String createNewPG(Pg pg, BindingResult bindingResult,Model model) { 
    	pgRepository.save(pg);
        return "redirect:index";
    }

}	