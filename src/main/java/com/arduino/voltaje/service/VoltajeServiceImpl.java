package com.arduino.voltaje.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arduino.voltaje.dao.IVoltajeDao;
import com.arduino.voltaje.entity.Voltaje;

@Service
public class VoltajeServiceImpl implements IVoltajeService {

	@Autowired
	private IVoltajeDao dao;

	@Override
	@Transactional(readOnly = true)
	public List<Voltaje> findByOrderByCreateAtAsc() {
		return (List<Voltaje>) dao.findByOrderByCreateAtAsc();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Voltaje> getAllBetweenDates(String startDate, String endDate) {
		return (List<Voltaje>) dao.getAllBetweenDates(startDate, endDate);
	}

	@Override
	@Transactional
	public void save(Voltaje voltaje) {
		dao.save(voltaje);

	}

	@Override
	@Transactional(readOnly = true)
	public Voltaje findById(Long id) {
		return dao.findById(id).orElse(null);
	}


}
