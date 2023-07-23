package zw.co.cuz.portal.services.student.impl;

import org.springframework.stereotype.Service;
import zw.co.cuz.portal.exceptions.RecordNotFoundException;
import zw.co.cuz.portal.models.Student;
import zw.co.cuz.portal.repositories.StudentRepository;
import zw.co.cuz.portal.services.student.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        Student currentStudent = studentRepository
                .findById(student.getId())
                .orElseThrow(()-> new RecordNotFoundException("Sorry updating a non existent record is  not allowed"));
        currentStudent.setName(student.getName());
        currentStudent.setSurname(student.getSurname());
        currentStudent.setEmail(student.getEmail());
        currentStudent.setPhone(student.getPhone());
        currentStudent.setDob(student.getDob());
        currentStudent.setIdNumber(student.getIdNumber());
        currentStudent.setAddress(student.getAddress());
        return studentRepository.save(currentStudent);
    }

    @Override
    public void delete(Long Id) {
        studentRepository.deleteById(Id);
    }

    @Override
    public Optional<Student> findById(Long Id) {
        return studentRepository.findById(Id);
    }
}
