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
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controladores.ControladorVCreadorNuevaOrden;
import Modulos.ModuloPrincipal;

public class CreadorNuevaOrden {

	private JFrame frame;
	private JTextField dispositivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ModuloPrincipal modulo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreadorNuevaOrden window = new CreadorNuevaOrden(modulo);
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
	public CreadorNuevaOrden(ModuloPrincipal modulo) {
		initialize(modulo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ModuloPrincipal modulo) {
		ControladorVCreadorNuevaOrden controlador = new ControladorVCreadorNuevaOrden(modulo);
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion:");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("Dispositivo:");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		dispositivo = new JTextField();
		dispositivo.setColumns(10);
		
		JTextPane descripcion = new JTextPane();
		descripcion.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlador.agregarOrden(dispositivo.getText(), descripcion.getText())) {
					lblNewLabel_3.setText("Agregado con éxito!");
				}
				else {
					lblNewLabel_3.setText("Error al agregar");
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonVolver();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(64)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(descripcion)
								.addComponent(dispositivo, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(dispositivo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(descripcion, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(30))
		);
		
		JLabel lblNewLabel = new JLabel("Crear nueva Orden\r\n");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 23));
		panel.add(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
	}

}
