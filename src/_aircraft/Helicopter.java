package src._aircraft;
import src.Coordinates;
import src.Flyable;
import src.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	WeatherTower weatherTower;

	public Helicopter(String name, Coordinates c) {
		super(name, c);
	}
	public void updateConditions(){
		String weather = weatherTower.getWeather(coordinates);
		int x = coordinates.getLongitude(), y = coordinates.getLatitude(), z = coordinates.getHeight();
		switch(weather){
			case "SUN":
				y += 10;
				z += 2;
				System.out.printf("%s : %s \n", this, "Chop Chop its sunny.");
				break;
			case "RAIN":
				y += 5;
				System.out.printf("%s : %s \n", this, "RAAAAAAIN.");
				break;
			case "FOG":
				x += 1;
				System.out.printf("%s : %s \n", this, "Is that you peter?");
				break;
			case "SNOW":
				z -= 12;
				System.out.printf("%s : %s \n", this, "Heck");
		};
		coordinates = new Coordinates(x, y, z);
		if(coordinates.getHeight() <= 0)
			weatherTower.unregister(this);
	}
	public void registerTower(WeatherTower weatherT){
		weatherTower = weatherT;
	}
	@Override
	public String toString() {
		return "Helicopter#"+name+"("+id+")";
	}
}