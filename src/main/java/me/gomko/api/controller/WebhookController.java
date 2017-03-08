package me.gomko.api.controller;

import me.gomko.api.controller.model.response.SkhuBotResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Manki Kim on 2017-03-08
 * email : aj1155@naver.com.
 */
@RestController
@RequestMapping(value = "/api/v1/webhook")
public class WebhookController {

    @GetMapping("")
    public SkhuBotResponse webhook(){
        return new SkhuBotResponse(SkhuBotResponse.OK);
    }

}
