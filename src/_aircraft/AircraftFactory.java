package src._aircraft;
import src.Coordinates;
import src.Flyable;

public class AircraftFactory{
	public Flyable	createAircraft(String t, String name, int longitude, int latitude, int height){
		Coordinates c = new Coordinates(longitude, latitude, height);
		switch(t){
			case "Baloon":
				return new Baloon(name, c);
			case "JetPlane":
				return new JetPlane(name, c);
			case "Helicopter":
				return new Helicopter(name, c);
		};
		return null;
	}
}