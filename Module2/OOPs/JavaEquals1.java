class Dog
{
    private String name;

    public Dog(String name)
    {
        this.name = name;
    }

    public boolean equals(Dog other)
    {
        // ADD CODE HERE
		String name1=this.name;
		String name2=other.name;
		if(name1.length()!=name2.length())
		{
			return false;
		}
		else
		{
			for(int i=0;i<name1.length();i++)
			{
				if(name1.charAt(i)!=name2.charAt(i))
				{
					return false;
				}
			}
			return true;
		}
    }

}
public class Main{
    public static void main(String[] args)
    {
        Dog d1 = new Dog("Rufus");
        Dog d2 = new Dog("Sally");
        Dog d3 = new Dog("Rufus");
        Dog d4 = d3;
        System.out.println(d1.equals(d2));
        System.out.println(d2.equals(d3));
        System.out.println(d1.equals(d3));
        System.out.println(d3.equals(d4));
    }
}
