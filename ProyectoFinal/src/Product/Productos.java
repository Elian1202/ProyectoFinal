package Product;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import IniciarSeccion.Real_login;
import net.proteanit.sql.DbUtils;
import ventana.Pantalla_principal;
import ventana.login;
import Product.funcionProduct;

public class Productos extends JFrame {

	private JPanel contentPane;
	private static JTable table1;
	public static Connection con;
	public static PreparedStatement pst;
	public static ResultSet rs;

	public static void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/crud_productos", "elianm1202",
					"elianm1202");
		} catch (ClassNotFoundException ex) {

			System.out.println("no found");
			// ex.printStackTrace();

		} catch (SQLException ex) {
			// ex.printStackTrace();
			// JOptionPane.showMessageDialog(null, "Excelente!!!!!");
			System.out.println("si found");
		}

	}

	/**
	 * Create the frame.
	 */

	public static void table_load1() {
		try {
			pst = con.prepareStatement("select Nombre,Marca,Categoria,Precio,Stock from Productos");
			rs = pst.executeQuery();
			table1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Productos() {

		setBackground(Color.YELLOW);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 392);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Productos Almacenados");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(126, 21, 250, 23);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				mover();
			}
		});
		scrollPane.setBounds(10, 57, 446, 130);
		contentPane.add(scrollPane);

		table1 = new JTable();
		table1.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table1);

		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AgregarProductos frame = new AgregarProductos();
				frame.setVisible(true);
				login.Connect();
			}
		});
		btnNewButton.setBounds(10, 209, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Pantalla_principal frame = new Pantalla_principal();
				frame.setVisible(true);
				login.Connect();
			}
		});
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBounds(130, 209, 89, 23);
		contentPane.add(btnNewButton_1);

	}

	protected void mover() {

		int ts = table1.getSelectedRow();
		this.dispose();
		funcionProduct frame = new funcionProduct();
		frame.txtNombre.setText(table1.getValueAt(ts, 0).toString());
		frame.txtMarca.setText(table1.getValueAt(ts, 1).toString());
		frame.txtCategoria.setText(table1.getValueAt(ts, 2).toString());
		frame.txtPrecio.setText(table1.getValueAt(ts, 3).toString());
		frame.txtCantidad.setText(table1.getValueAt(ts, 4).toString());
		frame.setVisible(true);
		login.Connect();

	}
}
