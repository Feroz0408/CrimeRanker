import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Nyc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtNewYorkCrime;
	private JButton btnClickToTry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nyc frame = new Nyc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Nyc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1284, 755);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 20));
		textField.setBounds(1138, 187, 96, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 20));
		textField_1.setBounds(1138, 276, 96, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 20));
		textField_2.setBounds(1138, 376, 96, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 20));
		textField_3.setBounds(1138, 464, 96, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Murders");
		lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(945, 190, 152, 20);
		contentPane.add(lblNewLabel);
		
		Training train = new Training();
		ArrayList<Integer> results = new ArrayList<Integer>();
		results = train.Train(40.730610,-73.935242);
		
		textField.setText(String.valueOf(results.get(0))+"%");
		textField_1.setText(String.valueOf(results.get(1))+"%");
		textField_2.setText(String.valueOf(results.get(2))+"%");
		textField_3.setText(String.valueOf(results.get(3))+"%");
		
		lblNewLabel_1 = new JLabel("Rapes");
		lblNewLabel_1.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(945, 467, 117, 20);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Thefts");
		lblNewLabel_2.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(945, 279, 117, 20);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Assaults");
		lblNewLabel_3.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(945, 379, 166, 23);
		contentPane.add(lblNewLabel_3);
		
		txtNewYorkCrime = new JTextField();
		txtNewYorkCrime.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewYorkCrime.setFont(new Font("Snap ITC", Font.ITALIC, 18));
		txtNewYorkCrime.setText("New York Crime Ranks");
		txtNewYorkCrime.setBounds(945, 74, 302, 48);
		contentPane.add(txtNewYorkCrime);
		txtNewYorkCrime.setColumns(10);
		
		btnClickToTry = new JButton("Click to try other states!");
		btnClickToTry.setFont(new Font("Ravie", Font.BOLD | Font.ITALIC, 19));
		btnClickToTry.setBackground(new Color(255, 239, 213));
		btnClickToTry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StateDisplay state = new StateDisplay();
				state.setVisible(true);
			}
		});
		btnClickToTry.setForeground(Color.BLACK);
		btnClickToTry.setBounds(15, 624, 452, 59);
		contentPane.add(btnClickToTry);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setIcon(new ImageIcon("USA.gif"));
		lblNewLabel_4.setBounds(0, 0, 1277, 683);
		contentPane.add(lblNewLabel_4);
	}
}
