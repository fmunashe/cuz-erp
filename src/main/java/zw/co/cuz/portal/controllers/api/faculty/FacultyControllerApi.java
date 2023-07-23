package zw.co.cuz.portal.controllers.api.faculty;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.cuz.portal.exceptions.RecordNotFoundException;
import zw.co.cuz.portal.models.Faculty;
import zw.co.cuz.portal.services.faculty.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faculty")
public class FacultyControllerApi {
    private final FacultyService facultyService;

    public FacultyControllerApi(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Faculty>> getAllFaculties(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {

        List<Faculty> list = facultyService.findAll(pageNo, pageSize);

        return new ResponseEntity<List<Faculty>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/createFaculty")
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty faculty1 = facultyService.create(faculty);
        return new ResponseEntity<Faculty>(faculty1, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/getOne/{facultyId}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable(value = "facultyId") String facultyId) {
        Faculty faculty1 = facultyService.findById(Long.valueOf(facultyId)).orElseThrow(() -> new RecordNotFoundException("Faculty with Id " + facultyId + " could not be found"));
        return new ResponseEntity<Faculty>(faculty1, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(value = "/updateFaculty")
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        Faculty faculty1 = facultyService.update(faculty);
        return new ResponseEntity<Faculty>(faculty1, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/removeFaculty/{facultyId}")
    public String removeFaculty(@PathVariable(value = "facultyId") String facultyId) {
        facultyService.delete(Long.valueOf(facultyId));
        return "Faculty Successfully removed";
    }

}
