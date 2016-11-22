package com.seniorAdom.springmvc.service;

import java.time.LocalDateTime;
import java.util.List;

import com.seniorAdom.springmvc.model.CoordonnePointGps;

/**
 * A Renseigner.
 * @author  : nmhamdi
 * @project : TEST REST WEB SERVICES
 * @package : com.springmvc.model
 * @date    : 22 nov. 2016
 */
public interface CoordonnePointGpsService {

   CoordonnePointGps findById(Long id);
   
   List<CoordonnePointGps> findByCreatedDateBetween(LocalDateTime datedebut,LocalDateTime datefin);
   
   void save(CoordonnePointGps aCoordonnePointGps);
   
   void deleteCoordonnePointGps( CoordonnePointGps aCoordonnePointGps );

   List<CoordonnePointGps> findAllCoordonnePointGps();

	
}
