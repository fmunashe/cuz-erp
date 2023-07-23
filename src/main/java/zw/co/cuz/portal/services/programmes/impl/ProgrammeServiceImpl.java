package zw.co.cuz.portal.services.programmes.impl;

import org.springframework.stereotype.Service;
import zw.co.cuz.portal.exceptions.RecordNotFoundException;
import zw.co.cuz.portal.models.Programme;
import zw.co.cuz.portal.repositories.ProgrammesRepository;
import zw.co.cuz.portal.services.programmes.ProgrammeService;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammeServiceImpl implements ProgrammeService {

    private final ProgrammesRepository programmesRepository;

    public ProgrammeServiceImpl(ProgrammesRepository programmesRepository) {
        this.programmesRepository = programmesRepository;
    }

    @Override
    public List<Programme> findAll() {
        return programmesRepository.findAll();
    }

    @Override
    public Programme create(Programme programme) {
        return programmesRepository.save(programme);
    }

    @Override
    public Programme update(Programme programme) {
        Programme programme1 = programmesRepository
                .findById(programme.getId())
                .orElseThrow(() -> new RecordNotFoundException("Record to update not found"));
        programme1.setName(programme.getName());
        programme1.setFacultyId(programme.getFacultyId());
        return programmesRepository.save(programme1);
    }

    @Override
    public void delete(Long Id) {
        programmesRepository.deleteById(Id);
    }

    @Override
    public Optional<Programme> findById(Long Id) {
        return programmesRepository.findById(Id);
    }
}
