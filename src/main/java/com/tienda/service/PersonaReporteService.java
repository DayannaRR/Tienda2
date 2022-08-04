/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.commons.JasperReportPersona;

import com.tienda.entity.ReportePersona;
import com.tienda.enums.TipoReporte;
import com.tienda.repository.PersonaReporteRepository;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dayanna Rojas
 */
public class PersonaReporteService implements PersonaReporteRepository {
       
    @Autowired
    private JasperReportPersona jasperreportpersona;

    @Autowired
    private DataSource dataSource;

    @Override
    public ReportePersona obtenerReporte(Map<String, Object> params) throws JRException, IOException, SQLException {
      
		String fileName = "reporte_de_ventas";
		ReportePersona reportepersona = new ReportePersona();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporte.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		reportepersona.setFileName(fileName + extension);

		ByteArrayOutputStream stream = jasperreportpersona.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		reportepersona.setStream(new ByteArrayInputStream(bs));
		reportepersona.setLength(bs.length);

		return reportepersona;
	}

}
    

 
   
    
		

		

		


