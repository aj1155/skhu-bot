package me.gomko.service;

import lombok.extern.slf4j.Slf4j;
import me.gomko.api.service.AnalysisMessageService;
import me.gomko.api.util.ManualType;
import me.gomko.api.util.MessageType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Manki Kim on 2017-03-16.
 * email : aj1155@naver.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class AnalysisMessageServiceTest {

    @Autowired
    private AnalysisMessageService analysisMessageService;

    @Test
    public void messageTest(){
        String reverse = this.analysisMessageService.analysisMessage("안녕 성공아");
        assertThat(reverse).isEqualTo(MessageType.NOMANUAL.getMessage());
    }

    @Test
    public void messageExistTest(){
        String reverse = this.analysisMessageService.analysisMessage("도움말");
        assertThat(reverse).isNotBlank();
    }

    @Test
    public void messageType(){
        ManualType type = this.analysisMessageService.analysisType("aaa");
        assertThat(type).isEqualTo(ManualType.NOTYPE);
    }



}
