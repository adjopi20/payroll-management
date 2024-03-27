package com.enigmacamp.PayrollManagement.Service;

import com.enigmacamp.PayrollManagement.Entity.Employee;
import com.enigmacamp.PayrollManagement.Entity.Position;

import java.util.List;

public interface PositionService {
    Position savePosition(String stringEPosition);
    List<Position> getAllPosition();
}
