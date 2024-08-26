package org.example.Service;

import org.example.Entity.Address;
import org.example.Entity.Student;
import org.example.Entity.Teacher;
import org.example.Reponce.ApiResponse;
import org.example.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public ResponseEntity<ApiResponse> saveTeacher(Teacher teacher)
    {
        // Persist addresses separately if needed or ensure they are attached to the student
        for (Address address : teacher.getAddresses()) {
            address.setTeacher(teacher); // Ensure the bidirectional relationship is set
        }

        teacherRepository.save(teacher);
        ApiResponse response = new ApiResponse("Success", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public List<Teacher> getAllTeacher()
    {
        return teacherRepository.findAll();
    }

    public ResponseEntity<ApiResponse> deleteTeacherById(int id)
    {
        teacherRepository.deleteById(id);
        ApiResponse response = new ApiResponse("Success", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse> updateTeacher(Teacher teacher, int id)
    {
        Teacher teacherDetails =  teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id " + id));
        teacherDetails.setTeacherName(teacher.getTeacherName());
        teacherDetails.setTeacherPhoneNumber(teacher.getTeacherPhoneNumber());
        teacherRepository.save(teacherDetails);
        ApiResponse response = new ApiResponse("Success", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
