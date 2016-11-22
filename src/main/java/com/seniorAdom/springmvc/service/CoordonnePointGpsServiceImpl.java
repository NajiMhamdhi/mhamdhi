
package com.seniorAdom.springmvc.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seniorAdom.springmvc.dao.CoordonnePointGpsRepository;
import com.seniorAdom.springmvc.model.CoordonnePointGps;

/**
 * A Renseigner.
 * @author  : nmhamdi
 * @project : TEST REST WEB SERVICES
 * @package : com.springmvc.model
 * @date    : 22 nov. 2016 
 */
@Service("coordonnePointGpsService")
@Transactional
public class CoordonnePointGpsServiceImpl implements CoordonnePointGpsService
{
   
   @Autowired
   private CoordonnePointGpsRepository coordonnePointGpsRepository;
   
   @Override
   public List<CoordonnePointGps> findByCreatedDateBetween( LocalDateTime aDatedebut, LocalDateTime aDatefin )
   {
      return coordonnePointGpsRepository.findByCreatedDateBetween( aDatedebut, aDatefin );
   }
   
   @Override
   public CoordonnePointGps findById( Long aId )
   {
      return coordonnePointGpsRepository.findOne( aId );
   }
   
   @Override
   public void save( CoordonnePointGps aCoordonnePointGps )
   {
      coordonnePointGpsRepository.saveAndFlush( aCoordonnePointGps );
   }
   
   @Override
   public void deleteCoordonnePointGps( CoordonnePointGps aCoordonnePointGps )
   {
      coordonnePointGpsRepository.delete( aCoordonnePointGps );
   }
  
   
   @Override
   public List<CoordonnePointGps> findAllCoordonnePointGps()
   {
      return coordonnePointGpsRepository.findAllCoordonnePointGps();
   }

 }


   

   

 
