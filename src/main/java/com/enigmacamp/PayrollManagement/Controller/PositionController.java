package com.enigmacamp.PayrollManagement.Controller;

import com.enigmacamp.PayrollManagement.Entity.Position;
import com.enigmacamp.PayrollManagement.Repository.PositionRepository;
import com.enigmacamp.PayrollManagement.Service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService positionService;

    @PostMapping
    public ResponseEntity<Position> savePosition(@RequestBody String stringEPosition){
        Position savedPosition = positionService.savePosition(stringEPosition);
        return new ResponseEntity<>(savedPosition, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Position>> getAllPosition(){
        List<Position> positions = positionService.getAllPosition();
        return  new ResponseEntity<>(positions, HttpStatus.OK);
    }

}
