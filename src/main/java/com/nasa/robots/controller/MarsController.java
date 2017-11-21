package com.nasa.robots.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.robots.enumerator.Direcao;
import com.nasa.robots.model.Robot;


@RestController
public class MarsController {

	private static final char LEFT = 'L';
	private static final char RIGHT = 'R';
	private static final char MOVE = 'M';
	
	private static final int MOVER_DIREITA = 1;
	private static final int MOVER_ESQUERDA = -1;

    @RequestMapping("/rest/mars/{instruction}")
    public Robot instrucao(@PathVariable("instruction") String instruction) {
        Robot robot = new Robot();
        
        char[] coordenadas = new char[instruction.length()];
		coordenadas = instruction.toCharArray();
        
		calcularInstrucoes(coordenadas, robot);
		
    	return robot;
    }
    
    public void calcularInstrucoes(char[] coordenadas, Robot robot){
		for (char coordenada : coordenadas) {
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
