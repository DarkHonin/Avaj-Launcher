package src._aircraft;

import src.Flyable;
import src.WeatherTower;
import src.Coordinates;
import src.WeatherProvider;

public class Baloon extends Aircraft implements Flyable{
	WeatherTower weatherTower;
	public Baloon(String name, Coordinates c){
		super(name, c);
	}
	@Override
	public void updateConditions(){
		String weather = weatherTower.getWeather(coordinates);
		int x = coordinates.getLongitude(), y = coordinates.getLatitude(), z = coordinates.getHeight();
		switch(weather){
			case "SUN":
				x += 2;
				z += 4;
				System.out.printf("%s : %s\n", this, "Let it simmer.");
				break;
			case "RAIN":
				z -= 5;
				System.out.printf("%s : %s\n", this, "Well thats no good for this braai.");
				break;
			case "FOG":
				System.out.printf("%s : %s\n", this, "I cant see my chops.");
				z -= 3;
				break;
			case "SNOW":
				z -= 15;
				System.out.printf("%s : %s\n", this, "There goes the neiberhood.");
		};
		coordinates = new Coordinates(x, y, z);
		if(coordinates.getHeight() <= 0)
			weatherTower.unregister(this);
	}
	@Override
	public void registerTower(WeatherTower weatherT){
		weatherTower = weatherT;
	}

	@Override
	public String toString() {
		return "Baloon#"+name+"("+id+")";
	}
}