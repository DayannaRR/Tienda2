package com.tienda.repository;


import com.tienda.entity.ReportePersona;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Dayanna Rojas
 */
public interface PersonaReporteRepository {
    ReportePersona obtenerReporte(Map<String, Object> params) throws JRException, IOException, SQLException;
}
