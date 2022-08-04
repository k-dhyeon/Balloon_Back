package com.balloon.service;

import java.util.List;

import com.balloon.dto.UnitDTO;
import com.balloon.entity.Unit;

public interface UnitService {
	public List<Unit> findUnitAll();
	
	public Unit findUnitByUnitCode(String unitCode);
	
	public void insertUnit(UnitDTO unitDTO);
	
	public void updateUnit(UnitDTO unitDTO);
	
	public void deleteUnitByUnitCode(String unitCode);

}