

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Recipe{


int id;
int time;
String name;

String[] Steps =[5];
int count=0;


    public Recipe(){
    
	
		setID(0);
		setName(test);
		setTime(0);
    
    }


    public Recipe(int id, String name, int time, String steps){
    
	
		setID(id);
		setName(name);
		setTime(time);
    
    }

	public void setID(int id){
		
		this.id=id;
		
		
	}
	
	
	public void setName(String name){
		
		this.name=name;
	}

	public void setTime(int Time){
		this.time=time;
	
	}

	public String addSteps(String Step){
		
		if(count<=5){
			
			return "Too many steps."
		
		}
		else if(Step.length()>200){
			return	"Too many characters in Step.";
		}
		
		else if(Step.length()<10){
			
			return "Not enough characters in Step.";
		}
		
		else if(specialCheck(step)==true){
			
			return "Step contains invalid characters";
		}
		
		else{
			
			Steps[count]=step;
			count++;
		}
		
	}
	
	
	
	
///////////////////////////////////////////////////	
	private boolean specialCheck(String step){
		
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(step);
		Boolean t=m.find();
		
		if(t){
			return true;
			
		}
		
		else{
			
			return false;
			
		}
		
		
	}





}