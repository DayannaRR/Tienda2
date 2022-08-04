/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.ReportePersona;
import com.tienda.enums.TipoReporte;
import com.tienda.repository.PersonaReporteRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dayanna Rojas
 */

@RestController
@RequestMapping("/report")

 
public class ReportePersonaController {

	@Autowired
	private PersonaReporteRepository personareporterepository;

	@GetMapping(path = "/reportepersona/download")
	public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		ReportePersona reportepersona= personareporterepository.obtenerReporte(params);

		InputStreamResource streamResource = new InputStreamResource(reportepersona.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporte.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + reportepersona.getFileName() + "\"")
				.contentLength(reportepersona.getLength()).contentType(mediaType).body(streamResource);
	}

}
