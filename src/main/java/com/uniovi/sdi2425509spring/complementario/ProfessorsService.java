package com.uniovi.sdi2425509spring.complementario;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class ProfessorsService {
    private List<Professor> professorsList = new LinkedList<>();
    @PostConstruct
    public void init() {
        professorsList.add(new Professor(1L, "123456789A", "Cristiano", "Ronaldo", "Matemáticas"));
        professorsList.add(new Professor(2L, "987654321B", "Leo", "Messi", "SDI"));
    }
    public List<Professor> getTeachers() {
        return professorsList;
    }
    public Professor getTeacher(Long id) {
        return professorsList.stream()
                .filter(Teacher -> Teacher.getId().equals(id)).findFirst().get();
    }
    public void addTeacher(Professor Teacher) {
        // Si en Id es null le asignamos el ultimo + 1 de la lista
        if (Teacher.getId() == null) {
            Teacher.setId(professorsList.isEmpty() ? 1L : professorsList.get(professorsList.size() - 1).getId() + 1);
        }
        professorsList.add(Teacher);
    }
    public void deleteTeacher(Long id) {
        professorsList.removeIf(Teacher -> Teacher.getId().equals(id));
    }
}