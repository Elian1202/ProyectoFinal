package Registro;

import java.awt.BorderLayout;
import ventana.login;
import java.awt.EventQueue;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import IniciarSeccion.Real_login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Registrar extends JFrame {

	private JPanel contentPane;
	private JTextField txtRnombre;
	private JTextField txtRapellido;
	private JTextField txtRemail;
	private JTextField txtRtelefono;
	private JTextField txtRusuario;
	private JTextField txtRcontraseña;
	private JTextField txtConfirContraseña;
	 



	/**
	 * Create the frame.
	 */
	public Registrar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 452);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(44, 128, 75, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(44, 195, 75, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(44, 220, 75, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Usuario");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(44, 248, 75, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(44, 276, 75, 14);
		contentPane.add(lblNewLabel_4);

		JLabel txt1 = new JLabel("Confirmar Contrase\u00F1a");
		txt1.setFont(new Font("Arial", Font.BOLD, 12));
		txt1.setBounds(44, 307, 157, 14);
		contentPane.add(txt1);

		JLabel lblNewLabel_6 = new JLabel("Apellido");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(44, 164, 75, 14);
		contentPane.add(lblNewLabel_6);

		txtRnombre = new JTextField();
		txtRnombre.setBounds(173, 122, 130, 20);
		contentPane.add(txtRnombre);
		txtRnombre.setColumns(10);

		txtRapellido = new JTextField();
		txtRapellido.setBounds(173, 158, 130, 20);
		contentPane.add(txtRapellido);
		txtRapellido.setColumns(10);

		txtRemail = new JTextField();
		txtRemail.setBounds(173, 189, 130, 20);
		contentPane.add(txtRemail);
		txtRemail.setColumns(10);

		txtRtelefono = new JTextField();
		txtRtelefono.setBounds(173, 217, 130, 20);
		contentPane.add(txtRtelefono);
		txtRtelefono.setColumns(10);

		txtRusuario = new JTextField();
		txtRusuario.setBounds(173, 245, 130, 20);
		contentPane.add(txtRusuario);
		txtRusuario.setColumns(10);

		txtRcontraseña = new JTextField();
		txtRcontraseña.setBounds(173, 273, 130, 20);
		contentPane.add(txtRcontraseña);
		txtRcontraseña.setColumns(10);

		txtConfirContraseña = new JTextField();
		txtConfirContraseña.setBounds(173, 304, 130, 20);
		contentPane.add(txtConfirContraseña);
		txtConfirContraseña.setColumns(10);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GuardarRegistro();
			}
		});
		btnNewButton.setBounds(159, 345, 163, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Iniciar Seccion");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IniciarLogin();
			}
		});
		btnNewButton_1.setBounds(159, 379, 163, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_7 = new JLabel("Registrarse");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_7.setBounds(192, 11, 130, 34);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Shagy\\Desktop\\perfil.png"));
		lblNewLabel_5.setBounds(195, 44, 88, 64);
		contentPane.add(lblNewLabel_5);
	}

	protected void IniciarLogin() {
		this.dispose();
		Real_login frame1 = new Real_login();
		frame1.setVisible(true);
		login frame = new login();
		login.Connect();
	}

	protected void GuardarRegistro() {

		String Nombre, Apellido, Email, Telefono, Usuario, Contraseña, ConfirmarContraseña;

		Nombre = txtRnombre.getText();
		Apellido = txtRapellido.getText();
		Email = txtRemail.getText();
		Telefono = txtRtelefono.getText();
		Usuario = txtRusuario.getText();
		Contraseña = txtRcontraseña.getText();
		ConfirmarContraseña = txtConfirContraseña.getText();

		if (txtRusuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " Llene todos los campos!!!!!");
		} else {

			if (txtRapellido.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, " Llene todos los campos!!!!!");

			} else {
				if (txtRemail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, " Llene todos los campos!!!!!");

				} else {
					if (txtRtelefono.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " Llene todos los campos!!!!!");

					} else {
						if (txtRusuario.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, " Llene todos los campos!!!!!");

						} else {
							if (txtRcontraseña.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, " Llene todos los campos!!!!!");

							} else {
								if (Contraseña.equals(ConfirmarContraseña)) {
									
									try {

										login.pst = login.con.prepareStatement(
												"insert into Usuarios(Nombre,Apellido,Usuario,Email,Contraseña,Telefono)values(?,?,?,?,?,?)");
										login.pst.setString(1, Nombre);
										login.pst.setString(2, Apellido);
										login.pst.setString(3, Usuario);
										login.pst.setString(4, Email);
										login.pst.setString(5, Contraseña);
										login.pst.setString(6, Telefono);
										login.pst.executeUpdate();
										JOptionPane.showMessageDialog(null, "Usuario agregado!!!!!");
										this.dispose();
										Real_login frame1 = new Real_login();
										frame1.setVisible(true);
										login frame = new login();
										login.Connect();

									}

									catch (SQLException e1) {
										e1.printStackTrace();
									}

								} else {
									JOptionPane.showMessageDialog(null, " La contraseña nos coinciden!!!!!");
									

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
		}

	}
}
