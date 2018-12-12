////////////////////////////////////////////////////////////////////
// [Enrico] [Trinco] [1121850]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MenuItemTest {

	@Test
	public void getTipo_Pizza_Return() {
		MenuItem testPizza = new MenuItem(ItemType.Pizza, "Margherita", 3.5);
		ItemType mustPizza = testPizza.getTipo();
		assertEquals(ItemType.Pizza, mustPizza);
	}

	@Test
	public void getTipo_Primo_Return() {
		MenuItem testPrimo = new MenuItem(ItemType.Primo, "Spaghetti Pomodoro", 4.5);
		ItemType mustPrimo = testPrimo.getTipo();
		assertEquals(ItemType.Primo, mustPrimo);
	}
	
	@Test
	public void getPrice_SuccesfullReturned() {
		MenuItem testPrimo = new MenuItem(ItemType.Primo, "Spaghetti Pomodoro", 4.5);
		double prezzo = testPrimo.getPrice();
		final double DELTA = 0.01;
		assertEquals(4.5, prezzo,DELTA);
	}
}