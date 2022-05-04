package com.example.demo.api;

import com.example.demo.model.*;
import com.example.demo.p4p.user.UserVector2;
import com.example.demo.service.PeerService;
import com.example.demo.service.PersonService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/peer")
@RestController
public class PeerController {
    private final PeerService peerService;

    public PeerController(PeerService peerService) {
        this.peerService = peerService;
    }

    @PostMapping("/commencevi")
    public void commenceVi(@Valid @NonNull @RequestBody PersonCount personCount){
        peerService.commenceVi(personCount);
    }

    @PostMapping("/finishvi")
    public void finishVi(@Valid @NonNull @RequestBody PersonCount personCount){
        peerService.finishVi(personCount);
    }

    @PostMapping("/viandproof")
    public void addViandProof(@Valid @NonNull @RequestBody ViandProof viandProof){
        peerService.addViandProof(viandProof);
    }

    @PostMapping("/vhashmatrix")
    public void addVHashMatrix(@Valid @NonNull @RequestBody VHashMatrix vHashMatrix){
        peerService.addVHashMatrix(vHashMatrix);
    }

    @PostMapping("/rcvituples")
    public void sendRquestRCVisTuple (@Valid @NonNull @RequestBody ResponseVRowCol responseVRowCol){
        peerService.hashVerifywithReceiveRquestRCVisTuple(responseVRowCol);
    }

    @PostMapping("/rowcoltreehashmaps") // peerID
    public void rowcoltreeHashMap(@Valid @NonNull @RequestBody RowColTreeHMaps rowColTreeHMaps) {
        peerService.rowcoltreeHashMap(rowColTreeHMaps);
    }



}
