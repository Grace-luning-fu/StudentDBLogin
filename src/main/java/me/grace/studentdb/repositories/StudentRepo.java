package me.grace.studentdb.repositories;

import me.grace.studentdb.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Long> {
}
