package test_new;

import java.awt.Color;

public class Car implements Comparable<Car> {
	String type;
	int maxSpeed;
	Color color;
	int cc;
	double consumption;
	int year;
		
	public Car(String type, int maxSpeed, Color color, int cc, double consumption, int year) {
		this.type = type;
		this.maxSpeed = maxSpeed;
		this.color = color;
		this.cc = cc;
		this.consumption = consumption;
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public double getConsumption() {
		return consumption;
	}

	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "brand: " + type + " maxspeed: " + maxSpeed + " Color: " + color +
				" cc: " + cc + " Consumption: " + consumption + " Year: " + year;
	}

	@Override
	public int compareTo(Car o) {
		return year-o.getYear();
	}
}
