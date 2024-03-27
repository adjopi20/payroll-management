package com.enigmacamp.PayrollManagement.Controller;

import com.enigmacamp.PayrollManagement.Entity.Position;
import com.enigmacamp.PayrollManagement.Repository.PositionRepository;
import com.enigmacamp.PayrollManagement.Service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/position")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService positionService;

    @PostMapping
    public ResponseEntity<Position> savePosition(Position position){
        Position savedPosition = positionService.savePosition(position);
        return new ResponseEntity<>(savedPosition, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Position>> getAllPosition(){
        List<Position> positions = positionService.getAllPosition();
        return  new ResponseEntity<>(positions, HttpStatus.OK);
    }

}
