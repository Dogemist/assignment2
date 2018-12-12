////////////////////////////////////////////////////////////////////
// [Enrico] [Trinco] [1121850]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

@RunWith(Parameterized.class)
public class BellaNapoliTest {

	
	private RestaurantBill ristorante;
	
	@Before
	public void inizializzazione() {
		ristorante = new BellaNapoli();
	}
	
	//Ordine che supera il numero massimo di elementi disponibili (20)
public static List<MenuItem> tooMuchThingOrder(){
			List<MenuItem> returned = new LinkedList<MenuItem>();
			
			returned.add(new MenuItem(ItemType.Pizza, "Margherita", 3));
			returned.add(new MenuItem(ItemType.Pizza, "Capricciosa", 5));
			returned.add(new MenuItem(ItemType.Pizza, "Viennese", 4.5));
			returned.add(new MenuItem(ItemType.Pizza, "Margherita", 3));
			returned.add(new MenuItem(ItemType.Pizza, "Capricciosa", 5));
			returned.add(new MenuItem(ItemType.Pizza, "Viennese", 4.5));
			returned.add(new MenuItem(ItemType.Pizza, "Pugliese", 4.5));
			returned.add(new MenuItem(ItemType.Pizza, "Patatosa", 4.5));
			returned.add(new MenuItem(ItemType.Pizza, "Buffala", 5));
			returned.add(new MenuItem(ItemType.Pizza, "Marinara", 3));
			returned.add(new MenuItem(ItemType.Pizza, "Diavola", 4.5));
			returned.add(new MenuItem(ItemType.Pizza, "Portello", 5));
			returned.add(new MenuItem(ItemType.Primo, "Spaghetti Carbonara", 6));
			returned.add(new MenuItem(ItemType.Primo, "Bucatini Matriciana", 5));
			returned.add(new MenuItem(ItemType.Primo, "Penne al pomodoro", 4));
			returned.add(new MenuItem(ItemType.Primo, "Bucatini Matriciana", 5));
			returned.add(new MenuItem(ItemType.Primo, "Penne al pomodoro", 4));
			returned.add(new MenuItem(ItemType.Primo, "Pasta cacio e pepe", 8));
			returned.add(new MenuItem(ItemType.Primo, "Spaghetti Carbonara", 6));
			returned.add(new MenuItem(ItemType.Primo, "Piatto molto costoso", 50));
			returned.add(new MenuItem(ItemType.Primo, "Questo piatto", 1));
			returned.add(new MenuItem(ItemType.Primo, "Causa l'eccezione", 1));
			
			return returned; 	//errore
			}

	
	//Elenco pizze e primi dove non viene applicata nessuna scontistica

public static List<MenuItem> normalOrder() {
	List<MenuItem> returned = new LinkedList<MenuItem>();
	
	returned.add(new MenuItem(ItemType.Pizza, "Margherita", 3));
	returned.add(new MenuItem(ItemType.Pizza, "Capricciosa", 5));
	returned.add(new MenuItem(ItemType.Pizza, "Viennese", 4.5));
	returned.add(new MenuItem(ItemType.Primo, "Spaghetti Carbonara", 6));
	returned.add(new MenuItem(ItemType.Primo, "Bucatini Matriciana", 5));
	
	return returned; //totale 23.5
}

	//elenco pizze e primi dove il numero delle pizze è > 10
public static List<MenuItem> moreThanTenPizzasOrder(){
	List<MenuItem> returned = new LinkedList<MenuItem>();
	
	returned.add(new MenuItem(ItemType.Pizza, "Margherita", 3));
	returned.add(new MenuItem(ItemType.Pizza, "Capricciosa", 5));
	returned.add(new MenuItem(ItemType.Pizza, "Viennese", 4.5));
	returned.add(new MenuItem(ItemType.Pizza, "Pugliese", 4.5));
	returned.add(new MenuItem(ItemType.Pizza, "Patatosa", 4.5));
	returned.add(new MenuItem(ItemType.Pizza, "Buffala", 5));
	returned.add(new MenuItem(ItemType.Pizza, "Marinara", 3));
	returned.add(new MenuItem(ItemType.Pizza, "Diavola", 4.5));
	returned.add(new MenuItem(ItemType.Pizza, "Portello", 5));
	returned.add(new MenuItem(ItemType.Primo, "Spaghetti Carbonara", 6));
	returned.add(new MenuItem(ItemType.Primo, "Bucatini Matriciana", 5));
	returned.add(new MenuItem(ItemType.Primo, "Penne al pomodoro", 4));
	
	return returned; //totale 54; meno pizza 51
	}

