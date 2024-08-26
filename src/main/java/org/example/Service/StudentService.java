package org.example.Service;

import org.example.DTO.StudentDto;
import org.example.Entity.Address;
import org.example.Entity.Student;
import org.example.Entity.Teacher;
import org.example.Reponce.ApiResponse;
import org.example.Repository.StudentRepository;
import org.example.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public ResponseEntity<ApiResponse> saveStudent(Student student)
    {
       // Persist addresses separately if needed or ensure they are attached to the student
        for (Address address : student.getAddresses()) {
        address.setStudent(student); // Ensure the bidirectional relationship is set
        }

        studentRepository.save(student);
        ApiResponse response = new ApiResponse("Success", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public List<StudentDto> getAllStudents()
    {
        return studentRepository.findAll().stream()
            .map(student -> new StudentDto(student.getId(), student.getStudentName()))
            .collect(Collectors.toList());
    }

    public List<Student> getAllStudentsOnly()
    {
        return studentRepository.findAll();
    }

    public ResponseEntity<ApiResponse> deleteStudentById(int id)
    {
        studentRepository.deleteById(id);
        ApiResponse response = new ApiResponse("Success", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse> updateStudent(Student student, int id)
    {
        Student studentDetails =  studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        studentDetails.setStudentName(student.getStudentName());
        studentRepository.save(studentDetails);
        ApiResponse response = new ApiResponse("Success", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse> assignStudentWithTeacher(int studentId, int teacherId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow();

        student.getTeacher().add(teacher);
        teacher.getStudent().add(student);

        studentRepository.save(student);
        teacherRepository.save(teacher);

        ApiResponse response = new ApiResponse("Success", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
