package logic;

import java.util.Stack;

import entity.Disk;
import entity.Tower;

public class Game {
	
	private static final int NUMBER_OF_DISKS = 64;
	private static Tower tower1;
	private static Tower tower2;
	private static Tower tower3;
	
	public static void init() {
		
		Stack<Disk> disks = new Stack<>();
		
		for(int i = 64; i > 0; i--){
			disks.add(new Disk(i));
		}
		tower1 = new Tower(disks);
		tower2 = new Tower(new Stack<>());
		tower3 = new Tower(new Stack<>());
		
		System.out.println("Ready to play!");
	}
	
	public static void move(Tower fromTower, Tower toTower){
		if(isValid(fromTower, toTower))	{
			Disk diskToMove = fromTower.getDisks().pop();
			toTower.getDisks().push(diskToMove);
			System.out.println("The disk is moved successfully.");
		}
		else{
			System.out.println("Invalid movement!");
		}
	}
	
	public static boolean isValid(Tower fromTower, Tower toTower){
		return(!(fromTower == toTower || fromTower.getDisks().isEmpty() || (!toTower.getDisks().isEmpty() && fromTower.getDisks().peek().getSize() > toTower.getDisks().size())));
	}

	public boolean isEndGame(Tower tower1, Tower tower2, Tower tower3){
		 return (tower1.getDisks().size()==0)&&(tower2.getDisks().size()==0)&&(tower3.getDisks().size()==NUMBER_OF_DISKS);
	}
	
	public static void main(String[] args) {
		init();
		System.out.println(tower1.getDisks().size());
		System.out.println(tower2.getDisks().size());
		System.out.println(tower3.getDisks().size());
		move(tower1, tower2);
		System.out.println(tower1.getDisks().size());
		System.out.println(tower2.getDisks().size());
		System.out.println(tower3.getDisks().size());
		move(tower2, tower3);
		System.out.println(tower1.getDisks().size());
		System.out.println(tower2.getDisks().size());
		System.out.println(tower3.getDisks().size());
	}
}
