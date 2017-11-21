package com.nasa.robots.model;

import com.nasa.robots.enumerator.Direcao;

public class Robot {

	private int x;
	private int y;
	private int direcao;
	
	public Robot(){
		this.x = 0;
		this.y = 0;
		this.direcao = Direcao.NORTE.getDirecao();
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	public String getPosicao() {
		return this.getX() + " " + this.getY() + " " +  Direcao.fromValue(direcao);
	}
	
	@Override
	public String toString() {
		return "Robô [x=" + x + ", y=" + y + ", direcao=" + Direcao.fromValue(direcao) + "]";
	} 
}
