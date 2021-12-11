package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import IniciarSeccion.Real_login;
import Product.Productos;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla_principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla_principal frame = new Pantalla_principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public Pantalla_principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 326);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login frame = new login();
				frame.setVisible(true);
				login.Connect();
				login.table_load();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Shagy\\Desktop\\usuario (2).png"));
		btnNewButton.setBounds(49, 128, 159, 137);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Productos frame = new Productos();
				frame.setVisible(true);
				Productos.Connect();
				Productos.table_load1();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Shagy\\Desktop\\caja.png"));
		btnNewButton_1.setBounds(218, 128, 164, 137);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Gestion Usuario");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(62, 101, 147, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Productos Almacenados");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(218, 101, 206, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Cerrar Seccion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Usted a Cerrado Seccion");
				dispose();
				Real_login frame1 = new Real_login();
				frame1.setVisible(true);
				login frame = new login();
				login.Connect();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_2.setBackground(new Color(30, 144, 255));
		btnNewButton_2.setBounds(322, 56, 137, 34);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Pantalla Principal");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(145, 21, 219, 25);
		contentPane.add(lblNewLabel_2);
	}

}
