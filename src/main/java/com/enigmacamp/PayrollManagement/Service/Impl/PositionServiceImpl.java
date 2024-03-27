package com.enigmacamp.PayrollManagement.Service.Impl;

import com.enigmacamp.PayrollManagement.Entity.Position;
import com.enigmacamp.PayrollManagement.Repository.PositionRepository;
import com.enigmacamp.PayrollManagement.Service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    @Override
    public Position savePosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }
}
