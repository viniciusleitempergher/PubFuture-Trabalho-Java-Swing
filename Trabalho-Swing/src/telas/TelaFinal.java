package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JLabel;
import java.awt.Font;

public class TelaFinal extends JFrame {

	private JPanel contentPane;
	
	private Locale ptBr = new Locale("pt", "BR");
	private NumberFormat rsf = NumberFormat.getCurrencyInstance(ptBr);
	
	/**
	 * Create the frame.
	 */
	public TelaFinal(int diasCorridos, int diasUteis, double valorInicial, 
			double rendimentoPoupanca, double rendimentoCDI, double impostoCDB) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 860, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Poupan\u00E7a:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(10, 101, 193, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dias Corridos");
		lblNewLabel_1.setBounds(10, 10, 87, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dias \u00DAteis");
		lblNewLabel_2.setBounds(10, 33, 87, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Valor Inicial:");
		lblNewLabel_3.setBounds(10, 56, 87, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Lucros:");
		lblNewLabel_4.setBounds(10, 124, 87, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Montante:");
		lblNewLabel_5.setBounds(10, 147, 87, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblLucrosPoupanca = new JLabel("0");
		lblLucrosPoupanca.setBounds(107, 124, 96, 13);
		contentPane.add(lblLucrosPoupanca);
		
		JLabel lblMontantePoupanca = new JLabel("0");
		lblMontantePoupanca.setBounds(107, 147, 96, 13);
		contentPane.add(lblMontantePoupanca);
		
		JLabel lblMontanteLCI = new JLabel("0");
		lblMontanteLCI.setBounds(310, 147, 96, 13);
		contentPane.add(lblMontanteLCI);
		
		JLabel lblLucrosLCI = new JLabel("0");
		lblLucrosLCI.setBounds(310, 124, 96, 13);
		contentPane.add(lblLucrosLCI);
		
		JLabel lblNewLabel_4_1 = new JLabel("Lucros:");
		lblNewLabel_4_1.setBounds(213, 124, 87, 13);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Montante:");
		lblNewLabel_5_1.setBounds(213, 147, 87, 13);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblLci = new JLabel("LCI:");
		lblLci.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLci.setBounds(213, 101, 193, 13);
		contentPane.add(lblLci);
		
		JLabel lblMontanteCDB = new JLabel("0");
		lblMontanteCDB.setBounds(513, 170, 96, 13);
		contentPane.add(lblMontanteCDB);
		
		JLabel lblLucrosCDB = new JLabel("0");
		lblLucrosCDB.setBounds(513, 124, 96, 13);
		contentPane.add(lblLucrosCDB);
		
		JLabel lblNewLabel_4_2 = new JLabel("Lucros:");
		lblNewLabel_4_2.setBounds(416, 124, 87, 13);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5_2 = new JLabel("Montante:");
		lblNewLabel_5_2.setBounds(416, 170, 87, 13);
		contentPane.add(lblNewLabel_5_2);
		
		JLabel lblCdb = new JLabel("CDB:");
		lblCdb.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCdb.setBounds(416, 101, 193, 13);
		contentPane.add(lblCdb);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Impostos:");
		lblNewLabel_5_2_1.setBounds(416, 147, 87, 13);
		contentPane.add(lblNewLabel_5_2_1);
		
		JLabel lblImpostosCDB = new JLabel("0");
		lblImpostosCDB.setBounds(513, 147, 96, 13);
		contentPane.add(lblImpostosCDB);
		
		JLabel lblDiasCorridos = new JLabel("0");
		lblDiasCorridos.setBounds(107, 10, 125, 13);
		contentPane.add(lblDiasCorridos);
		
		JLabel lblDiasUteis = new JLabel("0");
		lblDiasUteis.setBounds(107, 33, 125, 13);
		contentPane.add(lblDiasUteis);
		
		JLabel lblValorInicial = new JLabel("0");
		lblValorInicial.setBounds(107, 56, 125, 13);
		contentPane.add(lblValorInicial);
		
		// Atualizar os valores
		lblDiasCorridos.setText(diasCorridos + "");
		lblDiasUteis.setText(diasUteis + "");
		lblValorInicial.setText(rsf.format(valorInicial) + "");
		
		lblLucrosPoupanca.setText(rsf.format(rendimentoPoupanca) + "");
		lblMontantePoupanca.setText(rsf.format(valorInicial + rendimentoPoupanca) + "");
		
		lblLucrosLCI.setText(rsf.format(rendimentoCDI) + "");
		lblMontanteLCI.setText(rsf.format(rendimentoCDI + valorInicial) + "");
		
		lblLucrosCDB.setText(rsf.format(rendimentoCDI - impostoCDB) + "");
		lblImpostosCDB.setText(rsf.format(impostoCDB) + "");
		lblMontanteCDB.setText(rsf.format(valorInicial + rendimentoCDI - impostoCDB) + "");
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(valorInicial + rendimentoPoupanca, "Poupança", "");
		dataset.setValue(rendimentoCDI + valorInicial, "LCI", "");
		dataset.setValue(valorInicial + rendimentoCDI - impostoCDB, "CDB", "");
		
		JFreeChart barChart = ChartFactory.createBarChart("Comparação de Aplicações",
				"", "Montante", dataset);
		
		ChartPanel chartPanel= new ChartPanel(barChart);
		chartPanel.setBounds(10, 218, 826, 398);
		contentPane.add(chartPanel);

	}
}
