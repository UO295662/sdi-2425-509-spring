package com.uniovi.sdi2425509spring.complementario;

import com.uniovi.sdi2425509spring.entities.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String getTeacher(Model model) {
        model.addAttribute("usersList", professorsService.getTeachers());
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
    @RequestMapping(value = "/professor/edit/{id}", method = RequestMethod.POST)
    public String setEdit(Professor teacher, BindingResult result, @PathVariable Long id, Model model) {
        Professor originalTeacher = professorsService.getTeacher(id);
        // modificar solo score y description
        originalTeacher.setNombre(teacher.getNombre());
        professorsService.addTeacher(teacher);
        return "redirect:/professor/details/" + id;
    }

    @RequestMapping(value = "/professor/edit/{teacher}")
    public String getEdit(Model model, @PathVariable Professor teacher) {
        model.addAttribute("teacher", teacher);
        return "professor/edit";
    }
}