package zw.co.cuz.portal.services.faculty.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zw.co.cuz.portal.exceptions.RecordNotFoundException;
import zw.co.cuz.portal.models.Faculty;
import zw.co.cuz.portal.repositories.FacultyRepository;
import zw.co.cuz.portal.services.faculty.FacultyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {


    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public List<Faculty> findAll(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Faculty> pagedResult = facultyRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Faculty>();
        }
    }

    @Override
    public Faculty create(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty update(Faculty faculty) {
        Faculty faculty1 = facultyRepository.findById(faculty.getId()).orElseThrow(() -> new RecordNotFoundException("Faculty you are trying to update does not exist."));
        return facultyRepository.save(mapFacultyFields(faculty1, faculty));
    }

    private Faculty mapFacultyFields(Faculty faculty1, Faculty faculty) {
        faculty1.setName(faculty.getName());
        faculty1.setProgrammeList(faculty.getProgrammeList());
        return faculty1;
    }


    @Override
    public void delete(Long Id) {
        facultyRepository.deleteById(Id);
    }

    @Override
    public Optional<Faculty> findById(Long Id) {
        return facultyRepository.findById(Id);
    }
}
