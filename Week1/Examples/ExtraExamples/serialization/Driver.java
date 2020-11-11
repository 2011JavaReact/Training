package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Driver {

	ArrayList<Cereal> cereals = new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println("START");
		Driver driver = new Driver();
//		driver.createCerealDB();
		try {
//			driver.serializeCereal();
			driver.deserializeCereal();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.readDB();
		System.out.println("END");
		
		

	}
	
	public void addCereal(String name, float price) {
		cereals.add(new Cereal(name,price));
	}
	
	public void createCerealDB() {
		Cereal c1 = new Cereal("Count Dracu-choc", 4.99f);
		Cereal c2 = new Cereal("Frankum Cherry", 2.95f);
		Cereal c3 = new Cereal("Rice Pops", 15.99f);
		Cereal c4 = new Cereal("Cereal", 1.00f);
		Cereal c5 = new Cereal("For Loops", 4.00f);
		
		cereals = new ArrayList<>();
		cereals.add(c1);
		cereals.add(c2);
		cereals.add(c3);
		cereals.add(c4);
		cereals.add(c5);
		
	}
	
	public void readDB() {
		System.out.println(cereals);
	}
	
	public void serializeCereal() throws IOException {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("files/cereals.seriously"));
			oos.writeObject(cereals);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(oos!=null) {
				oos.close();
			}
		}
	}
	
	public void deserializeCereal() throws IOException {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("files/cereals.seriously"));
			cereals = (ArrayList<Cereal>)ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ois.close();
		}
	}

}
