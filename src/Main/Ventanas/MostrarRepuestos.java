package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Modulos.ModuloPrincipal;
import Controladores.ControladorVMostrarRepuestos;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarRepuestos {

	private JFrame frame;
	private JTextField filtro;
	private DefaultTableModel modelo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ModuloPrincipal modulo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarRepuestos window = new MostrarRepuestos(modulo);
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
	public MostrarRepuestos(ModuloPrincipal modulo) {
		initialize(modulo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ModuloPrincipal modulo) {
		ControladorVMostrarRepuestos controlador = new ControladorVMostrarRepuestos(modulo);
		frame = new JFrame();
		frame.setBounds(100, 100, 635, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		modelo = new DefaultTableModel();
		modelo = controlador.agregarDatoModel();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		
		JToolBar toolBar = new JToolBar();
		
		JToolBar toolBar_1 = new JToolBar();
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonVolver();
			}
		});
		
		JRadioButton id = new JRadioButton("Id");
		id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar_1.add(id);
		
		JRadioButton nombre = new JRadioButton("Nombre");
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar_1.add(nombre);
		
		nombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setSelected(false);
			}
		});
		
		id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre.setSelected(false);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!id.isSelected() && !nombre.isSelected()) {
					modelo = controlador.agregarDatoModel();
				}
				else {
					modelo = controlador.agregarDatoModel(id.isSelected(), nombre.isSelected(), filtro.getText());
				}
				table.setModel(modelo);
			}
		});
		
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
								.addComponent(btnNewButton)
								.addGap(32))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
									.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(218, Short.MAX_VALUE)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("Flitro:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolBar.add(lblNewLabel_1);
		
		filtro = new JTextField();
		toolBar.add(filtro);
		filtro.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Mostrar Repuestos");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 23));
		panel.add(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
