package zw.co.cuz.portal.controllers.web.faculty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zw.co.cuz.portal.services.faculty.FacultyService;

@Controller
@RequestMapping(value = "/web/faculty")
public class FacultyWebController {
    private final FacultyService facultyService;

    public FacultyWebController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping(value = "/getAll")
    public ModelAndView getAllFaculties() {
        ModelAndView mv = new ModelAndView("faculty/index");
        mv.addObject("faculties", facultyService.findAll());
        return mv;
    }
}
