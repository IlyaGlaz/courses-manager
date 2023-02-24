package org.team24.coursesmanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Тестовый контроллер")
public class TestController {

    @ApiOperation(value = "Краткое описание эндпоинта",
            notes = "Более полное описаение")
    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
