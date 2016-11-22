
package com.seniorAdom.springmvc.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * A Renseigner.
 * @author  : nmhamdi
 * @project : TEST REST WEB SERVICES
 * @package : com.springmvc.model
 * @date    : 22 nov. 2016
 */
@Entity
@Table(name = "COORDONNE_POINT_GPS")
public class CoordonnePointGps implements Serializable
{
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @NotEmpty
   @Column(name = "LATITUDE", nullable = false)
   private Long    Latitude;
   
   @NotEmpty
   @Column(name = "LONGITUDE", nullable = false)
   private Long    Longitude;
   
   
   @Column(name = "CREATE_DATE", nullable = false)
   LocalDateTime createdDate;

   /**
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( Latitude == null ) ? 0 : Latitude.hashCode() );
      result = prime * result + ( ( Longitude == null ) ? 0 : Longitude.hashCode() );
      return result;
   }
   
   /**
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals( Object obj )
   {
      if( this == obj ) return true;
      if( obj == null ) return false;
      if( getClass() != obj.getClass() ) return false;
      CoordonnePointGps other = (CoordonnePointGps) obj;
      if( Latitude == null )
      {
         if( other.Latitude != null ) return false;
      }
      else if( !Latitude.equals( other.Latitude ) ) return false;
      if( Longitude == null )
      {
         if( other.Longitude != null ) return false;
      }
      else if( !Longitude.equals( other.Longitude ) ) return false;
      return true;
   }
   
   /**
    * @return the id
    */
   public Long getId()
   {
      return id;
   }
   
   /**
    * @param aId the id to set
    */
   public void setId( Long aId )
   {
      id = aId;
   }
   
   /**
    * @return the latitude
    */
   public Long getLatitude()
   {
      return Latitude;
   }
   
   /**
    * @param aLatitude the latitude to set
    */
   public void setLatitude( Long aLatitude )
   {
      Latitude = aLatitude;
   }
   
   /**
    * @return the longitude
    */
   public Long getLongitude()
   {
      return Longitude;
   }
   
   /**
    * @param aLongitude the longitude to set
    */
   public void setLongitude( Long aLongitude )
   {
      Longitude = aLongitude;
   }
   
   /**
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return "CoordonnePointGps [Latitude=" + Latitude + ", Longitude=" + Longitude + "]";
   }
}
