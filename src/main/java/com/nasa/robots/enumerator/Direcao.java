package com.nasa.robots.enumerator;

public enum Direcao {
	NORTE(1),
	LESTE(2),
	SUL(3),
	OESTE(4);
	
	private int direcao;
	
	Direcao(int direcao){
		this.setDirecao(direcao);
	}

	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	public static Direcao fromValue(int value) throws IllegalArgumentException {
        try {
             return Direcao.values()[value-1];
        } catch(ArrayIndexOutOfBoundsException e) {
             throw new IllegalArgumentException("Unknown enum value :"+ value);
        }
    }
	
}
