package org.example.Service;

import org.example.DTO.StudentDto;
import org.example.Entity.Address;
import org.example.Entity.Student;
import org.example.Entity.Subject;
import org.example.Reponce.ApiResponse;
import org.example.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public ResponseEntity<ApiResponse> saveSubjects(Subject subject)
    {
         subjectRepository.save(subject);
        ApiResponse response = new ApiResponse("Success", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public List<Subject> getAllSubjects()
    {
        return subjectRepository.findAll();
    }
    public ResponseEntity<ApiResponse> deleteSubjectById(int id)
    {
        subjectRepository.deleteById(id);
        ApiResponse response = new ApiResponse("Success", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse> updateSubject(Subject subject, int id)
    {
        Subject subjectDetails =  subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id " + id));
        subjectDetails.setSubjectName(subject.getSubjectName());
        subjectRepository.save(subjectDetails);
        ApiResponse response = new ApiResponse("Success", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
