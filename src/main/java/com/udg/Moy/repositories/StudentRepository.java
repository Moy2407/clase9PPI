package com.udg.Moy.repositories;

import com.udg.Moy.models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.ArrayList;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Long> {
    public Optional<ArrayList<StudentModel>> findStudentModelByCode(String code);

    public Optional<ArrayList<StudentModel>> findStudentModelByName(String name);
}
