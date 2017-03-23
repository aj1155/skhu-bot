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
        List<Manual> manuals = tokenMsg(msg);
        Optional<List<Manual>> manualOptional = Optional.ofNullable(manuals);
        if(manualOptional.isPresent() && manualOptional.get().size()>0) {
            return manualOptional.get().get(0).getMessage();
        }
        return MessageType.NOMANUAL.getMessage();
    }

    public ManualType analysisType(String msg){
        if(tokenCount(msg)==1){
            return ManualType.AMBIGUOUS;
        }
        Optional<List<Manual>> manualOptional = Optional.ofNullable(tokenMsg(msg));
        if(manualOptional.isPresent() && manualOptional.get().size()>0){
            return manualOptional.get().get(0).getManualType();
        }else return ManualType.NOTYPE;
    }

    private List<Manual> tokenMsg(String msg){
        List<String> lists = this.koreanAnalysisService.tokenizeKoreanNoun(msg);
        if(lists.size()>0){
            String title = lists.get(0);
            lists.remove(0);
            List<Manual> manuals = this.manualRepository.readByTitleAndMessage(title,lists);
            return manuals;
        }
        return null;
    }
    private int tokenCount(String msg){
       List<String> lists = this.koreanAnalysisService.tokenizeKoreanNoun(msg);
       return lists.size();
    }
}
