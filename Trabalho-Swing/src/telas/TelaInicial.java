package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Aplicacao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTempo = new JLabel("Tempo da Aplica\u00E7\u00E3o");
		lblTempo.setBounds(10, 35, 244, 13);
		contentPane.add(lblTempo);
		
		JRadioButton rdbtn3Meses = new JRadioButton("3 meses");
		rdbtn3Meses.setActionCommand("3");
		rdbtn3Meses.setBounds(6, 54, 248, 21);
		contentPane.add(rdbtn3Meses);
		
		JRadioButton rdbtn6Meses = new JRadioButton("6 meses");
		rdbtn6Meses.setActionCommand("6");
		rdbtn6Meses.setBounds(6, 77, 248, 21);
		contentPane.add(rdbtn6Meses);
		
		JRadioButton rdbtn9Meses = new JRadioButton("9 meses");
		rdbtn9Meses.setActionCommand("9");
		rdbtn9Meses.setBounds(6, 100, 248, 21);
		contentPane.add(rdbtn9Meses);
		
		JRadioButton rdbtn12Meses = new JRadioButton("12 meses");
		rdbtn12Meses.setActionCommand("12");
		rdbtn12Meses.setBounds(6, 123, 248, 21);
		contentPane.add(rdbtn12Meses);
		
		JRadioButton rdbtn18Meses = new JRadioButton("18 meses");
		rdbtn18Meses.setActionCommand("18");
		rdbtn18Meses.setBounds(6, 146, 248, 21);
		contentPane.add(rdbtn18Meses);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 173, 80, 13);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(6, 196, 248, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtn3Meses);
		group.add(rdbtn6Meses);
		group.add(rdbtn9Meses);
		group.add(rdbtn12Meses);
		group.add(rdbtn18Meses);
		
		JButton btnCalcular = new JButton("Calcular!");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valor = -1;
				boolean valido = true;
				
				try {
					valor = Double.parseDouble(
							txtValor.getText());
				} catch (Exception err) {
					valido = false;
				}
				
				if (valor < 0) valido = false;
				if (!valido) {
					JOptionPane.showMessageDialog(null, "Valor inválido!");
					return;
				}
				
				
				int opcao = Integer.parseInt(
						group.getSelection().getActionCommand());
				
				Calendar data = Calendar.getInstance();
				
				data.add(Calendar.MONTH, opcao);
				
				Aplicacao app = new Aplicacao(valor, data, opcao);
				app.calcular();
			}
		});
		btnCalcular.setBounds(6, 232, 248, 21);
		contentPane.add(btnCalcular);
	}
}
