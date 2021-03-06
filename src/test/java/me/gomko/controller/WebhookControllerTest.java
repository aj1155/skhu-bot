package me.gomko.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Manki kim on 2017-03-16.
 * email : aj1155@naver.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class WebhookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${fb.accesstoken}")
    private String token;

    @Test
    public void testWebhook() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/webhook")
                .accept(MediaType.APPLICATION_JSON)
                 .param("hub.verify_token",token)
                 .param("hub.challenge","asd"))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
        log.debug("{}", result.getResponse().getContentAsString());

    }
}
