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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controladores.ControladorVRegistroCliente;
import Excepciones.ExistException;
import Modulos.ModuloPrincipal;

public class RegistroCliente {

	private JFrame frame;
	private JTextField nombre;
	private JTextField rut;
	private JTextField direccion;
	private JTextField celular;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ModuloPrincipal modulo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroCliente window = new RegistroCliente(modulo);
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
	public RegistroCliente(ModuloPrincipal modulo) {
		initialize(modulo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ModuloPrincipal modulo) {
		ControladorVRegistroCliente controlador = new ControladorVRegistroCliente(modulo);
		frame = new JFrame();
		frame.setBounds(100, 100, 551, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		nombre = new JTextField();
		nombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Rut:");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		rut = new JTextField();
		rut.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Dirección\r\n:");
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		direccion = new JTextField();
		direccion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Celular:");
		lblNewLabel_4.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		
		celular = new JTextField();
		celular.setColumns(10);
		
		JLabel texto = new JLabel("");
		texto.setFont(new Font("Segoe Print", Font.PLAIN, 17));
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!controlador.buscarUsuario(nombre.getText(), rut.getText())) {
						controlador.agregarUsuario(nombre.getText(), rut.getText(), direccion.getText(), celular.getText());
						texto.setText("Usuario agregado con éxito");
					}
					else {
						texto.setText("Usuario ya existe");
					}
				} catch (ExistException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe Script", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonVolver();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe Script", Font.PLAIN, 15));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(btnNewButton_1)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(texto, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
						.addComponent(rut, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
						.addComponent(celular, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
						.addComponent(direccion, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
					.addGap(251))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(225, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(rut, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(direccion, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(celular, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1)
						.addComponent(texto, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(25))
		);
		
		JLabel lblNewLabel = new JLabel("Registro\r\n");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 23));
		panel.add(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
