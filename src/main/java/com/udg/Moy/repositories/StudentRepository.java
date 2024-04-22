package com.udg.Moy.repositories;

import com.udg.Moy.models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Long> {
    public Optional<StudentModel> findByCode(String code);

    public Optional<StudentModel> findStudentModelByCode(String code);
}
