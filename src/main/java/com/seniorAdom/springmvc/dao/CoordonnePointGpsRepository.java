package com.seniorAdom.springmvc.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seniorAdom.springmvc.model.CoordonnePointGps;

/**
 * A Renseigner.
 * @author  : nmhamdi
 * @project : Spring4MVCCRUDRestService
 * @package : com.websystique.springmvc.dao
 * @date    : 22 nov. 2016 
 */
public interface CoordonnePointGpsRepository extends JpaRepository <CoordonnePointGps, Long>
{
   CoordonnePointGps findById(int id);
   
   List<CoordonnePointGps> findByCreatedDateBetween(LocalDateTime datedebut,LocalDateTime datefin);
   
   void deleteByLatitudeOrLongitude(String aLatitude,String aLongitude);
   
   List<CoordonnePointGps> findAllCoordonnePointGps();
}
