package com.SpringWithDB.SpringWithDB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringWithDB.SpringWithDB.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
