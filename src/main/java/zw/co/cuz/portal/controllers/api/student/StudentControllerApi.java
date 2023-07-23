package zw.co.cuz.portal.controllers.api.student;

import org.springframework.web.bind.annotation.*;
import zw.co.cuz.portal.models.Student;
import zw.co.cuz.portal.services.student.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentControllerApi {

    private final StudentService studentService;

    public StudentControllerApi(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/getAll")
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @GetMapping(value = "/getOne/{studentId}")
    public Optional<Student> getOneStudent(@PathVariable(value = "studentId") String studentId) {
        return studentService.findById(Long.valueOf(studentId));
    }


    @PostMapping(value = "/createOne")
    public Student createStudent(@RequestBody Student student) {
        return studentService.create(student);
    }

    @PutMapping(value = "/updateOne")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }



    @DeleteMapping(value = "/removeOne/{StudentId}")
    public String removeStudent(@PathVariable(value = "studentId") String studentId) {
        studentService.delete(Long.valueOf(studentId));
        return "Student Removed Successfully";
    }
}
