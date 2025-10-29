package ru.tpu.accommodationindormitories.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tpu.accommodationindormitories.model.Faculty;
import ru.tpu.accommodationindormitories.repository.FacultyRepository;
import ru.tpu.accommodationindormitories.service.interfaces.FacultyService;


import java.util.List;

@Service
@AllArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    @Override
    public List<Faculty> findAllFaculties() {
        return facultyRepository.findAll();
    }
}
