package Ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import Controladores.ControladorVMenuPrincipal;
import Modulos.ModuloPrincipal;

public class MenuPrincipal {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ModuloPrincipal modulo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal(modulo);
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
	public MenuPrincipal(ModuloPrincipal modulo) throws IOException {
		initialize(modulo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ModuloPrincipal modulo) throws IOException {
		ControladorVMenuPrincipal controlador;
		if(modulo == null) {
			controlador = new ControladorVMenuPrincipal();
			controlador.importarData();
		}
		else {
			controlador = new ControladorVMenuPrincipal(modulo);
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 64, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frame.getContentPane());
		panel.setBackground(new Color(255, 128, 64));
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Servicio Tecnico JVM");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 205, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 225, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 84, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -214, SpringLayout.EAST, frame.getContentPane());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenido a Servicio Tecnico JVM ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 8, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 45, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -10, SpringLayout.EAST, panel);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setLabelFor(frame);
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ingresa como usuario o empleado para poder utilizar la aplicación");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 17, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -38, SpringLayout.EAST, frame.getContentPane());
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 17));
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Empleado");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonEmpleado();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 86, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 385, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -121, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -132, SpringLayout.EAST, frame.getContentPane());
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonUsuario();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 86, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 93, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 262, SpringLayout.WEST, frame.getContentPane());
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.setVisible(false);
					controlador.exportarData();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 277, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -41, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, 382, SpringLayout.WEST, frame.getContentPane());
		btnNewButton_2.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		frame.getContentPane().add(btnNewButton_2);
	}

}
