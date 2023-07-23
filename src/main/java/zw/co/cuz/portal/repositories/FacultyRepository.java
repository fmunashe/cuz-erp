package zw.co.cuz.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.cuz.portal.models.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
