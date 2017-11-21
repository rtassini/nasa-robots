package com.nasa.robots.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.robots.enumerator.Direcao;
import com.nasa.robots.exception.ForaTerrenoException;
import com.nasa.robots.exception.InstrucaoInvalidaException;
import com.nasa.robots.model.Robot;




@RestController
public class MarsController {

	private static final String LEFT = "L";
	private static final String RIGHT = "R";
	private static final String MOVE = "M";
	
	private static final int MOVER_DIREITA = 1;
	private static final int MOVER_ESQUERDA = -1;
	
	private static final int TAMANHO_EIXO_X = 5;
	private static final int TAMANHO_EIXO_Y = 5;
	

    @RequestMapping("/rest/mars/{instruction}")
    public String instrucao(@PathVariable("instruction") String instruction) throws Exception {
        Robot robot = new Robot();
        
        
        List<String> coordenadas = Arrays.asList(instruction.split(""));
        
		validarInstrucoes(coordenadas);
		
		calcularInstrucoes(coordenadas, robot);
		
		validarTerreno(robot);
		
    	return robot.getPosicao();
    }
    
    public void validarTerreno(Robot robot) {
		if(robot.getX() > TAMANHO_EIXO_X)
			throw new ForaTerrenoException();
		
		if(robot.getY() > TAMANHO_EIXO_Y)
			throw new ForaTerrenoException();
	}

	public void validarInstrucoes(List<String> coordenadas) throws Exception {
    	List<String> instrucoesValidas = new ArrayList<String>();
    	String[] instrucoes = new String[] {"L", "R", "M"};
    	instrucoesValidas = Arrays.asList(instrucoes);
    	for (String coordenada : coordenadas) {
			if(!instrucoesValidas.contains(coordenada))
				throw new InstrucaoInvalidaException();
		}
		
	}

	public void calcularInstrucoes(List<String> coordenadas, Robot robot){
		for (String coordenada : coordenadas) {
			switch (coordenada) {
				case LEFT:
					mudarDirecao(robot, MOVER_ESQUERDA);
					break;
				
				case RIGHT:
					mudarDirecao(robot, MOVER_DIREITA);
					break;	
					
				case MOVE:
					moverSubmarino(robot);
					break;
					
				default:
					break;
			}
		}
	}

	private void mudarDirecao(Robot robot, int mover) {
		if(robot.getDirecao() == Direcao.NORTE.getDirecao() && mover == MOVER_ESQUERDA){
			robot.setDirecao(Direcao.OESTE.getDirecao());
		}else if(robot.getDirecao() == Direcao.OESTE.getDirecao() && mover == MOVER_DIREITA){
			robot.setDirecao(Direcao.NORTE.getDirecao());
		}else{
			robot.setDirecao(robot.getDirecao() + mover);
		}
	}

	private void moverSubmarino(Robot robot) {
		if(robot.getDirecao() == Direcao.OESTE.getDirecao()){
			robot.setX(robot.getX()+1);
		}else if(robot.getDirecao() == Direcao.LESTE.getDirecao()){
			robot.setX(robot.getX()+1);
		}else if(robot.getDirecao() == Direcao.NORTE.getDirecao()){
			robot.setY(robot.getY()+1);
		}else if(robot.getDirecao() == Direcao.SUL.getDirecao()){
			robot.setY(robot.getY()-1);
		}
	}
	
	
}
