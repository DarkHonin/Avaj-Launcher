package src;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.RuntimeException;
import src._aircraft.AircraftFactory;

public class avaj_launcher {
	public static void main(String[] args){
		if(args.length < 1){
			System.err.println("The program requires the path of an appropriate scenario file. None provided");
			System.exit(-1);
		}
		String srcFile = args[0];
		System.out.println(srcFile);
		WeatherTower	tower = new WeatherTower();
		try{
			FileReader	fr = new FileReader(srcFile);
			Scanner fs = new Scanner(new BufferedReader(fr));
			int itterCount = fs.nextInt();
			System.out.println("System will itterate for " + String.valueOf(itterCount) + " cycles.");
			String line, type, name;
			int lo, la, h;
			AircraftFactory f = new AircraftFactory();
			while(fs.hasNext()){
				line = fs.nextLine();
				Scanner ls = new Scanner(line);
				if(!ls.hasNext()) continue;
				type = ls.next();
				name = ls.next();
				if(!ls.hasNextInt()){
					ls.close();
					throw new RuntimeException("Unexpected end of line... expected int");
				}
				lo = ls.nextInt();
				la = ls.nextInt();
				h = ls.nextInt();
				Flyable e = f.createAircraft(type, name, lo, la, h);
				if(e == null) continue;
				tower.register(e);

			}
			for(int x = 0; x < itterCount; x++)
				tower.changeWeather();
		}catch(FileNotFoundException ex){
			System.err.println("Could not read the file provided");
		}catch(RuntimeException ex){
			System.err.printf("An exception has occured: %s\n", ex.getMessage());
			ex.printStackTrace();
		}
	};
}