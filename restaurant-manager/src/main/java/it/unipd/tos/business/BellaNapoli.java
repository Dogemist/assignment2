////////////////////////////////////////////////////////////////////
// [Enrico] [Trinco] [1121850]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

public class BellaNapoli implements RestaurantBill {
 public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException{
 double totalOrder = 0;
 int numOrdini = 0;
 int numPizze = 0;
 double minPrice = 100;
 for(MenuItem ordine : itemsOrdered) {
  numOrdini++;
  if (numOrdini > 20) {
   throw new RestaurantBillException();
   }
  if (ordine.getTipo() == ItemType.Pizza) {
   numPizze++;
   if(ordine.getPrice()< minPrice) {
    minPrice = ordine.getPrice();
    }
   }
  minPrice = ordine.getPrice();
  totalOrder = totalOrder + ordine.getPrice();
  }
 if(numPizze > 10) {
  return totalOrder - minPrice;
  }
 else {
  return totalOrder;
  }
 }
}
