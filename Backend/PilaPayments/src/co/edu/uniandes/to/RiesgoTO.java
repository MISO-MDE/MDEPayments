package co.edu.uniandes.to;

import java.util.Set;

import co.edu.uniandes.entity.ActividadEconomica;

public class RiesgoTO {
	
	/**
	 * id del riesgo
	 */
	private Long id;
	
	/**
	 * Codigo del riesgo
	 */
	private int claseRiesgo;
	
	/**
	 * Valor inicial para el calculo
	 */
	private double valorInicial;
	
	/**
	 * Actividades economicas asociadas al riesgo
	 */
	private Set<ActividadEconomica> actividadesEconomicas;
	
	public RiesgoTO() {
		
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the claseRiesgo
	 */
	public int getClaseRiesgo() {
		return claseRiesgo;
	}

	/**
	 * @param claseRiesgo the claseRiesgo to set
	 */
	public void setClaseRiesgo(int claseRiesgo) {
		this.claseRiesgo = claseRiesgo;
	}

	/**
	 * @return the valorInicial
	 */
	public double getValorInicial() {
		return valorInicial;
	}

	/**
	 * @param valorInicial the valorInicial to set
	 */
	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}

	/**
	 * @return the actividadesEconomicas
	 */
	public Set<ActividadEconomica> getActividadesEconomicas() {
		return actividadesEconomicas;
	}

	/**
	 * @param actividadesEconomicas the actividadesEconomicas to set
	 */
	public void setActividadesEconomicas(Set<ActividadEconomica> actividadesEconomicas) {
		this.actividadesEconomicas = actividadesEconomicas;
	}
}
