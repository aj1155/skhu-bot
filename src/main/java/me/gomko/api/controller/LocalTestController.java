package me.gomko.api.controller;

import me.gomko.api.service.AnalysisMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Manki Kim on 2017-03-10.
 */
@RestController
@RequestMapping("/api/v1/local")
public class LocalTestController {

    @Autowired
    private AnalysisMessageService analysisMessageService;

    @GetMapping("/{text}")
    public void test(@PathVariable String text){
        this.analysisMessageService.analysisMessage(text);
    }
}
