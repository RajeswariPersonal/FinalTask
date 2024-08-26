package org.example.Controller;

import org.example.Entity.Subject;
import org.example.Reponce.ApiResponse;
import org.example.Service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    Logger logger = LoggerFactory.getLogger(SubjectController.class);
    @Autowired
    SubjectService subjectService;

    @PostMapping
    public ResponseEntity<ApiResponse> saveSubject(@RequestBody Subject subject)
    {
        return subjectService.saveSubjects(subject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateSubject(@PathVariable int id, @RequestBody Subject subject)
    {
        return subjectService.updateSubject(subject, id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteSubjectById(@PathVariable int id) {
        return subjectService.deleteSubjectById(id);
    }

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects()
    {
        logger.error("Starting aaaaa");
        logger.trace("trace bbbbbbbbbb");
        List<Subject> subject =  subjectService.getAllSubjects();
        return ResponseEntity.ok(subject);
    }
}
