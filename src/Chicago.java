import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Chicago extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chicago frame = new Chicago();
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
	public Chicago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1308, 735);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Murders");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(960, 196, 156, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 18));
		textField.setBounds(1131, 190, 112, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Thefts");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(960, 280, 139, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Assaults");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(960, 361, 139, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rapes");
		lblNewLabel_3.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(960, 461, 124, 20);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 18));
		textField_1.setBounds(1131, 277, 112, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 18));
		textField_2.setBounds(1131, 358, 112, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 18));
		textField_3.setBounds(1131, 458, 112, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		Training train = new Training();
		ArrayList<Integer> results = new ArrayList<Integer>();
		results = train.Train(41.881832, -87.623177);
		
		textField.setText(String.valueOf(results.get(0))+"%");
		textField_1.setText(String.valueOf(results.get(1))+"%");
		textField_2.setText(String.valueOf(results.get(2))+"%");
		textField_3.setText(String.valueOf(results.get(3))+"%");
	
	lblNewLabel_5 = new JLabel("Chicago Crime Rate!!!");
	lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_5.setFont(new Font("Snap ITC", Font.ITALIC, 25));
	lblNewLabel_5.setForeground(Color.WHITE);
	lblNewLabel_5.setBounds(887, 108, 356, 55);
	contentPane.add(lblNewLabel_5);
	
	JButton btnNewButton = new JButton("Click here to try other States!");
	btnNewButton.setBackground(new Color(245, 222, 179));
	btnNewButton.setFont(new Font("Ravie", Font.BOLD | Font.ITALIC, 19));
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			StateDisplay state = new StateDisplay();
			state.setVisible(true);
		}
		
		
	});
	btnNewButton.setForeground(Color.BLACK);
	btnNewButton.setBounds(15, 587, 491, 55);
	contentPane.add(btnNewButton);
	
	JLabel lblNewLabel_4 = new JLabel("New label");
	lblNewLabel_4.setIcon(new ImageIcon("USA.gif"));
	lblNewLabel_4.setBounds(-11, 0, 1117, 586);
	contentPane.add(lblNewLabel_4);
	}
}
