package zw.co.cuz.portal.controllers.web.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zw.co.cuz.portal.services.student.StudentService;

@Controller
@RequestMapping(value = "/web/student")
public class StudentWebController {
    private final StudentService studentService;

    public StudentWebController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/getAll")
    public ModelAndView getStudents(){
        ModelAndView mv = new ModelAndView("students/index");
        mv.addObject("students",studentService.findAll());
        return mv;
    }
}
