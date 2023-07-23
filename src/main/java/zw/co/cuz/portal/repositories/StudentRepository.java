package zw.co.cuz.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.cuz.portal.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
