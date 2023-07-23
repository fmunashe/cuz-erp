package zw.co.cuz.portal.controllers.api.programmes;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.cuz.portal.exceptions.RecordNotFoundException;
import zw.co.cuz.portal.models.Programme;
import zw.co.cuz.portal.services.programmes.ProgrammeService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/programmes")
public class ProgrammeControllerApi {

    private final ProgrammeService programmeService;

    public ProgrammeControllerApi(ProgrammeService programmeService) {
        this.programmeService = programmeService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Programme>> getAllProgrammes(){
        List<Programme> programmeList = programmeService.findAll();
        return  new ResponseEntity<List<Programme>>(programmeList,new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/createProgramme")
    public ResponseEntity<Programme> createProgramme(@RequestBody Programme programme){
        Programme programme1 = programmeService.create(programme);
        return new ResponseEntity<Programme>(programme1,new HttpHeaders(),HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateProgramme")
    public ResponseEntity<Programme> updateProgramme(@RequestBody Programme programme){
        Programme programme1 =programmeService.update(programme);
        return new ResponseEntity<Programme>(programme1, new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/getProgramme/{programmeId}")
    public ResponseEntity<Programme> getProgramme(@PathVariable(value = "programmeId") String programmeId){
        Programme programme = programmeService.findById(Long.valueOf(programmeId)).orElseThrow(()->new RecordNotFoundException("Programme with the provided Id not found"));
        return new ResponseEntity<Programme>(programme,new HttpHeaders(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/removeProgramme/{programmeId}")
    public String removeProgramme(@PathVariable(value = "programmeId") String programmeId){
      programmeService.delete(Long.valueOf(programmeId));
      return "Programme successfully removed";
    }
}
