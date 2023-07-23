package zw.co.cuz.portal.services.faculty;

import zw.co.cuz.portal.commons.AppService;
import zw.co.cuz.portal.models.Faculty;

import java.util.List;


public interface FacultyService extends AppService<Faculty> {

    List<Faculty> findAll(int page, int size);
}
