package com.arduino.voltaje.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arduino.voltaje.entity.Voltaje;

public interface IVoltajeDao extends JpaRepository<Voltaje, Long> {

	List<Voltaje> findByOrderByCreateAtAsc();
	
	@Query(value = "select * from voltaje where create_at BETWEEN ?1 AND ?2 order by create_at asc" , nativeQuery = true)
	List<Voltaje> getAllBetweenDates(String dateFrom, String dateTo);
	
//	@Query(value = "from Voltaje t where createAt BETWEEN :startDate AND :endDate")
//	public List<Voltaje> getAllBetweenDates2(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
}
