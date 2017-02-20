package com.softserve.train;

public abstract class ACar {
	private double maxSpeed;

	// Overload
	public ACar() {
	}

	// Overload
	public ACar(double maxSpeed) {
		this.maxSpeed = maxSpeed;
		System.out.println("ACar: Constructor ");
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	abstract void carRides();
}
