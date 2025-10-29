package ru.tpu.accommodationindormitories.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tpu.accommodationindormitories.model.University;
import ru.tpu.accommodationindormitories.repository.UniversityRepository;
import ru.tpu.accommodationindormitories.service.interfaces.UniversityService;


import java.util.List;

@Service
@AllArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    @Override
    public List<University> findAllUniversities() {
        return universityRepository.findAll();
    }
}
