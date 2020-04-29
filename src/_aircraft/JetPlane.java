package src._aircraft;
import src.Coordinates;
import src.Flyable;
import src.WeatherTower;

public class JetPlane extends Aircraft implements Flyable{
	WeatherTower weatherTower;
	public JetPlane(String name, Coordinates c){
		super(name, c);
	}
	public void updateConditions(){
		String weather = weatherTower.getWeather(coordinates);
		int x = coordinates.getLongitude(), y = coordinates.getLatitude(), z = coordinates.getHeight();
		switch(weather){
			case "SUN":
				y += 5;
				z += 2;
				System.out.printf("%s : %s\n", this, "NYOOOOOOOM");
				break;
			case "RAIN":
				y += 5;
				System.out.printf("%s : %s\n", this, "Whooosh...");
				break;
			case "FOG":
				y += 1;
				System.out.printf("%s : %s\n", this, "I am the cloud.");
				break;
			case "SNOW":
				System.out.printf("%s : %s\n", this, "Less whoosh...");
				z -= 7;
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
		return "JetPlane#"+name+"("+id+")";
	}
}