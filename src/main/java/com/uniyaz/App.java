package com.uniyaz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App 
{	
	
 	static List<Person> personList = new ArrayList<Person>();
 	static Integer personCounter = 0;
 	
    public static void main( String[] args )
    {        
    	Scanner scanner = new Scanner(System.in);
    	boolean cikis = true;
    	while(cikis) {
        	
        	System.out.println("İşlem kodunu seçiniz: ");
        	System.out.println("1.Kişi Ekleme");
        	System.out.println("2.Kişi Silme");
        	System.out.println("3.Kişileri Listele");
        	System.out.println("4.Kişileri Ara");
        	System.out.println("5.Çıkış");
        	    	
        	int choice = scanner.nextInt();
        
        	switch(choice) {
       
        	case 1: {
        		addPerson();
        		break;
        	}
        	case 2: {
        		deletePerson();
        		break;	
        	}        	
        	case 3: {
        		listPerson(personList);
        		break;
        	}        	
        	case 4: {
        		searchPerson();
        		break;
        	}        	
        	case 5: {
        		cikis = false;
        		break;
        	}
        	default: break;
    	}
    }	
    	
   }
	
	private static void addPerson() {
		
		Person person = new Person();
		String name, surname;
		String phone;
		System.out.println("Ad, Soyad ve Telefon numarası giriniz: ");
		personCounter++;
		Scanner scanner = new Scanner(System.in);
		
		name = scanner.nextLine();
		surname = scanner.nextLine();
		phone = scanner.nextLine();
		
		person.setId(personCounter);
		person.setName(name);
		person.setSurname(surname);
		person.setPhone(phone);

		if(personList.add(person)) {
			System.out.println("Kayıt Eklendi");
		}
	}
	
	private static void deletePerson() {
		
		int id;
		int index = 0;
		listPerson(personList);
		System.out.println("Silmek istediğiniz kaydın ID'sini giriniz: ");
		Scanner scanner = new Scanner(System.in);
		id = scanner.nextInt();
		for (Person person : personList) {
			if(id == person.getId()) {
				index = personList.indexOf(person);
			}
		}
		
		personList.remove(index);		
		listPerson(personList);

	}

	private static void listPerson(List<Person> personList) {
		System.out.println("Id\t\tİsim\t\tSoyad\t\tTel\t\t");
		for (Person person : personList) {
			System.out.println(person.getId() + "\t\t" + person.getName() + "\t\t" + person.getSurname() + "\t\t" + person.getPhone());
		}
		
	}

	private static void searchPerson() {
		
		Scanner scanner=new Scanner(System.in);
        System.out.println("Aranacak Kelimeyi Söyleyin");
        String arancakKelime=scanner.next();
        Iterator<Person> kisiIterator=personList.listIterator();
        List<Person> sonuclar=new ArrayList<>();
        while (kisiIterator.hasNext()){
 
        	Person kisi=kisiIterator.next();
            if(kisi.getName().contains(arancakKelime)){
                sonuclar.add(kisi);
            }
        }
        listPerson(sonuclar);
	
	}

}
