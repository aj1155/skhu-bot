package me.gomko.api.service;

import me.gomko.api.domain.Manual;
import me.gomko.api.repository.ManualRepository;
import me.gomko.api.util.ManualType;
import me.gomko.api.util.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Manki Kim on 2017-03-10.
 */
@Service
public class AnalysisMessageService {

    @Autowired
    private ManualRepository manualRepository;

    @Autowired
    private KoreanAnalysisService koreanAnalysisService;

    public String analysisMessage(String msg){
        List<String> lists = this.koreanAnalysisService.tokenizeKoreanNoun(msg);
        String title = lists.get(0);
        lists.remove(0);
        List<Manual> manuals = this.manualRepository.readByTitleAndMessage(title,lists);
        Optional<List<Manual>> manualOptional = Optional.ofNullable(this.manualRepository.readByTitleAndMessage(title, lists));
        if(manualOptional.isPresent()) {
            return manualOptional.get().get(0).getMessage();
        }
        return MessageType.NOMANUAL.getMessage();
    }

    public ManualType analysisType(String msg){
        Optional<Manual> manualOptional = Optional.ofNullable(this.manualRepository.findByTitle(msg));
        if(manualOptional.isPresent()){
            return manualOptional.get().getManualType();
        }else return ManualType.NOTYPE;
    }
}
