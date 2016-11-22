
package com.seniorAdom.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.seniorAdom.springmvc.model.CoordonnePointGps;
import com.seniorAdom.springmvc.service.CoordonnePointGpsService;

/**
 * A Renseigner.
 * @author  :  Naji mhamdi
 * @project : TEST REST WEB SERVICES
 * @package : com.springmvc.model
 * @date    : 22 nov. 2016 
 */
@RestController
public class RestControllerTest
{
   
   @Autowired
   CoordonnePointGpsService coordonnePointGpsService;
   
   //-------------------Retrieve All coordonnePointGpsService--------------------------------------------------------
   @RequestMapping(value = "/coordonnePointGps/", method = RequestMethod.GET)
   public ResponseEntity<List<CoordonnePointGps>> listAllCoordonnePointGpss()
   {
      List<CoordonnePointGps> allCoordonnePointGps = coordonnePointGpsService.findAllCoordonnePointGps();
      if( allCoordonnePointGps.isEmpty() )
      {
         return new ResponseEntity<List<CoordonnePointGps>>( HttpStatus.NO_CONTENT );//You many decide to return HttpStatus.NOT_FOUND
      }
      return new ResponseEntity<List<CoordonnePointGps>>( allCoordonnePointGps, HttpStatus.OK );
   }
   
   //-------------------Retrieve Single CoordonnePointGps--------------------------------------------------------
   @RequestMapping(value = "/coordonnePointGps/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<CoordonnePointGps> getCoordonnePointGps( @PathVariable("id") long id )
   {
      System.out.println( "Fetching CoordonnePointGps with id " + id );
      CoordonnePointGps coordonnePointGps = coordonnePointGpsService.findById( id );
      if( coordonnePointGps == null )
      {
         System.out.println( "CoordonnePointGps with id " + id + " not found" );
         return new ResponseEntity<CoordonnePointGps>( HttpStatus.NOT_FOUND );
      }
      return new ResponseEntity<CoordonnePointGps>( coordonnePointGps, HttpStatus.OK );
   }
   
   //-------------------Create a CoordonnePointGps--------------------------------------------------------
   @RequestMapping(value = "/coordonnePointGps/", method = RequestMethod.POST)
   public ResponseEntity<Void> createCoordonnePointGps( @RequestBody CoordonnePointGps coordonnePointGps, UriComponentsBuilder ucBuilder )
   {
      System.out.println( "Creating CoordonnePointGps " + coordonnePointGps.toString() );
      coordonnePointGpsService.save( coordonnePointGps );
      HttpHeaders headers = new HttpHeaders();
      headers.setLocation( ucBuilder.path( "/coordonnePointGps/{id}" ).buildAndExpand( coordonnePointGps.getId() ).toUri() );
      return new ResponseEntity<Void>( headers, HttpStatus.CREATED );
   }
   
   //------------------- Delete a CoordonnePointGps --------------------------------------------------------
   @RequestMapping(value = "/coordonnePointGps/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<CoordonnePointGps> deleteCoordonnePointGps( @PathVariable("id") long id )
   {
      System.out.println( "Fetching & Deleting CoordonnePointGps with id " + id );
      CoordonnePointGps coordonnePointGps = coordonnePointGpsService.findById( id );
      if( coordonnePointGps == null )
      {
         System.out.println( "Unable to delete. CoordonnePointGps with id " + id + " not found" );
         return new ResponseEntity<CoordonnePointGps>( HttpStatus.NOT_FOUND );
      }
      coordonnePointGpsService.deleteCoordonnePointGps( coordonnePointGps );
      return new ResponseEntity<CoordonnePointGps>( HttpStatus.NO_CONTENT );
   }
}
