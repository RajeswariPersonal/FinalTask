package org.example.Repository;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import org.example.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
