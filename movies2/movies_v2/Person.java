package movies_v2;

class Person
{
	// variables:
	String firstName;
	String lastName;
	Gender gender;
	Boolean hasOscar;
	Boolean hasGoldenGlobe;
	int salary;
	
	// getter functions:
	
	public int getSalary() {
		return salary;
	}


	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public Gender getGender()
	{
		return gender;
	}
	
	
	//setter functions:
	public void setFirstName(String a){
		firstName = a;
	}
	
	public void setLastName(String b){
		lastName = b;
	}
	
	public void setGender(Gender c){
		gender = c;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
}

