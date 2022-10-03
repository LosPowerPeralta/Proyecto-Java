package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Locale;

import Modulos.ModuloPrincipal;
import Controladores.ControladorVMostrarOrdenesEmpleados;

public class MostrarOrdenesEmpleado {

	private JFrame frame;
	private JTable table;
	private JTextField filtro;
	private JTextField textId;
	private DefaultTableModel modelo;
	private JTextField nuevoEstado;
	private JTextField idEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ModuloPrincipal modulo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarOrdenesEmpleado window = new MostrarOrdenesEmpleado(modulo);
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
	public MostrarOrdenesEmpleado(ModuloPrincipal modulo) {
		initialize(modulo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ModuloPrincipal modulo) {
		ControladorVMostrarOrdenesEmpleados controlador = new ControladorVMostrarOrdenesEmpleados(modulo);
		frame = new JFrame();
		frame.setBounds(100, 100, 861, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		modelo = new DefaultTableModel();
		modelo = controlador.agregarDatoModel();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JToolBar toolBar = new JToolBar();
		
		JToolBar toolBar_1 = new JToolBar();
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				controlador.botonVolver();
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("Actualizar");
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
						.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(95)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))))
					.addGap(124))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 843, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(105, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(37))
		);
		
		JLabel lblNewLabel_5 = new JLabel("Cual orden deseas cambiar de estado?");
		lblNewLabel_5.setFont(new Font("Segoe Print", Font.PLAIN, 13));
		
		JLabel lblNewLabel_4 = new JLabel("Nuevo estado:");
		lblNewLabel_4.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		
		nuevoEstado = new JTextField();
		nuevoEstado.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Cambiar estado");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarEstado(Integer.parseInt(idEstado.getText()), nuevoEstado.getText());
				modelo = controlador.agregarDatoModel();
				table.setModel(modelo);
			}
		});
		btnNewButton_3.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3_1 = new JLabel("Id :");
		lblNewLabel_3_1.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		
		idEstado = new JTextField();
		idEstado.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_5))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(61)
							.addComponent(btnNewButton_3))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nuevoEstado, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(39)
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idEstado, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(idEstado, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(nuevoEstado, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_3)
					.addGap(21))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Que orden deseas eliminar?");
		lblNewLabel_2.setLocale(new Locale("es"));
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 13));
		
		textId = new JTextField();
		textId.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Id :");
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Filtro:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		toolBar.add(lblNewLabel_1);
		
		filtro = new JTextField();
		toolBar.add(filtro);
		filtro.setColumns(10);
		
		JRadioButton id = new JRadioButton("Id");
		id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar_1.add(id);
		
		JRadioButton dispositivo = new JRadioButton("Dispositivo");
		dispositivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar_1.add(dispositivo);
		
		JRadioButton cliente = new JRadioButton("Cliente");
		cliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar_1.add(cliente);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		
		id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispositivo.setSelected(false);
				cliente.setSelected(false);
			}
		});
		
		dispositivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setSelected(false);
				cliente.setSelected(false);
			}
		});
		
		cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispositivo.setSelected(false);
				id.setSelected(false);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try catch
				controlador.eliminarOrden(Integer.parseInt(textId.getText()));
				modelo = controlador.agregarDatoModel();
				table.setModel(modelo);
			}
		});
		btnNewButton_2.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!id.isSelected() && !dispositivo.isSelected() && !cliente.isSelected()) {
					modelo = controlador.agregarDatoModel();
				}
				else {
					modelo = controlador.agregarDatoModel(id.isSelected(), dispositivo.isSelected(), cliente.isSelected(), filtro.getText());
				}
				table.setModel(modelo);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Mostrar Ordenes");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 23));
		panel.add(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(99, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(81))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textId, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textId, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
		);
		panel_1.setLayout(gl_panel_1);
	}
}
