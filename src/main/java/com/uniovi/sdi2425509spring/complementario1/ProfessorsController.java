package com.uniovi.sdi2425509spring.complementario1;

import com.uniovi.sdi2425509spring.entities.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfessorsController {
    @Autowired
    private ProfessorsService professorsService;
    @RequestMapping("/professor/list")
    public String getList(Model model) {
        model.addAttribute("professorList", professorsService.getTeachers());
        return "professor/list";
    }
    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute Professor professor) {
        professorsService.addTeacher(professor);
        return "redirect:/professor/list";
    }
    @RequestMapping(value = "/professor/add")
    public String getTeacher() {
        return "professor/add";
    }
    @RequestMapping("/professor/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("professor", professorsService.getTeacher(id));
        return "professor/details";
    }
    @RequestMapping("/professor/delete/{id}")
    public String deleteteacher(@PathVariable Long id) {
        professorsService.deleteTeacher(id);
        return "redirect:/professor/list";
    }
}