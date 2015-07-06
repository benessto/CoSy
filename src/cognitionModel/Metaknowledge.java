package cognitionModel;

import java.util.HashMap;

public class Metaknowledge {
	private static HashMap<String, String[]> data = new HashMap<String, String[]>();
	
	private static String[] animals = {"Dog", "Cat", "Mouse", "Fish", "Ape", "Elephant", "Lion", "Bear", "Penguine", "Snake", "Snail", "Bug", "Bee", "Wale", "Dolphin", "Duck", "Eagle", "Hatchhog", "Fox", "Echidna", "Chicken", "Cow", "Crocodile", "Pig", "Donkey", "Horse", "Sheep", "Goat", "Rabbit", "Frog", "Shark", "Monkey", "Wolf", "Deer", "Wesp", "Lynx", "Porcupine", "Bison", "Parrot", "Crow", "Squirrel", "Bat", "Spider", "Worm", "Crab", "Squidwart", "Ant", "Turkey", "Tiger", "Sloth"};
	private static String[] plants = {"Tree", "Bush", "Grass", "Flower", "Rose", "Appletree", "Lemontree", "Clover", "Weed", "Tulip", "Eucalyptus", "Acorn", "Fern", "Flachs", "Grapevine", "Moss", "Lavender", "Ambrosia", "Bamboo", "Birch", "Blackcap", "Cherrytree", "Palm", "Cress", "Daisy", "Fennel", "Mushroom", "Potato", "Carrot", "Lettuce", "Mapletree", "Strawberry", "Blackberry", "Oak", "Onion", "Pastnip", "Pineapple", "Rice", "Rosemary", "Silkweed", "Sugarcane", "Tea", "Thyne", "Violet", "Coffee", "Cacao", "Cotton", "Orangetree", "Laceflower", "Ivy"};
	private static String[] maschines = {"Computer", "Washmashine", "Dishwasher", "Freezer", "Smartphone", "Mobilephone", "Electricfan", "Car", "Cardreader", "Train", "Plane", "Camera", "Vendingmashine", "Lift", "Truck", "Television", "Toaster", "Coffeemashine", "Microwaveoven", "Oven", "Moneyprinter", "Printer", "Snackmaschine", "ATM", "Automaticdoor", "Pacemaker", "Slotmaschine", "Skilift", "Blender", "Radio", "Soundsystem", "Speaker", "Microphone", "Foodprocessor", "Projector", "Icecrusher", "Gameconsole", "Bulldozer", "Ship", "Crane", "Excevator", "Steamshovel", "sewing maschine", "Boiler", "Robot", "Rocket", "Spaceship", "Windturbine", "Mower", "Fax"};
	private static String[] films = {"The Holy Grail", "The Lord of the Ring", "Starwars", "Titanic", "Frozen", "Gone with the wind", "Casablance", "The Godfather", "Once upon a time in the West", "Jurassic Park", "Mad Max", "Priates of the Caribean", "Brave", "Highlander", "James Bond", "Murder on the Orient Express", "Indiana Jones", "Batman and Robin", "The Lion King", "The Hungergames", "Avangers", "Spiderman", "Antman", "Thor", "Matrix", "Life of Brian", "Aladdin", "Transformers", "Saw", "Texas Chainsaw Massacre", "Final Destination", "27 Dresses", "The Hobbit", "Tron", "Dracula", "Avatar", "King Kong", "Pixel", "Ben-Hur", "Conan the Barbar", "Narnia", "Harry Potter", "Eragon", "Finding Nemo", "Back to the Future", "Pulp Fiction", "Men in Black", "The green Mile", "Schindlers List", "Nightmare on Elmstreet"};
	private static String[] furniture = {"Table", "Chair", "Carpet", "Bed", "Door", "Couch", "Shelf", "Board", "Lamp", "Coffetable", "Window", "Flowerpot", "Vase", "Candelier", "Tapestry", "Desk", "Draw", "Cabinet", "Mirror", "Wardobe", "Toilett", "Shower", "Bookcase", "Bookshelf", "Dressingtable", "Bench", "Bathtube", "Wingchair", "Barstool", "Bar", "Wokrbench", "Washstand", "Nightstand", "Diningtable", "Candlestand", "Sink", "Floor lamp", "Towlehanger", "Curtains", "Reglet", "Pictureframe", "Showcase", "Pillow", "Fireplace", "Drawingboard", "Chest", "Boxes", "Sofa", "Clubchair", "Bar table"};
	
	public HashMap getData() {
		return data;
	}
	
	public static void printlenght(){
		System.out.println(animals.length + " " + plants.length + " " + maschines.length + " " + films.length + " " + furniture.length);
	}
}
