package Ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controladores.ControladroVInicioSesionUsuario;
import Excepciones.ExistException;
import Modulos.ModuloPrincipal;

public class InicioSesionUsuario {

	private JFrame frame;
	private JTextField nombre;
	private JTextField rut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ModuloPrincipal modulo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesionUsuario window = new InicioSesionUsuario(modulo);
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
	public InicioSesionUsuario(ModuloPrincipal modulo) {
		initialize(modulo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ModuloPrincipal modulo) {
		ControladroVInicioSesionUsuario controlador = new ControladroVInicioSesionUsuario(modulo);
		frame = new JFrame();
		frame.setBounds(100, 100, 519, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		
		nombre = new JTextField();
		nombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Rut:");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		
		rut = new JTextField();
		rut.setColumns(10);
		
		JLabel accederError = new JLabel("");
		accederError.setHorizontalAlignment(SwingConstants.LEFT);
		accederError.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(controlador.verificarUsuario(nombre.getText(), rut.getText())) {
						frame.setVisible(false);
						controlador.botonAcceder(rut.getText());
					}
					else {
						accederError.setText("Nombre o rut incorretos.");
					}
				} catch (ExistException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("Registarse");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonRegistrarse();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(btnNewButton_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(nombre, Alignment.LEADING, 331, 331, 331)
						.addComponent(rut, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(accederError, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(rut, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(accederError, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("Quien eres?");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		panel.add(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
	}

}
