package app.multimodule.moduleapi.controller;

import app.multimodule.modulecommon.enums.CodeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping
    public String helloMultimodule() {
        return "Hello from multimodule";
    }
    @GetMapping("/enums")
    public String getEnums() {
        return Arrays.toString(CodeEnum.values());
    }
}
