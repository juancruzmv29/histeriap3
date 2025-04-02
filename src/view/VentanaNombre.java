package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaNombre extends JDialog {
	private List<String> listaJugadores;
	private JTextField nombreJugador;
	private JLabel labelText;
	private JButton botonAceptar;
	
	
	public VentanaNombre(JFrame parent, ArrayList<String> jugadores) {
		super(parent,"Ingrese su nombre", true);
		this.listaJugadores = jugadores;
		
		
		setSize(300, 150);
		setLocationRelativeTo(parent);
		setLayout(new GridLayout(2, 1));
		
		JPanel panelInput = new JPanel();
		nombreJugador = new JTextField(15);
		labelText = new JLabel("Ingrese su nombre");
		panelInput.add(labelText);
		panelInput.add(nombreJugador);
		
		JPanel panelBoton = new JPanel();
		botonAceptar = new JButton("Aceptar");
		panelBoton.add(botonAceptar);
		
		
		add(panelInput);
		add(panelBoton);
		
		nombreJugador.addActionListener(e -> guardarNombreYJugar());
		botonAceptar.addActionListener(e -> guardarNombreYJugar());
		
	}
	
	
	private void guardarNombreYJugar() {
		String nombre = nombreJugador.getText().trim();
		if(!nombre.isEmpty()) {
			listaJugadores.add(nombre);
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Ingrese un nombre válido");
		}
		
	}
}
