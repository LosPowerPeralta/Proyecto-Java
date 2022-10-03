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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import Controladores.ControladorVBuscarPorCriterio;
import Excepciones.ConvertException;
import Modulos.ModuloPrincipal;

public class BusquedaPorCriterio {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel modelo;
	private JTextField filtro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ModuloPrincipal modulo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaPorCriterio window = new BusquedaPorCriterio(modulo);
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
	public BusquedaPorCriterio(ModuloPrincipal modulo) {
		initialize(modulo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ModuloPrincipal modulo) {
		ControladorVBuscarPorCriterio controlador = new ControladorVBuscarPorCriterio(modulo);
		frame = new JFrame();
		frame.setBounds(100, 100, 722, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		modelo = new DefaultTableModel();
		modelo = controlador.agregarDatoModel();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JToolBar toolBar = new JToolBar();
		
		JToolBar toolBar_1 = new JToolBar();
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonVolver();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JLabel name = new JLabel("Filtro:");
		name.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		toolBar_1.add(name);
		
		filtro = new JTextField();
		toolBar_1.add(filtro);
		filtro.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		toolBar.add(lblNewLabel_1);
		
		JRadioButton busquedaId = new JRadioButton("Id");
		busquedaId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar.add(busquedaId);
		
		
		JRadioButton busquedaDispositivo = new JRadioButton("Dispositivo");
		busquedaDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar.add(busquedaDispositivo);
		
		JRadioButton busquedaEmpleado = new JRadioButton("Empleado");
		busquedaEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar.add(busquedaEmpleado);
		
		busquedaId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busquedaDispositivo.setSelected(false);
				busquedaEmpleado.setSelected(false);
			}
		});
		
		busquedaDispositivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busquedaId.setSelected(false);
				busquedaEmpleado.setSelected(false);
			}
		});
		
		busquedaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busquedaId.setSelected(false);
				busquedaDispositivo.setSelected(false);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 13));
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!busquedaId.isSelected() && !busquedaDispositivo.isSelected() && !busquedaEmpleado.isSelected()) {
					modelo = controlador.agregarDatoModel();
				}
				else {
					try {
						modelo = controlador.agregarDatoModel(busquedaId.isSelected(), busquedaDispositivo.isSelected(), busquedaEmpleado.isSelected(), filtro.getText());
					} catch (ConvertException e1) {
						lblNewLabel_2.setText("Id debe ser un numero.");
					}
				}
				table.setModel(modelo);
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Buscar Orden");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 28));
		panel.add(lblNewLabel);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
							.addGap(124)
							.addComponent(lblNewLabel_2))
						.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(208, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(90, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED, 432, Short.MAX_VALUE)
							.addComponent(btnNewButton)))
					.addGap(50))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		frame.getContentPane().setLayout(groupLayout);
	}

}
