package ru.tpu.accommodationindormitories.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tpu.accommodationindormitories.model.Group;
import ru.tpu.accommodationindormitories.service.interfaces.GroupService;

import java.util.List;

@RestController
@RequestMapping("Groups")
@AllArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping()
    public List<Group> getGroups() {
        return groupService.findAllGroups();
    }
}
