package com.uniovi.sdi2425509spring.complementario1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorsController {
    @Autowired
    private ProfessorsService professorsService;
    @RequestMapping("/professor/list")
    public String getList() {
        return professorsService.getTeachers().toString();
    }
    @RequestMapping(value = "/professor/add/{dni}/{nombre}/{apellidos}/{categoria}", method = RequestMethod.GET)
    public String setTeacher(@PathVariable String dni,
                             @PathVariable String nombre,
                             @PathVariable String apellidos,
                             @PathVariable String categoria) {
        Professor professor = new Professor();
        professor.setDni(dni);
        professor.setNombre(nombre);
        professor.setApellidos(apellidos);
        professor.setCategoria(categoria);

        professorsService.addTeacher(professor);
        return "Professor added:"+professor.toString();
    }
    @RequestMapping("/professor/details/{id}")
    public String getDetail(@PathVariable Long id) {
        return professorsService.getTeacher(id).toString();
    }
    @RequestMapping("/professor/delete/{id}")
    public String deleteteacher(@PathVariable Long id) {
        professorsService.deleteTeacher(id);
        return "Teacher deleted";
    }
}
