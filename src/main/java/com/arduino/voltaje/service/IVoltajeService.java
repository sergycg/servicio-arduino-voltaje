package com.arduino.voltaje.service;

import java.util.Date;
import java.util.List;

import com.arduino.voltaje.entity.Voltaje;

public interface IVoltajeService {

	public List<Voltaje> findByOrderByCreateAtAsc();
	
	public void save (Voltaje voltaje);
	
	public Voltaje findById(Long id);
	
	public List<Voltaje> getAllBetweenDates(String startDate, String endDate);


}
