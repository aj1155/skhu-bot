package me.gomko.api.controller;

import me.gomko.api.service.FBVerificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Manki Kim on 2017-03-08
 * email : aj1155@naver.com.
 */
@RestController
@RequestMapping(value = "/api/v1/webhook")
public class WebhookController {

    private static final Logger LOG = LoggerFactory.getLogger(WebhookController.class);

    @Autowired
    private FBVerificationService fbVerificationService;


    @GetMapping("")
    public String fbMessengerHook(@RequestParam(name = "hub.verify_token") final String verifyToken,
                                  @RequestParam(name = "hub.challenge") final String challenge) {
        LOG.info("Received Facebook verification request, hub.verify_token={}, hub.challenge={}", verifyToken, challenge);
        return fbVerificationService.verifyWebhook(verifyToken, challenge);
    }



}
