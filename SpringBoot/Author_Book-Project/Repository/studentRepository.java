package com.insert.table.db.studentRepository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.insert.table.db.student.Student;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> 
{
}
