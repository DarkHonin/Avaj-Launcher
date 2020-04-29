package src;

import src.WeatherProvider;

public class WeatherTower extends Tower{

	public void register(Flyable flyable){
		super.register(flyable);
		flyable.registerTower(this);
	}
	public String getWeather(Coordinates c){
		return WeatherProvider.getProvider().getCurrentWeather(c);
	}
	void changeWeather(){
		super.conditionsChanged();
	}

}