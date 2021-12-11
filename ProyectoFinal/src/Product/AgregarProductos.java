package Product;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import IniciarSeccion.Real_login;
import ventana.login;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AgregarProductos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomProduct;
	private JTextField txtMarcProduct;
	private JTextField txtCateProduct;
	private JTextField txtPrecProduct;
	private JTextField txtStockProduct;

	public AgregarProductos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 390);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNomProduct = new JTextField();
		txtNomProduct.setBounds(158, 120, 112, 20);
		contentPane.add(txtNomProduct);
		txtNomProduct.setColumns(10);

		txtMarcProduct = new JTextField();
		txtMarcProduct.setBounds(158, 165, 112, 20);
		contentPane.add(txtMarcProduct);
		txtMarcProduct.setColumns(10);

		txtCateProduct = new JTextField();
		txtCateProduct.setBounds(158, 209, 112, 20);
		contentPane.add(txtCateProduct);
		txtCateProduct.setColumns(10);

		txtPrecProduct = new JTextField();
		txtPrecProduct.setBounds(158, 240, 112, 20);
		contentPane.add(txtPrecProduct);
		txtPrecProduct.setColumns(10);

		txtStockProduct = new JTextField();
		txtStockProduct.setBounds(158, 284, 112, 20);
		contentPane.add(txtStockProduct);
		txtStockProduct.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(62, 120, 72, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(62, 165, 72, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(62, 209, 86, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(62, 243, 72, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(62, 284, 86, 14);
		contentPane.add(lblNewLabel_4);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 11));
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(30, 144, 255));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarProductos();

			}
		});
		btnGuardar.setBounds(92, 315, 112, 23);
		contentPane.add(btnGuardar);

		JLabel lblNewLabel_5 = new JLabel("Registrar Productos");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_5.setBounds(143, 11, 187, 20);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Shagy\\Desktop\\descripcion-del-producto.png"));
		lblNewLabel_6.setBounds(184, 42, 86, 67);
		contentPane.add(lblNewLabel_6);

		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Productos frame1 = new Productos();
				frame1.setVisible(true);
				login frame = new login();
				Productos.Connect();
				Productos.table_load1();
			}
		});
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton.setBounds(234, 315, 112, 23);
		contentPane.add(btnNewButton);
	}

	protected void registrarProductos() {

		String Nombre, Marca, Categoria, Precio, Stock;

		Nombre = txtNomProduct.getText();
		Marca = txtMarcProduct.getText();
		Categoria = txtCateProduct.getText();
		Precio = txtPrecProduct.getText();
		Stock = txtStockProduct.getText();

		if (txtNomProduct.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " Llene todos los campos!!!!!");
		} else {

			if (txtCateProduct.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, " Llene todos los campos!!!!!");

			} else {
				if (txtPrecProduct.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, " Llene todos los campos!!!!!");

				} else {
					if (txtStockProduct.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " Llene todos los campos!!!!!");

					} else {

						try {

							login.pst = login.con.prepareStatement(
									"insert into Productos(Nombre,Marca,Categoria,Precio,Stock)values(?,?,?,?,?)");
							login.pst.setString(1, Nombre);
							login.pst.setString(2, Marca);
							login.pst.setString(3, Categoria);
							login.pst.setString(4, Precio);
							login.pst.setString(5, Stock);
							login.pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Producto agregado!!!!!");
							this.dispose();
							Productos frame1 = new Productos();
							frame1.setVisible(true);
							login frame = new login();
							Productos.Connect();
							Productos.table_load1();

						}

						catch (SQLException e1) {
							e1.printStackTrace();
						}

					}
				}
			}
		}
	}

	{

	}
	{

	}

}
