package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Controladores.ControladorVAsignarRepuestos;
import Modulos.ModuloPrincipal;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class AsignarRepuestos {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel modelo;
	private JTextField filtro;
	private JTextField textId;
	private JTextField monitor;
	private JTextField placaMadre;
	private JTextField procesador;
	private JTextField ram;
	private JTextField bateria;
	private JTextField ssd;
	private JTextField discoDuro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ModuloPrincipal modulo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsignarRepuestos window = new AsignarRepuestos(modulo);
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
	public AsignarRepuestos(ModuloPrincipal modulo) {
		initialize(modulo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ModuloPrincipal modulo) {
		ControladorVAsignarRepuestos controlador = new ControladorVAsignarRepuestos(modulo);
		frame = new JFrame();
		frame.setBounds(100, 100, 828, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		modelo = new DefaultTableModel();
		modelo = controlador.agregarDatosModel();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		
		JToolBar toolBar = new JToolBar();
		
		JToolBar toolBar_1 = new JToolBar();
		
		JPanel panel_1 = new JPanel();
		
		JButton btnNewButton_1 = new JButton("Actualizar");
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonVolver();
			}
		});
		btnNewButton_2.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_2)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, 0, 0, Short.MAX_VALUE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("A que orden le deseas asiganar");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("Repuestos?");
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JLabel lblNewLabel_4 = new JLabel("Id:");
		lblNewLabel_4.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		textId = new JTextField();
		textId.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Monitor:");
		lblNewLabel_5.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		monitor = new JTextField();
		monitor.setText("0");
		monitor.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Repuestos");
		lblNewLabel_6.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JLabel lblNewLabel_7 = new JLabel("Placa Madre:");
		lblNewLabel_7.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		placaMadre = new JTextField();
		placaMadre.setText("0");
		placaMadre.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Procesador:");
		lblNewLabel_8.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		procesador = new JTextField();
		procesador.setText("0");
		procesador.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Ram:");
		lblNewLabel_9.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		ram = new JTextField();
		ram.setText("0");
		ram.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Bateria:");
		lblNewLabel_10.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		bateria = new JTextField();
		bateria.setText("0");
		bateria.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("SSD:");
		lblNewLabel_11.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		ssd = new JTextField();
		ssd.setText("0");
		ssd.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Disco Duro:");
		lblNewLabel_12.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		discoDuro = new JTextField();
		discoDuro.setText("0");
		discoDuro.setColumns(10);
		
		JLabel textoExitoError = new JLabel("");
		textoExitoError.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("Asignar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(controlador.botonAsignar(Integer.parseInt(textId.getText()), Integer.parseInt(monitor.getText()), Integer.parseInt(placaMadre.getText()), 
							Integer.parseInt(procesador.getText()), Integer.parseInt(bateria.getText()), Integer.parseInt(discoDuro.getText()), 
							Integer.parseInt(ssd.getText()), Integer.parseInt(ram.getText()))) {
						textoExitoError.setText("Asignado con éxito");
					}
					else {
						textoExitoError.setText("Error al asignar");
					}
				}
				catch(NumberFormatException e1) {
					textoExitoError.setText("Hay Valores Nulos");
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 13));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(110)
							.addComponent(lblNewLabel_3))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(monitor, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addGap(41)
									.addComponent(lblNewLabel_11)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(ssd, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_8)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(procesador, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_10)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bateria, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_12)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(discoDuro, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_7)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(placaMadre, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_9)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(ram, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(textoExitoError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(39)
										.addComponent(btnNewButton))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblNewLabel_4)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textId, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(106)
							.addComponent(lblNewLabel_6)))
					.addGap(34))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(textId, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(monitor, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_11)
						.addComponent(ssd, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(placaMadre, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9)
						.addComponent(ram, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(procesador, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_10)
						.addComponent(bateria, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_12)
						.addComponent(discoDuro, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(textoExitoError, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblNewLabel_1 = new JLabel("Filtro:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolBar.add(lblNewLabel_1);
		
		filtro = new JTextField();
		toolBar.add(filtro);
		filtro.setColumns(10);
		
		JRadioButton botonId = new JRadioButton("Id");
		botonId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar_1.add(botonId);
		
		JRadioButton botonDispositivo = new JRadioButton("Dispositivo");
		botonDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar_1.add(botonDispositivo);
		
		botonId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonDispositivo.setSelected(false);
			}
		});
		
		botonDispositivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonId.setSelected(false);
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!botonId.isSelected() && !botonDispositivo.isSelected()) {
					modelo = controlador.agregarDatosModel();
				}
				else {
					modelo = controlador.agregarDatosModel(botonId.isSelected(), botonDispositivo.isSelected(), filtro.getText());
				}
				table.setModel(modelo);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Asignar Repuestos");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 23));
		panel.add(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
		panel_1.setLayout(gl_panel_1);
	}
}
