package stBernards;

public class DogInfo {

	private String regNumber;
	private String name;
	private String gender;
	private String whelpDate;
	private DogInfo sire;
	private DogInfo dam;
	private DogList pups;
	

		
	
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getWhelpDate() {
		return whelpDate;
	}
	public void setWhelpDate(String whelpDate) {
		this.whelpDate = whelpDate;
	}
	public DogInfo getSire() {
		if(sire != null){
			return sire;
		}else{
			return null;
		}
	}
	public DogInfo (){
		pups = new DogList();
	}
	public void setSire(DogInfo dog) {

			
		this.sire = dog;
	}

	public DogInfo getDam() {
		if(dam != null){
			return dam;
		}else{
			return null;
		}
	}
	public void setDam(DogInfo dog) {

	this.dam = dog;
}
	public DogList getPups() {
		return pups;
	}
	public void setPups(DogList pups) {
		this.pups = pups;
	}
	public String toString(){
		String theDog = getName() + " " + getRegNumber();
		return theDog;
		
	}
}