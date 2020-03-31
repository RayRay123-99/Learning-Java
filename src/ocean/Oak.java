package ocean;
// This is a subclass of plant for the purposes of Public_Private_Protected 

public class Oak extends Plant{
	public Oak() {
		/* Even though Oak is a child class of Plant, it can't access the private variables:
		 * type = "tree"; - won't work because type is a private variable 
		 */
			
		this.size = "Medium"; // This will work because size is a subclass/child class of the original class (it is protected)
		this.height = 10;
	}
}
