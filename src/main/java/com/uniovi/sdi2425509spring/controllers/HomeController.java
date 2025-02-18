package com.uniovi.sdi2425509spring.controllers;

import com.uniovi.sdi2425509spring.entities.Mark;
import com.uniovi.sdi2425509spring.entities.User;
import com.uniovi.sdi2425509spring.services.MarksService;
import com.uniovi.sdi2425509spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class HomeController {
    @Autowired //Inyectar el servicio
    private final MarksService marksService;
    private final UsersService usersService;
    public HomeController(MarksService marksService, UsersService usersService) {
        this.marksService = marksService;
        this.usersService = usersService;
    }
    @RequestMapping("/")
    public String getListHome(Model model, Pageable pageable, Principal principal,
                              @RequestParam(value = "searchText", required = false) String searchText) {
        String dni = principal.getName();
        User user = usersService.getUserByDni(dni);
        Page<Mark> marks;
        if(searchText != null && !searchText.isEmpty()){
            marks = marksService.searchMarksByDescriptionAndNameForUser(pageable,searchText,user);
        }else{
            marks = marksService.getMarksForUser(pageable,user);
        }
        model.addAttribute("markList", marks.getContent());
        model.addAttribute("page", marks);
        return "index";
    }
}