	//ordine che costa più di 100€

public static List<MenuItem> expensiveOrder(){
	List<MenuItem> returned = new LinkedList<MenuItem>();
	
	returned.add(new MenuItem(ItemType.Pizza, "Margherita", 3));
	returned.add(new MenuItem(ItemType.Pizza, "Capricciosa", 5));
	returned.add(new MenuItem(ItemType.Pizza, "Marinara", 3));
	returned.add(new MenuItem(ItemType.Pizza, "Portello", 5));
	returned.add(new MenuItem(ItemType.Primo, "Spaghetti Carbonara", 6));
	returned.add(new MenuItem(ItemType.Primo, "Bucatini Matriciana", 5));
	returned.add(new MenuItem(ItemType.Primo, "Penne al pomodoro", 4));
	returned.add(new MenuItem(ItemType.Primo, "Piatto abbastanza costoso", 25));
	returned.add(new MenuItem(ItemType.Primo, "Spaghetti Carbonara", 6));
	returned.add(new MenuItem(ItemType.Primo, "Piatto molto costoso", 50));
	
	return returned; 	//totale 112; scontato del 5% 106.4
	}


	//ordine con più di 10 pizze e costo maggiore di 100€

public static List<MenuItem> allOrder(){
	List<MenuItem> returned = new LinkedList<MenuItem>();
	
	returned.add(new MenuItem(ItemType.Pizza, "Margherita", 3));
	returned.add(new MenuItem(ItemType.Pizza, "Capricciosa", 5));
	returned.add(new MenuItem(ItemType.Pizza, "Viennese", 4.5));
	returned.add(new MenuItem(ItemType.Pizza, "Pugliese", 4.5));
	returned.add(new MenuItem(ItemType.Pizza, "Patatosa", 4.5));
	returned.add(new MenuItem(ItemType.Pizza, "Buffala", 5));
	returned.add(new MenuItem(ItemType.Pizza, "Marinara", 3));
	returned.add(new MenuItem(ItemType.Pizza, "Diavola", 4.5));
	returned.add(new MenuItem(ItemType.Pizza, "Portello", 5));
	returned.add(new MenuItem(ItemType.Pizza, "Buffala", 5));
	returned.add(new MenuItem(ItemType.Pizza, "Porchetta", 5));
	returned.add(new MenuItem(ItemType.Primo, "Spaghetti Carbonara", 6));
	returned.add(new MenuItem(ItemType.Primo, "Bucatini Matriciana", 5));
	returned.add(new MenuItem(ItemType.Primo, "Penne al pomodoro", 4));
	returned.add(new MenuItem(ItemType.Primo, "Pasta cacio e pepe", 8));
	returned.add(new MenuItem(ItemType.Primo, "Spaghetti Carbonara", 6));
	returned.add(new MenuItem(ItemType.Primo, "Piatto molto costoso", 50));
	
	return returned; 	//totale 128; meno la pizza 125; scontato del 5% 118.75
	}


	@Test(expected = RestaurantBillException.class)
	public void exceptionTest() throws RestaurantBillException{
		ristorante.getOrderPrice(tooMuchThingOrder());
	}

	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{normalOrder(), 23.5},
			{moreThanTenPizzasOrder(), 54},
			{expensiveOrder(), 106.4},
			{allOrder(), 118.75}
		});
	}

	private List<MenuItem> input;
	private double expectedOutput;

	 public BellaNapoliTest(List<MenuItem> input, double expectedOutput) {
	        this.input = input;
	        this.expectedOutput = expectedOutput;
	    }
	
	@Test
	public void getOrderPriceSucces() throws RestaurantBillException {
		final double DELTA = 0.1;
		assertEquals(expectedOutput,ristorante.getOrderPrice(input), DELTA );
	}

}
