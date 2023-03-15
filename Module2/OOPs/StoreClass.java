import java.util.*; 

class Store{
    private String name;
    private String address;

    public Store(String theName, String theAddress)
    {
        this.name = theName;
        this.address = theAddress;
    }

    // write your code here
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setName(String name)
	{
		this.name=name;
	}

    public String toString() { return this.name  + " : " + this.address; }

} 

public class Main{ 

     public static void main(String[] args){
      
        Store myStore = new Store("Barb Store", "333 Main St.");
        System.out.println(myStore);
        myStore.setName("Barbara Store");
        myStore.setAddress("555 Pine St.");
        System.out.println(myStore);

    }
}
