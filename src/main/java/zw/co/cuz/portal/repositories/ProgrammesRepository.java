package zw.co.cuz.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.cuz.portal.models.Programme;

public interface ProgrammesRepository extends JpaRepository<Programme,Long> {
}
