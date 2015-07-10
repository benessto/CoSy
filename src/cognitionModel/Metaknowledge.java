package cognitionModel;

import java.util.HashMap;
import java.util.Random;

public class Metaknowledge {
	private static HashMap<String, String[]> data = new HashMap<String, String[]>();
	
	private static String[] animal = {"Dog", "Cat", "Mouse", "Fish", "Ape", "Elephant", "Lion", "Bear", "Penguin", "Snake", "Snail", "Bug", "Bee", "Wale", "Dolphin", "Duck", "Eagle", "Hedgehog", "Fox", "Echidna", "Chicken", "Cow", "Crocodile", "Pig", "Donkey", "Horse", "Sheep", "Goat", "Rabbit", "Frog", "Shark", "Monkey", "Wolf", "Deer", "Wesp", "Lynx", "Porcupine", "Bison", "Parrot", "Crow", "Squirrel", "Bat", "Spider", "Worm", "Crab", "Squid", "Ant", "Turkey", "Tiger", "Sloth"};
	private static String[] plant = {"Tree", "Bush", "Grass", "Flower", "Rose", "Appletree", "Lemontree", "Clover", "Weed", "Tulip", "Eucalyptus", "Acorn", "Fern", "Flachs", "Grapevine", "Moss", "Lavender", "Ambrosia", "Bamboo", "Birch", "Blackcap", "Cherrytree", "Palm", "Cress", "Daisy", "Fennel", "Mushroom", "Potato", "Carrot", "Lettuce", "Mapletree", "Strawberry", "Blackberry", "Oak", "Onion", "Pastnip", "Pineapple", "Rice", "Rosemary", "Silkweed", "Sugarcane", "Tea", "Thyne", "Violet", "Coffee", "Cacao", "Cotton", "Orangetree", "Laceflower", "Ivy"};

	private static String[] machine = {"Computer", "Washmachine", "Dishwasher", "Freezer", "Smartphone", "Mobile Phone", "Electric Fan", "Car", "Cardreader", "Train", "Plane", "Camera", "Vendingmachine", "Lift", "Truck", "Television", "Toaster", "Coffeemachine", "Microwave", "Oven", "Moneyprinter", "Printer", "Snackmashine", "ATM", "Automatic Door", "Pacemaker", "Slotmachine", "Skilift", "Blender", "Radio", "Soundsystem", "Speaker", "Microphone", "Foodprocessor", "Projector", "Icecrusher", "Gameconsole", "Bulldozer", "Ship", "Crane", "Excavator", "Steamshovel", "Sewing Machine", "Boiler", "Robot", "Rocket", "Spaceship", "Windturbine", "Mower", "Fax"};
	private static String[] film = {"The Holy Grail", "The Lord of the Rings", "Star Wars", "Titanic", "Frozen", "Gone with the Wind", "Casablanca", "The Godfather", "Once upon a time in the West", "Jurassic Park", "Mad Max", "Pirates of the Caribbean", "Brave", "Highlander", "James Bond", "Murder on the Orient Express", "Indiana Jones", "Batman and Robin", "The Lion King", "The Hunger Games", "Avengers", "Spiderman", "Antman", "Thor", "Matrix", "Life of Brian", "Aladdin", "Transformers", "Saw", "Texas Chainsaw Massacre", "Final Destination", "27 Dresses", "The Hobbit", "Tron", "Dracula", "Avatar", "King Kong", "Pixel", "Ben-Hur", "Conan the Barbarian", "Narnia", "Harry Potter", "Eragon", "Finding Nemo", "Back to the Future", "Pulp Fiction", "Men in Black", "The Green Mile", "Schindlers List", "Nightmare on Elmstreet"};
	private static String[] furniture = {"Table", "Chair", "Carpet", "Bed", "Door", "Couch", "Shelf", "Board", "Lamp", "Coffetable", "Window", "Flowerpot", "Vase", "Candelier", "Tapestry", "Desk", "Drawer", "Cabinet", "Mirror", "Wardobe", "Toilet", "Shower", "Bookcase", "Bookshelf", "Dressingtable", "Bench", "Bathtube", "Wingchair", "Barstool", "Bar", "Wokrbench", "Washstand", "Nightstand", "Diningtable", "Candlestand", "Sink", "Floor lamp", "Towelhanger", "Curtains", "Reglet", "Pictureframe", "Showcase", "Pillow", "Fireplace", "Drawingboard", "Chest", "Boxes", "Sofa", "Clubchair", "Bar table"};
			
	public static HashMap<String, String[]> getData() {

		return data;
	}
	
	public static void printlenght(){
		System.out.println(animal.length + " " + plant.length + " " + machine.length + " " + film.length + " " + furniture.length);
	}
	
	public static void initializeHash() {
		data.put("animal", animal);
		data.put("plant", plant);
		data.put("machine", machine);
		data.put("film", film);
		data.put("furniture", furniture);
	}
	
	public static String getRandomWord() {
		Random randomGenerator = new Random();
		int category = randomGenerator.nextInt(5);
		String word = null;
		switch (category) {
		case 0:
				return word = animal[randomGenerator.nextInt(animal.length)];
		case 1:
				return word = plant[randomGenerator.nextInt(plant.length)];
		case 2:
				return word = machine[randomGenerator.nextInt(machine.length)];
		case 3:
				return word = film[randomGenerator.nextInt(film.length)];
		case 4:
				return word = furniture[randomGenerator.nextInt(furniture.length)];
		}
		
		return word;
	}
}
