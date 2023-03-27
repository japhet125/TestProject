package Passenger;

public class Airplane {
	private Passenger[] passengers;
	private String airplaneName;
	private int numPassengers;
	     public Airplane() {
	    	 passengers = new Passenger[100];
	    	 airplaneName= "";
	    	 numPassengers=0;
	     }
	     public Airplane(String n) {
	    	 airplaneName= n;
	     }
	     public Airplane (int maxPassengers) {
	    	 maxPassengers= maxPassengers<0?
	    	 maxPassengers:0;
	    	 passengers= new Passenger[100];
	    			 
	     }
	    
		/**
		 * @return the passengers
		 */
		public Passenger[] getPassengers() {
			return passengers;
		}
		/**
		 * @param passengers the passengers to set
		 */
		public void setPassengers(Passenger[] passengers) {
			this.passengers = passengers;
		}
		/**
		 * @return the airplaneName
		 */
		public String getAirplaneName() {
			return airplaneName;
		}
		/**
		 * @param airplaneName the airplaneName to set
		 */
		public void setAirplaneName(String airplaneName) {
			this.airplaneName = airplaneName;
		}
		/**
		 * @return the numPassengers
		 */
		public int getNumPassengers() {
			return numPassengers;
		}
		public void addPassenger(Passenger a) {
			for (int i=0; i<this.passengers.length; i++)
			{
				if (this.passengers[i]==null) {
					this.passengers[i]=a;
					this.numPassengers= this.numPassengers+1;
					break;
					
				}
			}
		}
		public Passenger getPassenger(int index) {
			return this.passengers[index]!=null?
					this.passengers[index]:null;
			
		}
		public Passenger getFirstPassenger() {
			return this.passengers[this.numPassengers-1];
		
		}
	public Passenger removePassenger(int index) {
		if (this.passengers[index]!= null) {
			this.passengers[index]= null;
			this.numPassengers= this.numPassengers -1;
			return this.passengers[index];
		}else {
			return null;
		}
	}
	public void removeAllPassengers() {
		this.passengers= new Passenger[0];
		this.numPassengers=0;
	}

	public double getTotalWeightOfAllPassengers() {
		double weight =0.0;
		for (int i=0; i<this.passengers.length; i++) {
			if(this.passengers[i] !=null) {
				weight= weight + this.passengers[i].getWeight();
				}
		}
		return weight;
	}
	public double getAverageWeightOfAllPassengers() {
		return getTotalWeightOfAllPassengers()/this.numPassengers ;
		
	}
	public int getNumberOPassengersAboveWeight(double weight) {
		int total=0;
		for(int i=0; i<this.passengers.length; i++) {
			if(this.passengers[i].getWeight()>weight)
				total=total+1;
		}

	return total;
	}
	public void increaseWeightOfAllPassengers() {
		for (int i=0; i<this.passengers.length; i++)
		{
			if (this.passengers[i]!=null) {
				this.passengers[i].gainWeight();
			}
		}
	}
	public void increaseWeightOfAllPassengers(double weight) {
		for(int i=0; i<this.passengers.length; i++) {
			if(this.passengers[i]!=null)
				this.passengers[i].gainWeight(weight);
			
		}
	}

	public void printAllDetails() {
	 System.out.printf("AirplaneName: %20s|Number of Passengers: %4d| Airplane Size:%4d\n", this.airplaneName,this.numPassengers,this.passengers.length);
	}
		/**
		 * 
		 * @param numPassengers the numPassengers to set
		 */
		public void setNumPassengers(int numPassengers) {
			this.numPassengers = numPassengers;
		}
		
	
	}


