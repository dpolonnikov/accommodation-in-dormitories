package ru.tpu.accommodationindormitories.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tpu.accommodationindormitories.model.Dormitory;
import ru.tpu.accommodationindormitories.service.interfaces.DormitoryService;

import java.util.List;

@RestController
@RequestMapping("dormitories")
@AllArgsConstructor
public class DormitoryController {
    private final DormitoryService dormitoryService;

    @GetMapping()
    public List<Dormitory> getDormitories() {
        return dormitoryService.findAllDormitories();
    }
}
