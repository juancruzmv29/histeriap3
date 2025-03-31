package view;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaNombre extends JDialog {
	private List<String> listaJugadores;
	private JTextField nombreJugador;
	private JLabel labelText;
	private JButton botonAceptar;
	
	
	public VentanaNombre(JFrame parent, ArrayList<String> jugadores) {
		super(parent, "Ingrese su nombre", true);
		this.listaJugadores = jugadores;
		
		setLayout(new FlowLayout());
		setSize(300, 150);
		setLocationRelativeTo(parent);
		
		nombreJugador = new JTextField();
		labelText = new JLabel("Ingrese su nombre");
		
		add(labelText);
		add(nombreJugador);
		add(botonAceptar);
		
		nombreJugador.addActionListener(e -> guardarNombreYJugar());
		botonAceptar.addActionListener(e -> guardarNombreYJugar());
		
		setVisible(true);
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
