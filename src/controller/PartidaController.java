package controller;

import model.Cuadro;
import view.VentanaPrincipal;

public class PartidaController {
	
	private Cuadro[][] cuadros;
	private int cuadrosColoreados;
	private int cuadrosTotal = 25;

	
	
	public PartidaController(Cuadro[][] cuadros) {
		this.cuadros = cuadros;
	}
	
	
	// Funcion para que al clickear un cuadro, se coloreen los de al lado
	public void colorearCuadro(Cuadro c) {
		c.clickEnCuadro();
	}
	
	
	// Funcion que si un cuadro no tiene nada al lado o arriba o abajo no haga nada
	
	
	// Funcion de que si todos los cuadros están activos y/o coloreados el jugador gana
	public boolean todosCuadrosActivos(Cuadro[][] cuadros) {
		int cont = 0;
		for(int i = 0; i < cuadros.length; i++) {
			for(int j = 0; j < cuadros[0].length; j++) {
				if(cuadros[i][j].isActivo()) {
					cont++;
				}
			}
		}
		return cont == cuadrosTotal;
	}
	
	// Funcion para ver si todos los cuadros están activos
	public boolean todosLosCuadrosActivos(Cuadro[][] cuadros) {
		for(int i = 0; i < cuadros.length; i++) {
			for(int j = 0; j < cuadros[0].length; j++) {
				if(cuadros[i][j].isActivo()) {
					return true;
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
	// Funcion privada para cuando un cuadro se compare con el color de otro cuadro
	private boolean mismoColor(Cuadro c, Cuadro c1) {
		return c.getColorCuadro().equals(c1.getColorCuadro());
	}
	
	
	
	// Funcion para cuando alguno de los colores que esten alrededor de un cuadro sea igual
	public boolean perdisteJuego(Cuadro[][] cuadros) {
		
		for(int i = 0; i < cuadros.length; i++) {
			for(int j = 0; j < cuadros[0].length; j++) {
				if(cuadros[i][j].isActivo()) {
					if(mismoColor(cuadros[i][j], cuadros[i+1][j])) {
						return true;
					}
					if(mismoColor(cuadros[i][j], cuadros[i][j+1])) {
						return true;
					}
					if(mismoColor(cuadros[i][j], cuadros[i-1][j])) {
						return true;
					}
					if(mismoColor(cuadros[i][j], cuadros[i][j-1])) {
						return true;
					}
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
	
	// Funcion para reiniciar el juego y volver a colorear los cuadros a gris
	public void reiniciarJuego(Cuadro[][] cuadros) {
		for(int i = 0; i < cuadros.length; i++) {
			for(int j = 0; j < cuadros[0].length; j++) {
				cuadros[i][j].ponerEnGris();
			}
		}
		cuadrosColoreados = 0;
	}
	
	
	// Funcion sumar cuadros
	public void sumarCuadradosActivos() {
		this.cuadrosColoreados++;
	}
	
	
	
}
