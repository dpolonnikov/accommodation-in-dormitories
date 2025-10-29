package ru.tpu.accommodationindormitories.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tpu.accommodationindormitories.model.Group;
import ru.tpu.accommodationindormitories.repository.GroupRepository;
import ru.tpu.accommodationindormitories.service.interfaces.GroupService;


import java.util.List;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    @Override
    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }
}
