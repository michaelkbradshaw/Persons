package person.person;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Person {
	
	
	String fName;
	String lName;
	int age;
	
	
	public Person(String fName, String lName, int age) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}
	
	
	public Person()
	{
		this("John","Doe",0);
	}


	/**
	 * @return the fName
	 */
	public String getFName() {
		return fName;
	}


	/**
	 * @param fName the fName to set
	 */
	public void setFName(String fName) {
		this.fName = fName;
	}


	/**
	 * @return the lName
	 */
	public String getLName() {
		return lName;
	}


	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	public void storeToFile()
	{
	
		XMLEncoder encoder=null;
		try{
		encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("PersonStorage.xml")));
		encoder.writeObject(this);
		encoder.close();
		}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File dvd.xml");
		}
	}
	
	private static Person readFromFile() 
	{
		XMLDecoder decoder=null;
		Person p = null;
		try {
			decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("PersonStorage.xml")));
			p = (Person) decoder.readObject();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File dvd.xml not found");
		}
		return p;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", age=" + age + "]";
	}


	public static void main(String[] args)
	{
		Person p = new Person("Killry","Doe",35);
		p.storeToFile();
		
		
		Person q = Person.readFromFile();
		System.out.println(q);
	}


	

}
