////////////////////////////////////////////////////////////////////
// [Enrico] [Trinco] [1121850]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
 ItemType tipo;
 String nome;
 double price;

 public MenuItem(ItemType it, String piatto, double prezzo) {
  tipo = it;
  nome = piatto;
  price = prezzo;
 }
 
 public double getPrice() { return price;}
 public ItemType getTipo() { return tipo;}
}
