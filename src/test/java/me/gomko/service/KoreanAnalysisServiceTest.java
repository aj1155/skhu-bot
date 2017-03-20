package me.gomko.service;

import lombok.extern.slf4j.Slf4j;
import me.gomko.api.controller.WebhookController;
import me.gomko.api.service.KoreanAnalysisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Manki Kim on 2017-03-20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class KoreanAnalysisServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(WebhookController.class);

    @Autowired
    private KoreanAnalysisService koreanAnalysisService;

    @Test
    public void tokenizeTextNoun(){
        List<String> result = this.koreanAnalysisService.tokenizeKoreanNoun("홍은지 교수님 이메일 알려줘");
        assertThat(result).isNotNull();
        LOG.info("tokenizeText",result.get(0));
    }
}
