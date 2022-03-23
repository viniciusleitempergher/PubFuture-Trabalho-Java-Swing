package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import telas.TelaFinal;

public class Aplicacao {
	private double valor;
	private Calendar dataTermino;
	private int meses;
	private int dias;
	
	public Aplicacao(double valor, Calendar dataTermino, int meses) {
		this.valor = valor;
		this.dataTermino = dataTermino;
		this.meses = meses;
	}
	
	/**
	 * Faz os cálculos da poupança, CDB, LCI e dias úteis;
	 * Abre a tela final passando os resultados dos cálculos
	 */
	public void calcular() {
		int diasUteis = diasUteisAte(dataTermino);
		
		double taxaPoupanca = 0.005;
		double taxaCDI = 0.1165 / 12;
		
		double montantePoupanca = valor * Math.pow((1 + taxaPoupanca), meses);
		double montanteCDI = valor * Math.pow((1 + taxaCDI), meses);
		
		double rendimentoPoupanca = montantePoupanca - valor;
		double rendimentoCDI = montanteCDI - valor;
		
		double impostoRendaCDB;
		
		if (meses <= 6) {
			impostoRendaCDB = 0.225;
		} else if (meses <= 12) {
			impostoRendaCDB = 0.2;
		} else if (meses <= 24) {
			impostoRendaCDB = 0.175;
		} else {
			impostoRendaCDB = 0.15;
		}
		
		double valorImpostoCDB = rendimentoCDI * impostoRendaCDB;
		
		TelaFinal tela = new TelaFinal(dias, diasUteis,
				valor, rendimentoPoupanca, rendimentoCDI, valorImpostoCDB);
		tela.setVisible(true);
	}
	
	/**
	 * Retorna quantos dias úteis existem entre agora e a data informada
	 * @param data - a data limite
	 * @return int - a quantidade de dias úteis até a data especificada
	 */
	private int diasUteisAte(Calendar data) {
		int contagem = 0;
		dias = 0;
		
		Calendar dataAtual = Calendar.getInstance();
		
		while (dataAtual.before(data)) {
			if (diaUtil(dataAtual)) contagem++;
			dias++;
			dataAtual.add(Calendar.DATE, 1);
		}
		
		return contagem;
	}
	
	/**
	 * Retorna se a data passada como parâmetro é um dia útil ou não
	 * @param data - a data a ser verificada
	 * @return boolean - true se for um dia útil, false caso não
	 */
	private boolean diaUtil(Calendar data) {
		// Verificar se é um sábado
		if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			return false;
		}
		
		// Verificar se é um domingo
		if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return false;
		}
		
		// Verificar se é um feriado
		for (Calendar c : datasFeriados()) {
			if (data.get(Calendar.MONTH) == c.get(Calendar.MONTH)
					&& data.get(Calendar.DATE) == c.get(Calendar.DATE)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Retorna um array com todos os feriados ao longo do ano
	 */
	private ArrayList<Calendar> datasFeriados() {
		ArrayList<Calendar> feriados = new ArrayList<>();
		
		feriados.add(new GregorianCalendar(0, 0, 1));
		feriados.add(new GregorianCalendar(0, 1, 20));
		feriados.add(new GregorianCalendar(0, 1, 21));
		feriados.add(new GregorianCalendar(0, 3, 15));
		feriados.add(new GregorianCalendar(0, 3, 21));
		feriados.add(new GregorianCalendar(0, 4, 1));
		feriados.add(new GregorianCalendar(0, 5, 16));
		feriados.add(new GregorianCalendar(0, 8, 7));
		feriados.add(new GregorianCalendar(0, 9, 12));
		feriados.add(new GregorianCalendar(0, 10, 2));
		feriados.add(new GregorianCalendar(0, 10, 15));
		feriados.add(new GregorianCalendar(0, 11, 25));
		
		return feriados;
	}
}
