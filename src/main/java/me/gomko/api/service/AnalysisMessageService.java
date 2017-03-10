package me.gomko.api.service;

import me.gomko.api.domain.Manual;
import me.gomko.api.repository.ManualRepository;
import me.gomko.api.util.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Manki Kim on 2017-03-10.
 */
@Service
public class AnalysisMessageService {

    @Autowired
    private ManualRepository manualRepository;

    public String analysisMessage(String msg){
        Optional<Manual> manualOptional = Optional.ofNullable(this.manualRepository.findByMessage(msg));
        if(manualOptional.isPresent()) {
            Manual manual = manualOptional.get();
            switch (manual.getManualType()){
                case TEXT:
                    return manual.getMessage();
                case IMAGE:
                    break;
                case VIDEO:
                    break;
            }
        }
        return MessageType.NOMANUAL.getMessage();
    }
}
