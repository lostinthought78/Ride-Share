
public class Recipe {
	
	private String name;
	
	public Recipe() {
		this.name = "Demo";
		
				
	}
	
	public void setName(String name) throws Exception {
		if(name.length()>10)
		{
			throw new Exception("101: Name too long. Must be 2-10 characters");
		}
		this.name = name;
		
	}
	
	public String getName()
	{
		return this.name;
	}

}
