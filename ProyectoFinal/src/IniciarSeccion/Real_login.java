package IniciarSeccion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Product.Productos;
import Registro.Registrar;
import ventana.Pantalla_principal;
import ventana.login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Real_login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Real_login frame = new Real_login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}**/

	/**
	 * Create the frame.
	 */
	public Real_login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 329);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(35, 125, 72, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(35, 161, 99, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(132, 125, 132, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnIniciar = new JButton("Iniciar Seccion");
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.setFont(new Font("Arial", Font.BOLD, 12));
		btnIniciar.setBackground(new Color(30, 144, 255));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnIniciar.setBounds(132, 199, 132, 23);
		contentPane.add(btnIniciar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setFont(new Font("Arial", Font.BOLD, 12));
		btnRegistrarse.setBackground(new Color(30, 144, 255));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registrar();
			}
		});
		btnRegistrarse.setBounds(132, 233, 132, 23);
		contentPane.add(btnRegistrarse);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(132, 161, 132, 20);
		contentPane.add(txtContraseña);
		
		JLabel lblNewLabel_2 = new JLabel("Iniciar Seccion");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(131, 11, 145, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Shagy\\Desktop\\perfil.png"));
		lblNewLabel_3.setBounds(154, 42, 72, 72);
		contentPane.add(lblNewLabel_3);
	}

	protected void Registrar() {
		this.dispose();
		login.Connect();
		Registrar frame = new Registrar();
		frame.setVisible(true);
	}

	protected void ingresar() {
		
		String usuario = txtUsuario.getText();
		String contraseña = String.valueOf(txtContraseña.getPassword());
		
		if(txtUsuario.getText().isEmpty() ){
			
			JOptionPane.showMessageDialog(contentPane, "Debe completar todos los datos", "Error",JOptionPane.ERROR_MESSAGE);

	}else {
		if(String.valueOf(txtContraseña.getPassword()).isEmpty()) {
			
			JOptionPane.showMessageDialog(contentPane, "Debe completar todos los datos", "Error",JOptionPane.ERROR_MESSAGE);
		}
		else {

			
			GestionUsuario gestionusuario = new GestionUsuario();
			
			Usuarios usuario2 = new Usuarios();
			usuario2.setUsuario(usuario);
			usuario2.setContraseña(contraseña);
			
			Usuarios usu = gestionusuario.obtenerUsuario(usuario2);
			
			if(usu != null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido "+ usuario);
			this.dispose();
			Pantalla_principal frame = new Pantalla_principal();
			frame.setVisible(true);
			login.Connect();
			login.table_load();
			}else
			{
				JOptionPane.showMessageDialog(contentPane, "Datos Invalidos", "Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}
	}
}

