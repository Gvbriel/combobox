package com.gabriel.web.controller;

import com.gabriel.web.OperationType;
import com.gabriel.web.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("localhost:8080") //ten fragment nalezy zmienic w zaleznosci od miejsca wdrozenia aplikacji
@RestController
@RequestMapping("/api/v1/data")
public class BaseController {

    private final BaseService baseService;

    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    @GetMapping
    public List<String> getColumnsNames() {
        return baseService.getColumnsNames();
    }

    @GetMapping(path = "/{type}/{columnName}")
    public List findColumns(
            @PathVariable String columnName,
            @PathVariable OperationType type
    ) {
        return baseService.findColumns(columnName, type);
    }
}
