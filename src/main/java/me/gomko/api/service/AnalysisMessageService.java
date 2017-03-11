package me.gomko.api.service;

import me.gomko.api.domain.Manual;
import me.gomko.api.repository.ManualRepository;
import me.gomko.api.util.ManualType;
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
        Optional<Manual> manualOptional = Optional.ofNullable(this.manualRepository.findByTitle(msg));
        if(manualOptional.isPresent()) {
            return manualOptional.get().getMessage();
        }
        return MessageType.NOMANUAL.getMessage();
    }

    public ManualType analysisType(String msg){
        Optional<Manual> manualOptional = Optional.ofNullable(this.manualRepository.findByTitle(msg));
        return manualOptional.get().getManualType();
    }
}
