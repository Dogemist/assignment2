////////////////////////////////////////////////////////////////////
// [Enrico] [Trinco] [1121850]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class RestaurantBillException extends Throwable {
 public RestaurantBillException() { 
  System.out.println("Non sono ammessi più di 20 ordini");
  }
}