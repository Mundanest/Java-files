/*
 * Phone — a model class representing a smart phone. A phone has a model name, a
 * screen size, and a battery capacity. */
public class Phone {
	private final String model;
	private final double screenSize;
	private final int batteryCapacity;
	
	public Phone(String model, double screenSize, int batteryCapacity) {
		// : Ensure the screenSize and batteryCapacity are positive
		// by throwing an IllegalArgumentException otherwise
		
		//TASK 1: 
		if (screenSize <0 || batteryCapacity <=0) {
			throw new IllegalArgumentException("Screen size and/or battery capacity must not be positive");
		}
		
		this.model = model;
		this.screenSize = screenSize;
		this.batteryCapacity = batteryCapacity;
	}

	 // Gets the phone's model name.
	public String getModel() {
		return model; 
	}
	
	 // Gets the phone's diagonal screen size (in inches).
	public double getScreenSize() {
		return screenSize;
	}
	
	 // Gets the phone's battery capacity (in mAh).
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	
	 /* Determines whether this phone "dominates" another phone, meaning
	 * this phone is better in one criterion, and at least as good in the
	 * other criterion. */
	
	public boolean dominates(Phone other) {
		// : implement this method
		// Task 2:
		return (this.getScreenSize() > other.getScreenSize() || 
				this.getBatteryCapacity() > other.getBatteryCapacity());
	}
}
