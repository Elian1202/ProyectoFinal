package Product;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ventana.login;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class funcionProduct extends JFrame {

	private JPanel contentPane;
	JTextField txtNombre;
	JTextField txtMarca;
	JTextField txtPrecio;
	JTextField txtCantidad;
	JTextField txtCategoria;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnSalir;
	private JLabel lblNewLabel_6;


	public funcionProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 403);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(129, 124, 123, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(129, 155, 123, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(129, 228, 123, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(129, 273, 123, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(129, 197, 123, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(30, 144, 255));
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 11));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarYguardar();
			}
		});
		btnGuardar.setBounds(26, 316, 89, 23);
		contentPane.add(btnGuardar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(30, 144, 255));
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarProducto();
			}
		});
		btnEliminar.setBounds(137, 316, 89, 23);
		contentPane.add(btnEliminar);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(40, 124, 75, 20);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(40, 155, 75, 20);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(40, 197, 93, 20);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(40, 228, 63, 20);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(40, 273, 75, 20);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Modificar Productos");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_5.setBounds(103, 11, 203, 29);
		contentPane.add(lblNewLabel_5);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(30, 144, 255));
		btnSalir.setFont(new Font("Arial", Font.BOLD, 11));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salir();
			}
		});
		btnSalir.setBounds(262, 316, 89, 23);
		contentPane.add(btnSalir);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Shagy\\Desktop\\diseno-de-producto.png"));
		lblNewLabel_6.setBounds(151, 39, 75, 74);
		contentPane.add(lblNewLabel_6);
	}


	protected void Salir() {
		dispose();
		Productos frame = new Productos();
		frame.setVisible(true);
		login.Connect();
		Productos.table_load1();
		
	}


	protected void EliminarProducto() {

		String eliminar;

		eliminar = txtNombre.getText();

		try {
			Productos.pst = Productos.con.prepareStatement("delete from Productos where Nombre =?");
			Productos.pst.setString(1, eliminar);
			Productos.pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Producto Eliminado !!!!!");
			dispose();
			Productos frame = new Productos();
			frame.setVisible(true);
			login.Connect();
			Productos.table_load1();
		
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}


	protected void EditarYguardar() {

		String  Enombre, Emarca, Ecategoria, Eprecio, Ecantidad;

		Enombre = txtNombre.getText();
		Emarca = txtMarca.getText();
		Ecantidad = txtCantidad.getText();
		Ecategoria = txtCategoria.getText();
		Eprecio = txtPrecio.getText();

		try {
			Productos.pst = Productos.con.prepareStatement(
					"update Productos set Nombre= ?,Marca= ?,Categoria= ?,Precio= ?,Stock= ? where Nombre = ?");
			Productos.pst.setString(1, Enombre);
			Productos.pst.setString(2, Emarca);
			Productos.pst.setString(3, Ecategoria);
			Productos.pst.setString(4, Eprecio);
			Productos.pst.setString(5, Ecantidad);
			Productos.pst.setString(6, Enombre);
			Productos.pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Producto editado !!!!!");
			dispose();
			Productos frame = new Productos();
			frame.setVisible(true);
			login.Connect();
			Productos.table_load1();

			
		} catch (SQLException e1) {
			
			JOptionPane.showMessageDialog(null, "Error al editar !!!!!");
			e1.printStackTrace();
		}
		
	}
}
