
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Phonebook {
	static String inputFile = "phonebook.txt";
	static String outputFile = "sortedPhonebook.txt";
	// Create a hash map
    static TreeMap<String,String> tm = new TreeMap<String,String>();
    
    public static void readHash(){
    	int i=1;
    	String s="";
    	String ss;
    	Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File(inputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  
        }
        while (sc2.hasNextLine()) {
                Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
            	if(i%2!=0){
            		s = s2.next();
            		i++;
            	}
            	else {
            		ss = s2.next();
            		tm.put(s, ss);
            		i++;
            		 //System.out.println("" + s);
            	}
            }
            s2.close();
           
        }
    }
    public static void writeHash() throws IOException{
//    	
    	FileWriter fileWriter = new FileWriter(outputFile);
		PrintWriter out = new PrintWriter(fileWriter);
		
		Set set = tm.entrySet();
		System.out.println(set);
	
	
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	        // Map.Entry<String, String> en = Map.entrySet().iterator().next();
	         String m=(String)mentry.getValue();
	       
	         String key=(String)mentry.getKey();
	        // String k=(String)mentry.getValue();
	        // System.out.println("-----------------------------");
	         if(m.matches("[a-zA-Z ]*([^\\s\\+]*\\s?)?((\\+|00)?359|0)[-\\s]?(8[7-9][2-9])[-\\s]?(\\d{3})[-\\s]?(\\d{3})$"))
				{
	        	 System.out.println("Previous Name and Phone: "+m);
	        	 	String n=m.replaceAll("^([^\\s\\+]*\\s?)?((\\+|00)?359|0)[-\\s]?(8[7-9][2-9])[-\\s]?(\\d{3})[-\\s]?(\\d{3})$", "$2 $4 $5 $6").replaceAll("((\\+|00)?359|0)", "+359");
	        	 	
	        	 	System.out.println("New Name and Phone: " + key + n);
	        	 	System.out.println("-----------------------------");
	        	 	//System.out.println(key);
	        	 	out.println(mentry.getKey()+" "+n);
				}
				}
	         
	      
		
		
			//out.println(outputLine);
		
		out.flush();
		out.close();
		fileWriter.close();
    }
    
    
   
	
	public static void addPhone(String name, String number) throws IOException{
		tm.put(name, number);
		FileWriter fileWriter = new FileWriter(inputFile,true);
		PrintWriter out = new PrintWriter(fileWriter);
		out.println(tm.lastKey()+" "+tm.get(tm.lastKey()));
		out.flush();
		out.close();
		fileWriter.close();
		
		
	}
 public static void delPhone(String name)
 {
	  tm.remove(name);
 }
		public static void main(String[] args) throws IOException {

			addPhone("Dejan", "484984");
			addPhone("Zarko", "35989123456");
			//System.out.println(tm);
			delPhone("Dejan");
			//System.out.println(tm);
			readHash();
			//System.out.println(tm);
			writeHash();
		}
		

		
	}

