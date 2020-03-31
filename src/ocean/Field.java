package ocean;
// This is for the purposes of learning Public_Private_Protected

public class Field {
	private Plant plant1 = new Plant();
	
	public Field() {
		// size is protected and field is in the same package as plant, hence the code below works
		System.out.println(plant1.size);
		// This won't work in another package (like the default package)
		System.out.println(plant1.height);
	}
}
