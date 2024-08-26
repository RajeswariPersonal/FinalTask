package org.example.Controller;

import org.example.Entity.Student;
import org.example.Entity.Teacher;
import org.example.Reponce.ApiResponse;
import org.example.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping
    public ResponseEntity<ApiResponse> saveTecher(@RequestBody Teacher teacher)
    {
        return teacherService.saveTeacher(teacher);

    }

    @GetMapping
    public List<Teacher> getAllTeacher()
    {
        return teacherService.getAllTeacher();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateTeacher(@PathVariable int id, @RequestBody Teacher teacher)
    {
        return teacherService.updateTeacher(teacher, id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTeacherById(@PathVariable int id) {
        return teacherService.deleteTeacherById(id);
    }
}

