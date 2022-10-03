package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import Controladores.ControladorVMenuEmpleado;
import Modulos.ModuloPrincipal;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuEmpleado {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ModuloPrincipal modulo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEmpleado window = new MenuEmpleado(modulo);
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
	public MenuEmpleado(ModuloPrincipal modulo) {
		initialize(modulo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ModuloPrincipal modulo) {
		ControladorVMenuEmpleado controlador = new ControladorVMenuEmpleado(modulo);
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		
		JButton btnNewButton = new JButton("Mostrar Ordenes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonMostarOrdenes();
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("Mostrar Repuestos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonMostrarRepuestos();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));

		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonVolver();
			}
		});
		btnNewButton_2.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JButton btnNewButton_3 = new JButton("Asignar Repuestos");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonAsignarRepuestos();
			}
		});
		btnNewButton_3.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JButton btnNewButton_4 = new JButton("Editar Datos");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonEditarDatos();
			}
		});
		btnNewButton_4.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_1))
					.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
					.addGap(65))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(250)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(229, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(btnNewButton_2)
					.addGap(34))
		);
		
		JLabel bienvenida = new JLabel("Bienvenido" + " " + controlador.getNombreEmpleado());
		bienvenida.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		panel.add(bienvenida);
		frame.getContentPane().setLayout(groupLayout);
	}
}
