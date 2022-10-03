package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import Modulos.ModuloPrincipal;
import Controladores.ControladorVEditarDatosEmpleados;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class EditarDatosEmpleado {

	private JFrame frame;
	private JTextField nombre;
	private JTextField rut;
	private JTextField direccion;
	private JTextField celular;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ModuloPrincipal modulo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarDatosEmpleado window = new EditarDatosEmpleado(modulo);
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
	public EditarDatosEmpleado(ModuloPrincipal modulo) {
		initialize(modulo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ModuloPrincipal modulo) {
		ControladorVEditarDatosEmpleados controlador = new ControladorVEditarDatosEmpleados(modulo);
		frame = new JFrame();
		frame.setBounds(100, 100, 595, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		nombre = new JTextField(controlador.getNombreEmpleado());
		nombre.setEditable(false);
		nombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Rut:");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		rut = new JTextField(controlador.getRutEmpleado());
		rut.setEditable(false);
		rut.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion:");
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		direccion = new JTextField(controlador.getDireccionEmpleado());
		direccion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Celular:");
		lblNewLabel_4.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		celular = new JTextField(controlador.getCelularEmpleado());
		celular.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Password:");
		lblNewLabel_5.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		JLabel textoExitoError = new JLabel("");
		textoExitoError.setHorizontalTextPosition(SwingConstants.CENTER);
		textoExitoError.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		
		password = new JTextField(controlador.getPasswordEmpleado());
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlador.actualizarDatos(direccion.getText(), celular.getText(), password.getText())) {
					textoExitoError.setText("Datos actualizados con éxito");
				}
				else {
					textoExitoError.setText("Error al actualizar");
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
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(password, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
						.addComponent(celular, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
						.addComponent(direccion, Alignment.LEADING, 410, 410, 410)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(rut)
							.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(textoExitoError, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addComponent(btnNewButton)))
					.addGap(29))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rut, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(direccion, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(celular, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(textoExitoError, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
		);
		
		JLabel lblNewLabel = new JLabel("Editar Datos");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 23));
		panel.add(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
	}

}
