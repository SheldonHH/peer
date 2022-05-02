package com.example.demo.api;

import com.example.demo.dao.ServerDataAccessService;
import com.example.demo.model.*;
import com.example.demo.p4p.user.UserVector2;
import com.example.demo.service.PeerService;
import com.example.demo.service.ServerService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("api/v1/server")
@RestController
public class ServerController {
    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @PostMapping("/addGaussParamsSampleRange")
    public void addGaussParamsSampleRange(@Valid @NonNull @RequestBody GaussParamsandSampleRange gaussParamsSampleRange){
        serverService.insertGaussParamsandSampleRange(gaussParamsSampleRange);
    }

    @PostMapping("/uiandproof")
    public void addUiandProof(@Valid @NonNull @RequestBody UiandProof uiandProof){
        serverService.insertUiandProof(uiandProof);
    }

    @PostMapping("/samplesumcount")
    public void sendRquestSampleSumCount (@Valid @NonNull @RequestBody SampleSumandCount sampleSumandCount){
        serverService.sendRquestSampleSumCount(sampleSumandCount);
    }

    @PostMapping("/addvsum") // peerID
    public void addVSum(@Valid @NonNull @RequestBody VSum vSum) {
        serverService.insertVSum(vSum);
    }

}
