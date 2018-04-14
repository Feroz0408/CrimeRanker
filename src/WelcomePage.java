import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class WelcomePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCrimeRanker;
	private JTextField txtProjectBy;
	private JTextField txtFerozShaik;
	private JTextField txtSanyaKaur;
	private JTextField txtShashankReddy;
	private JTextField txtRaghunandhanaGodwa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
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
	public WelcomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Begin!!");
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 23));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StateDisplay state = new StateDisplay();
				state.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(245, 222, 179));
		btnNewButton.setForeground(SystemColor.infoText);
		btnNewButton.setBounds(419, 534, 272, 49);
		contentPane.add(btnNewButton);
		
		txtCrimeRanker = new JTextField();
		txtCrimeRanker.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 22));
		txtCrimeRanker.setForeground(Color.RED);
		txtCrimeRanker.setText("CRIME RANKER");
		txtCrimeRanker.setBounds(419, 97, 223, 26);
		contentPane.add(txtCrimeRanker);
		txtCrimeRanker.setColumns(10);
		
		txtProjectBy = new JTextField();
		txtProjectBy.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 16));
		txtProjectBy.setText("A Project by:");
		txtProjectBy.setBounds(205, 590, 102, 26);
		contentPane.add(txtProjectBy);
		txtProjectBy.setColumns(10);
		
		txtFerozShaik = new JTextField();
		txtFerozShaik.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 17));
		txtFerozShaik.setHorizontalAlignment(SwingConstants.CENTER);
		txtFerozShaik.setText("Feroz Shaik");
		txtFerozShaik.setBounds(158, 632, 95, 26);
		contentPane.add(txtFerozShaik);
		txtFerozShaik.setColumns(10);
		
		txtSanyaKaur = new JTextField();
		txtSanyaKaur.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 17));
		txtSanyaKaur.setHorizontalAlignment(SwingConstants.CENTER);
		txtSanyaKaur.setText("Sanya Kaur Gulati");
		txtSanyaKaur.setBounds(314, 632, 165, 26);
		contentPane.add(txtSanyaKaur);
		txtSanyaKaur.setColumns(10);
		
		txtShashankReddy = new JTextField();
		txtShashankReddy.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 17));
		txtShashankReddy.setHorizontalAlignment(SwingConstants.CENTER);
		txtShashankReddy.setText("Shashank Reddy");
		txtShashankReddy.setBounds(535, 632, 165, 26);
		contentPane.add(txtShashankReddy);
		txtShashankReddy.setColumns(10);
		
		txtRaghunandhanaGodwa = new JTextField();
		txtRaghunandhanaGodwa.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 17));
		txtRaghunandhanaGodwa.setHorizontalAlignment(SwingConstants.CENTER);
		txtRaghunandhanaGodwa.setText("Raghunandhana Godwa");
		txtRaghunandhanaGodwa.setBounds(753, 632, 180, 26);
		contentPane.add(txtRaghunandhanaGodwa);
		txtRaghunandhanaGodwa.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(SystemColor.infoText);
		lblNewLabel.setForeground(SystemColor.infoText);
		lblNewLabel.setIcon(new ImageIcon("crime.jpg"));
		lblNewLabel.setBounds(149, 0, 958, 676);
		contentPane.add(lblNewLabel);
	}
}
