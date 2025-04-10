package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PartidaController;
import model.Cuadro;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class VentanaPrincipal extends JFrame {

	private Cuadro[][] cuadros;
	private PartidaController pController;
	private HashMap<String, Integer> jugadores;
	private int intentosClicks = 0;
	
	private final int FILAS = 5;
	private final int COLUMNAS = 5;
	
	

	public VentanaPrincipal(PartidaController pController) {
		//initialize();
		this.pController = pController;
		jugadores = new HashMap<String, Integer>();
		
		
		
		setTitle("Juego Histeria");
		setSize(600, 600);
		setLocationRelativeTo(null);																												
		getContentPane().setLayout(new GridLayout(5, 5, 2, 2));
		
		VentanaNombre ventanaInicio = new VentanaNombre(this, jugadores);
		ventanaInicio.setVisible(true);
		cuadros = new Cuadro[FILAS][COLUMNAS];
		for (int i = 0; i < FILAS; i++) {
		    for (int j = 0; j < COLUMNAS; j++) {
		        Cuadro cuadro = new Cuadro();
		        cuadros[i][j] = cuadro;
		        cuadro.setPreferredSize(getPreferredSize());

		        final int x = i;
		        final int y = j;

		        cuadro.addActionListener(e -> {
		            Color colorCentral = cuadro.getBackground();
		            intentosClicks++;

		            // Coordenadas de vecinos
		            int[][] vecinos = {
		                {x - 1, y}, // arriba
		                {x + 1, y}, // abajo
		                {x, y - 1}, // izquierda
		                {x, y + 1}  // derecha
		            };

		            for (int[] v : vecinos) {
		                int fila = v[0];
		                int col = v[1];

		                if (fila >= 0 && fila < FILAS && col >= 0 && col < COLUMNAS) {
		                    Cuadro vecino = cuadros[fila][col];
		                    Color colorVecino = vecino.getBackground();

		                    if (colorVecino.equals(colorCentral)) {
		                        // Mismo color, se apagan ambos
		                        vecino.ponerEnGris();
		                        cuadro.ponerEnGris();
		                    } else {
		                        // Activar el vecino con un nuevo color
		                        vecino.clickEnCuadro();
		                    }
		                }
		            }
		        });
		        
		        cuadros[i][j].addActionListener(e -> {
		            pController.colorearCuadro(cuadros[x][y]);

		            // Verificamos si el jugador ganó
		            if (pController.todosCuadrosActivos(cuadros)) {
		                JOptionPane.showMessageDialog(this, "¡Ganaste el juego!");
		                dispose(); // cerrar la ventana actual si querés
		            }

		            // También podés verificar si perdió
		            if (pController.perdisteJuego(cuadros)) {
		                JOptionPane.showMessageDialog(this, "¡Perdiste el juego!");
		                dispose();
		            }
		        });

		        getContentPane().add(cuadro);
		        cuadros[i][j].addActionListener(e -> {
		            pController.colorearCuadro(cuadros[x][y]);
		            intentosClicks++;
		            
		            if (pController.todosCuadrosActivos(cuadros)) {
		                jugadores.put(ventanaInicio.getNombreJugador(), intentosClicks);
		                guardarRankingEnArchivo(jugadores);

		                String mensajeFinal = "¡Ganaste el juego!";
		                mostrarMenuFinal(mensajeFinal);
		            }

		            if (pController.perdisteJuego(cuadros)) {
		                String mensajeFinal = "¡Perdiste el juego!";
		                mostrarMenuFinal(mensajeFinal);
		            }
		        });
		    }
		}
		
		
		
		setVisible(true);
		
	}
	
	public void guardarRankingEnArchivo(HashMap<String, Integer> jugadores) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter("ranking.txt", true))) {
	        for (Map.Entry<String, Integer> entry : jugadores.entrySet()) {
	            writer.println(entry.getKey() + ":" + entry.getValue());
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private void reiniciarJuego() {
	    Cuadro[][] nuevosCuadros = new Cuadro[FILAS][COLUMNAS];
	    SwingUtilities.invokeLater(() -> new VentanaPrincipal(new PartidaController(nuevosCuadros)));
	}
	
	private void mostrarMenuFinal(String mensajeFinal) {
	    String[] opciones = {"Seguir jugando", "Ver ranking", "Salir"};
	    int opcion = JOptionPane.showOptionDialog(this,
	            mensajeFinal,
	            "Juego terminado",
	            JOptionPane.DEFAULT_OPTION,
	            JOptionPane.INFORMATION_MESSAGE,
	            null,
	            opciones,
	            opciones[0]);

	    switch (opcion) {
	        case 0:
	            dispose();
	            reiniciarJuego();
	            break;
	        case 1:
	            new VentanaRanking();
	            break;
	        case 2:
	        default:
	            System.exit(0);
	            break;
	    }
	}

}
