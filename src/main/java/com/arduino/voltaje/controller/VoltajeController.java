package com.arduino.voltaje.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.arduino.voltaje.entity.Voltaje;
import com.arduino.voltaje.service.IVoltajeService;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

@CrossOrigin(origins = { "*" })
@RestController
//@RequestMapping("/Voltaje")
public class VoltajeController {

	@RequestMapping("/help")
	public String helloWorld() {
		return "Voltaje Service v1.0";
	}

	@Autowired
	private IVoltajeService voltajeService;

	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() {
		List<Voltaje> voltaje = voltajeService.findByOrderByCreateAtAsc();
		if (voltaje != null) {
			return new ResponseEntity<>(voltaje, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/findAllGoogleChartFormat")
	@ResponseStatus(value = HttpStatus.OK)
	public JsonObject findAllGoogleChartFormat() {
		List<Voltaje> voltaje = voltajeService.findByOrderByCreateAtAsc();
		return createJsonGoogleChartFormat(voltaje);
	}

	@GetMapping("/findAllGoogleChartFormatBetweenDates/{dateFrom}/{dateTo}")
	@ResponseStatus(value = HttpStatus.OK)
	public JsonObject findAllGoogleChartFormatBetweenDates(@PathVariable String dateFrom, @PathVariable String dateTo) {
		List<Voltaje> voltaje = voltajeService.getAllBetweenDates(dateFrom, dateTo);
		return createJsonGoogleChartFormat(voltaje);
	}

	@GetMapping("/findAllGoogleChartFormatLastHour")
	@ResponseStatus(value = HttpStatus.OK)
	public JsonObject findAllGoogleChartFormatLastHour() {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdateTo = formatter.format(today);
		String sdateFrom = formatter.format(new Date(today.getTime() - (1000 * 60 * 60 * 1)));
		List<Voltaje> voltaje = voltajeService.getAllBetweenDates(sdateFrom, sdateTo);
		return createJsonGoogleChartFormat(voltaje);
	}

	@GetMapping("/findAllGoogleChartFormatLast8Hour")
	@ResponseStatus(value = HttpStatus.OK)
	public JsonObject findAllGoogleChartFormatLast8Hour() {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdateTo = formatter.format(today);
		String sdateFrom = formatter.format(new Date(today.getTime() - (1000 * 60 * 60 * 8)));
		List<Voltaje> voltaje = voltajeService.getAllBetweenDates(sdateFrom, sdateTo);
		return createJsonGoogleChartFormat(voltaje);
	}

	@GetMapping("/findAllGoogleChartFormatLast12Hour")
	@ResponseStatus(value = HttpStatus.OK)
	public JsonObject findAllGoogleChartFormatLast12Hour() {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdateTo = formatter.format(today);
		String sdateFrom = formatter.format(new Date(today.getTime() - (1000 * 60 * 60 * 12)));
		List<Voltaje> voltaje = voltajeService.getAllBetweenDates(sdateFrom, sdateTo);
		return createJsonGoogleChartFormat(voltaje);
	}

	@GetMapping("/findAllGoogleChartFormatLast16Hour")
	@ResponseStatus(value = HttpStatus.OK)
	public JsonObject findAllGoogleChartFormatLast16Hour() {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdateTo = formatter.format(today);
		String sdateFrom = formatter.format(new Date(today.getTime() - (1000 * 60 * 60 * 16)));
		List<Voltaje> voltaje = voltajeService.getAllBetweenDates(sdateFrom, sdateTo);
		return createJsonGoogleChartFormat(voltaje);
	}

	@GetMapping("/findAllGoogleChartFormatLast24Hour")
	@ResponseStatus(value = HttpStatus.OK)
	public JsonObject findAllGoogleChartFormatLast24Hour() {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdateTo = formatter.format(today);
		String sdateFrom = formatter.format(new Date(today.getTime() - (1000 * 60 * 60 * 24)));
		List<Voltaje> voltaje = voltajeService.getAllBetweenDates(sdateFrom, sdateTo);
		return createJsonGoogleChartFormat(voltaje);
	}

	@GetMapping("/findAllGoogleChartFormatLast2Days")
	@ResponseStatus(value = HttpStatus.OK)
	public JsonObject findAllGoogleChartFormatLast2Days() {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdateTo = formatter.format(today);
		String sdateFrom = formatter.format(new Date(today.getTime() - (1000 * 60 * 60 * 24 * 2)));
		List<Voltaje> voltaje = voltajeService.getAllBetweenDates(sdateFrom, sdateTo);
		return createJsonGoogleChartFormat(voltaje);
	}

	@GetMapping("/findAllGoogleChartFormatLast3Days")
	@ResponseStatus(value = HttpStatus.OK)
	public JsonObject findAllGoogleChartFormatLast3Days() {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdateTo = formatter.format(today);
		String sdateFrom = formatter.format(new Date(today.getTime() - (1000 * 60 * 60 * 24 * 3)));
		List<Voltaje> voltaje = voltajeService.getAllBetweenDates(sdateFrom, sdateTo);
		return createJsonGoogleChartFormat(voltaje);
	}

	@GetMapping("/findAllGoogleChartFormatLast5Days")
	@ResponseStatus(value = HttpStatus.OK)
	public JsonObject findAllGoogleChartFormatLast5Days() {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdateTo = formatter.format(today);
		String sdateFrom = formatter.format(new Date(today.getTime() - (1000 * 60 * 60 * 24 * 5)));
		List<Voltaje> voltaje = voltajeService.getAllBetweenDates(sdateFrom, sdateTo);
		return createJsonGoogleChartFormat(voltaje);
	}
	
 	@GetMapping("/findAllGoogleChartFormatLastWeek")
	@ResponseStatus(value = HttpStatus.OK)
	public JsonObject findAllGoogleChartFormatLastWeek() {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdateTo = formatter.format(today);
		String sdateFrom = formatter.format(new Date(today.getTime() - (1000 * 60 * 60 * 24 * 7)));
		List<Voltaje> voltaje = voltajeService.getAllBetweenDates(sdateFrom, sdateTo);
		return createJsonGoogleChartFormat(voltaje);
	}

 	@GetMapping("/findAllGoogleChartFormatLastMonth")
	@ResponseStatus(value = HttpStatus.OK)
	public JsonObject findAllGoogleChartFormatLastMonth() {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdateTo = formatter.format(today);
		String sdateFrom = formatter.format(addDate(new Date(), 0, -1, 0));
		List<Voltaje> voltaje = voltajeService.getAllBetweenDates(sdateFrom, sdateTo);
		return createJsonGoogleChartFormat(voltaje);
	}

 	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getVoltajeById(@PathVariable Long id) {
		Voltaje voltaje = voltajeService.findById(id);
		if (voltaje != null) {
			return new ResponseEntity<>(voltaje, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveVoltaje(@RequestBody Voltaje voltaje) {
		this.voltajeService.save(voltaje);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	private JsonObject createJsonGoogleChartFormat(List<Voltaje> voltaje) {

		JsonObject jsonResult = new JsonObject();
		JsonObject jsonCol1 = new JsonObject();
		JsonObject jsonCol2 = new JsonObject();
		JsonArray jsonColArrayResult = new JsonArray();
		jsonCol1.put("id", "");
		jsonCol1.put("label", "Tiempo");
		jsonCol1.put("pattern", "");
		jsonCol1.put("type", "datetime");

		jsonCol2.put("id", "");
		jsonCol2.put("label", "Voltaje");
		jsonCol2.put("pattern", "");
		jsonCol2.put("type", "number");
		jsonColArrayResult.add(jsonCol1);
		jsonColArrayResult.add(jsonCol2);

		JsonArray jsonRowArrayResult = new JsonArray();
		for (Voltaje data : voltaje) {
			JsonObject jsonData = new JsonObject();
			JsonObject date = new JsonObject();
			date.put("v", "Date(" + data.getCreateAtGoogleChartFomatted() + ")");
			JsonObject valor = new JsonObject();
			valor.put("v", data.getVoltaje());
			JsonArray jsonarray = new JsonArray();
			jsonarray.add(date);
			jsonarray.add(valor);
			jsonData.put("c", jsonarray);
			jsonRowArrayResult.add(jsonData);
		}
		jsonResult.put("rows", jsonRowArrayResult);
		jsonResult.put("cols", jsonColArrayResult);
		return jsonResult;

	}
	
	private static Date addDate(Date date, int years, int months, int days)
	{
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.YEAR, years);
	    cal.add(Calendar.MONTH, months);
	    cal.add(Calendar.DATE, days);
	    return cal.getTime();
	}

}
