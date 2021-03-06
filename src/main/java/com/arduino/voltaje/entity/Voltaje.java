package com.arduino.voltaje.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="voltaje")
public class Voltaje implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4108770926928592634L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String voltaje;

	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createAt;

	@Transient
//	@Temporal(TemporalType.TIMESTAMP)
//	@JsonFormat(pattern="yyyy,MM,dd,HH,mm,ss")
	private String createAtGoogleChartFomatted;

//	@Transient
//	@Temporal(TemporalType.TIMESTAMP)
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//	private Date createAtDateFormatted;

	
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVoltaje() {
		return voltaje;
	}

	public void setVoltaje(String voltaje) {
		this.voltaje = voltaje;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getCreateAtGoogleChartFomatted() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy,MM,dd,HH,mm,ss");
		formatter.setTimeZone(TimeZone.getTimeZone("Europe/Madrid")); 
		String format = formatter.format(getCreateAt());
		String data[] = format.split(",");
		int mes = Integer.parseInt(data[1]) - 1;
		String parte1 = format.substring(0, 5);
		String parte2 = format.substring(7);
		format = parte1 + mes + parte2;
		return format;
	}


}
