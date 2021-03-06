package com.UGrow.controllers;

import com.UGrow.models.User;
import com.UGrow.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class HomeController extends AbstractController {

    @RequestMapping(value = "/index")
    public String index(Model model, HttpServletRequest request) {

        model.addAttribute("title", "U-Grow");
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        return "index";
    }
    @RequestMapping(value= "/home")
    public String displayHome(Model model, HttpServletRequest request) {

        User user = getUserFromSession(request.getSession());
        String username =  user.getUsername();
        model.addAttribute("username", username);
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        return "home";
    }

}
