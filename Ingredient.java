public class Ingredient 
{
	private int id;
	private String name;
	private String category;
	
	public Ingredient()
	{
		id = 0;
		name = "";
		category = "";
	}
	
	public Ingredient(int i, String n, String c )
	{
		this.id = i;
		this.name = n;
		this.category = c;
	}
	
	public Ingredient(String na, String ca)
	{
		id = 0;
		name = na;
		category = ca;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{	
		this.id;
	}
	
		public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public void setCategory(String category)
	{
		this.category;
	}
	
	public String toString()
	{
		String out = getId() + ": " + getName() +" ("+ getCategory() +") ";
		return out;
	}
}