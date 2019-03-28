package com.insert.table.db.collegeRepository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.insert.table.db.college.College;

@Repository
@Transactional
public interface CollegeRepository extends JpaRepository<College, Long> 
{
}
