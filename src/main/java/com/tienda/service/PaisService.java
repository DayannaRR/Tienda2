/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.repository.PaisRepository;
import com.tienda.entity.Pais;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dayanna Rojas
 */

    @Service
    public class PaisService implements IPaisService{

     @Autowired
     private PaisRepository paisRepository;
        
    @Override
    public List<Pais> listCountry() {
       return (List<Pais>)paisRepository.findAll(); }
        
    }

    


