package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Modulos.ModuloPrincipal;
import Controladores.ControladorVEditarDatosUsuario;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class EditarDatosClientes {

	private JFrame frame;
	private JTextField nombreTxt;
	private JTextField rutTxt;
	private JTextField direccionTxt;
	private JTextField celularTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ModuloPrincipal modulo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarDatosClientes window = new EditarDatosClientes(modulo);
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
	public EditarDatosClientes(ModuloPrincipal modulo) {
		initialize(modulo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ModuloPrincipal modulo) {
		ControladorVEditarDatosUsuario controlador = new ControladorVEditarDatosUsuario(modulo);
		frame = new JFrame();
		frame.setBounds(100, 100, 593, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("Rut:");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3 = new JLabel("Dirección:");
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		JLabel lblNewLabel_4 = new JLabel("Celular:");
		lblNewLabel_4.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		JLabel textoExitoError = new JLabel("");
		textoExitoError.setHorizontalAlignment(SwingConstants.CENTER);
		textoExitoError.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		nombreTxt = new JTextField();
		nombreTxt.setColumns(10);
		nombreTxt.setText(controlador.getNombreCliente());
		
		rutTxt = new JTextField();
		rutTxt.setText(controlador.getRutCliente());
		rutTxt.setEditable(false);
		rutTxt.setColumns(10);
		
		direccionTxt = new JTextField();
		direccionTxt.setColumns(10);
		direccionTxt.setText(controlador.getDireccionCliente());
		
		celularTxt = new JTextField();
		celularTxt.setColumns(10);
		celularTxt.setText(controlador.getCelularCliente());
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlador.botonActualizar(nombreTxt.getText(), direccionTxt.getText(), celularTxt.getText())) {
					nombreTxt.setText(controlador.getNombreCliente());
					direccionTxt.setText(controlador.getDireccionCliente());
					celularTxt.setText(controlador.getCelularCliente());
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
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(btnNewButton_1)
							.addGap(18)
							.addComponent(textoExitoError, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(celularTxt, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
								.addComponent(direccionTxt, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
								.addComponent(rutTxt, 388, 388, 388)
								.addComponent(nombreTxt, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE))))
					.addGap(179))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(nombreTxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(rutTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(direccionTxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(celularTxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton)
						.addComponent(textoExitoError, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(64))
		);
		
		JLabel lblNewLabel = new JLabel("Editar Datos");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		panel.add(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
