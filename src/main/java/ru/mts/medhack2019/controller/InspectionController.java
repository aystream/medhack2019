package ru.mts.medhack2019.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mts.medhack2019.dto.UserDTO;
import ru.mts.medhack2019.model.Inspection;
import ru.mts.medhack2019.service.InspectionService;
import ru.mts.medhack2019.service.UserService;
import ru.mts.medhack2019.shared.mapper.UserMapper;

import java.util.List;

@RestController
@RequestMapping("/api/inspection")
public class InspectionController {
    private InspectionService
            inspectionService;

    @Autowired
    public InspectionController(InspectionService inspectionService) {
        this.inspectionService = inspectionService;
    }

    @PostMapping
    public Inspection create(@RequestBody Inspection inspection) {
        return inspectionService.create(inspection);
    }

}
