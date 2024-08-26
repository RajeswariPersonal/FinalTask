package org.example.Controller;

import org.example.DTO.StudentDto;
import org.example.Entity.Student;
import org.example.Reponce.ApiResponse;
import org.example.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<ApiResponse> saveStudent(@RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }
    @GetMapping("/withmappeddetails")
    public ResponseEntity<List<StudentDto>> getAllStudents()
    {
        List<StudentDto> students =  studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateStudent(@PathVariable int id, @RequestBody Student student)
    {
        return studentService.updateStudent(student, id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteStudentById(@PathVariable int id) {
        return studentService.deleteStudentById(id);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudentsOnly()
    {
        List<Student> students =  studentService.getAllStudentsOnly();
        return ResponseEntity.ok(students);
    }

    @PostMapping("/{studentId}/teacher/{teacherId}")
    public ResponseEntity<ApiResponse> assignStudentWithTeacher(
            @PathVariable int studentId,
            @PathVariable int teacherId
    ){
        return studentService.assignStudentWithTeacher(studentId, teacherId);
    }


}
