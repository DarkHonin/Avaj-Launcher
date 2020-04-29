package src._aircraft;
import src.Coordinates;
public class Aircraft {
	protected long	id;
	protected String	name;
	protected Coordinates coordinates;
	static private long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates){
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}

	private long nextId(){
		return idCounter++;
	}
}