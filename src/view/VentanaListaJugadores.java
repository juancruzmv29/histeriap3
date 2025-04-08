package view;

import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class VentanaListaJugadores extends JDialog {
	private JLabel labelText;
	private JTextArea texto;
	private JButton botonSalir;
	private JButton botonSeguir;
	private HashMap<String, Integer> jugadores;
	
	
	public VentanaListaJugadores(JFrame parent, HashMap<String, Integer> jugadores) {
		super(parent, "Lista de jugadores ganadores");
		
		
		setSize(400, 350);
		setLocationRelativeTo(parent);
		setLayout(new FlowLayout());
		
		JPanel panelLista = new JPanel();
		labelText = new JLabel("Lista de jugadores ganadores");
		texto = new JTextArea();
		botonSeguir = new JButton("Seguir jugando");
		botonSalir = new JButton("Salir del juego");
		
		panelLista.add(labelText);
		panelLista.add(texto);
		panelLista.add(botonSeguir);
		panelLista.add(botonSalir);
		
		add(panelLista);
		
		setVisible(true);
		
		
	}
	
	
	
	
}
