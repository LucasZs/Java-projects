class Person
{
	// variables:
	String firstName;
	String lastName;
	Gender gender;
	Boolean hasOscar;
	Boolean hasGoldenGlobe;
	
	// getter functions:
	
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
	
	public boolean getHasOscar()
	{
		return hasOscar;
	}
	
	public boolean getHasGoldenGlobe()
	{
		return hasGoldenGlobe;
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
	
	public void setHasOscar(boolean d){
		hasOscar = d;
	}
	
	public void setHasGoldenGlobe(boolean e){
		hasGoldenGlobe = e;
	}
	
	//method:
	public String toXMLString() {
		String retStr = "";
		retStr += Tools.toXMLTag("firstName", firstName);
		retStr += Tools.toXMLTag("lastName", lastName);
		retStr += Tools.toXMLTag("gender", gender.toString());
		retStr += Tools.toXMLTag("hasOscar", hasOscar.toString());
		retStr += Tools.toXMLTag("hasGoldenGlobe", hasGoldenGlobe.toString());
		return Tools.toXMLTag("person", retStr);
	}
}
