package entity;

import java.util.Stack;

public class Tower {
	
	Stack<Disk> disks;
	
	public Tower(Stack<Disk> disks) {
		this.disks = disks;
	}

	public Stack<Disk> getDisks() {
		return disks;
	}

	@Override
	public String toString() {
		return "Tower [disks=" + disks + "]";
	}
	
	
}
