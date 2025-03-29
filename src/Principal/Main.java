package Principal;

import controller.PartidaController;
import model.Cuadro;
import view.VentanaPrincipal;

public class Main {
	public static void main(String[] args) {
		
		// Creamos el modelo, es decir, la partida
		//Cuadro cuadro = new Cuadro();
		Cuadro[][] cuadros = new Cuadro[5][5];
		
		// Creamos el controlador
		PartidaController pController = new PartidaController(cuadros);
		
		// Creamos la vista
		VentanaPrincipal vPrincipal = new VentanaPrincipal(pController);
		
	}
}
