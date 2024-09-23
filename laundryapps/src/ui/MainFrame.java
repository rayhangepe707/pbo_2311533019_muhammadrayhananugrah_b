package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**b
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				UserFrame frame = new UserFrame();
				frame.setVisible(true);
				frame.loadTable();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 402);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Laundry Apps");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setBounds(21, 26, 237, 63);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("PESANAN");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(31, 99, 134, 56);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LAYANAN");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(175, 99, 125, 56);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PELANGGAN");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(323, 99, 118, 56);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PENGGUNA");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBounds(32, 181, 133, 56);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("LAPORAN");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_4.setBounds(175, 181, 125, 56);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("PROFILE");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_5.setBounds(324, 181, 117, 56);
		getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("KELUAR");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_6.setBounds(31, 285, 411, 47);
		getContentPane().add(btnNewButton_6);
	}

}
