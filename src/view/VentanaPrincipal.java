package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PartidaController;
import model.Cuadro;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class VentanaPrincipal extends JFrame {

	private Cuadro[][] cuadros;
	private PartidaController pController;
	private HashMap<String, Integer> jugadores;
	private int intentos;
	
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
		
		for(int i = 0; i < cuadros.length; i++) {
			for(int j = 0; j < cuadros[0].length; j++) {
				cuadros[i][j] = new Cuadro();
				cuadros[i][j].setPreferredSize(getPreferredSize());
				getContentPane().add(cuadros[i][j]);
			}
		}
		setVisible(true);
		
		// Si el jugador perdio el juego
		if(pController.perdisteJuego(cuadros)) {
		    VentanaGameOver ventanaGameOver = new VentanaGameOver(this);
		    ventanaGameOver.setVisible(true);

		    ventanaGameOver.getBotonSeguir().addActionListener(e -> {
		        ventanaGameOver.dispose(); // Cierra la ventana de Game Over
		        dispose(); // Cierra esta ventana principal actual (opcional, depende si querés resetear)
		        
		        // Reinicia el juego creando una nueva instancia
		        SwingUtilities.invokeLater(() -> {
		            new VentanaPrincipal(new PartidaController(cuadros));
		        });
		    });
		}

		
		// Agregue esto si gana el juego
		if(pController.todosCuadrosActivos(cuadros)) {
			jugadores.put(ventanaInicio.getNombreJugador(), intentos);
			VentanaGameOver ventanaGameOver = new VentanaGameOver(this);
			ventanaGameOver.setVisible(true);
			
			ventanaGameOver.getBotonSeguir().addActionListener(e -> {
		        ventanaGameOver.dispose(); // Cierra la ventana de Game Over
		        dispose(); // Cierra esta ventana principal actual (opcional, depende si querés resetear)
		        
		        // Reinicia el juego creando una nueva instancia
		        SwingUtilities.invokeLater(() -> {
		            new VentanaPrincipal(new PartidaController(cuadros));
		        });
		    });
		}
		
		
	}
	
	
	
	
	/*
	private void initialize() {
		frame = new JFrame();
		frame.setSize(903, 300);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(FILAS, COLUMNAS));
		
		// Generamos un boton en la grilla
		for(int i = 0; i < FILAS; i++) {
			for(int j = 0; j < COLUMNAS; j++) {
				botones[i][j] = new JButton();
				panel.add(botones[i][j]);

				// Seteamos un color determinado en gris
				botones[i][j].setBackground(Color.gray);
				final int fila = i;
				final int columna = j;
			}
		}
		
	}*/

	/**
	 * Launch the application.
	 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */

}
