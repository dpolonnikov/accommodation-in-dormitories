package ru.tpu.accommodationindormitories.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tpu.accommodationindormitories.model.Dormitory;
import ru.tpu.accommodationindormitories.repository.DormitoryRepository;
import ru.tpu.accommodationindormitories.service.interfaces.DormitoryService;


import java.util.List;

@Service
@AllArgsConstructor
public class DormitoryServiceImpl implements DormitoryService {

    private final DormitoryRepository dormitoryRepository;
    @Override
    public List<Dormitory> findAllDormitories() {
        return dormitoryRepository.findAll();
    }
}
