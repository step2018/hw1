
import java.util.*;
import java.io.*;
import java.net.*;

public class AnagramSolver2 {
	/*key:sorted word, value:original word*/
	static HashMap<String, String>hm = new HashMap<String, String>();//store words of dictionary
	static Vector<String>stdin = new Vector<String>();//store remporarily
	static Vector<String>words = new Vector<String>();
	static Map<Integer, List<String>>anagrams = new TreeMap<Integer, List<String>>();
	static List<String>list1 = new ArrayList<String>();
	static List<String>list2 = new ArrayList<String>();
	static List<String>list3 = new ArrayList<String>();
	static List<String>list4 = new ArrayList<String>();
	static List<String>list5 = new ArrayList<String>();
	static List<String>list6 = new ArrayList<String>();
	static List<String>list7 = new ArrayList<String>();
	static List<String>list8 = new ArrayList<String>();
	static List<String>list9 = new ArrayList<String>();
	static List<String>list10 = new ArrayList<String>();
	static List<String>list11 = new ArrayList<String>();
	static List<String>list12 = new ArrayList<String>();
	static List<String>list13 = new ArrayList<String>();
	static List<String>list14 = new ArrayList<String>();
	static List<String>list15 = new ArrayList<String>();
	static List<String>list16 = new ArrayList<String>();
	static String[]strArray = new String[17];//store 16characters in arrays
	public static void main(String[] args) {
		String sortedInput = null;
		int cnt=0;
		/*access the site and read*/
		try {
			URL url = new URL("https://icanhazwordz.appspot.com/dictionary.words");
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"JISAutoDetect"))){
				while (reader.readLine()!=null) {
					cnt++;//
					String str=reader.readLine().toUpperCase();
					addInList(str);
					//String sortedString=sort(str);
					/*
					String[]temporary=sortedString.split("");
					for(int i=0; i<temporary.length; i++){
						if(containsAllAlphabets(sortedString)) {
							System.out.println(str+" ");
							System.out.println(hm.get(words.get(i))+" "+i);
						}
					}
					*/
					//hm.put(sortedString, str);
					//words.addElement(sortedString);
					
				}
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*read stdin*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine().toUpperCase();
			sortedInput = sort(line);
			System.out.println("sorting completed! : "+sortedInput);
			br.close();
		} catch (IOException e){
			System.out.println(e);
		}
		strArray=null;
		strArray=sortedInput.split("");//store 16characters in arrays
		for(int i=3; i<=16; i++){
			anagrams.put(i, checkListNo(i));
		}
		System.out.println(cnt);
		System.out.println(anagrams.size());
		//System.out.println(hm.size());
		/*
		for(int i=0; i<words.size(); i++) {
			if(containsAllAlphabets(words.get(i))) {
				System.out.println(hm.get(words.get(i))+" "+i);
			}
		}
		*/
		//System.out.println("");
		for(int i=3; i<=16; i++) {
			for(String str:anagrams.get(i)){
				if(containsAllAlphabets(str)) {
					System.out.print(str+" ");
				}
			}
			System.out.println("");
		}
		//System.out.println("");
	}
	/*method to sort words in lexical order*/
	public static String sort(String str){
		String []character = str.split("");
		Arrays.sort(character);
		String newstr = String.join("", character);
		return newstr;
	}
	/*method to check that 16 characters contains the argument*/
	public static boolean containsAllAlphabets(String alphabet) {
		String[]alphabets=alphabet.split("");
		stdin.clear();
		/*store temporarily*/
		for(int i=0; i<strArray.length; i++) {
			stdin.addElement(strArray[i]);
		}
		for(int i=0; i<alphabets.length; i++){
			if(stdin.contains(alphabets[i])) {
			    stdin.remove(alphabets[i]);
			}else{
			     return false;
			}
		}
		return true;
	}
	public static void addInList(String str){
		if(str.length()==1)list1.add(str);
		if(str.length()==2)list2.add(str);
		if(str.length()==3)list3.add(str);
		if(str.length()==4)list4.add(str);
		if(str.length()==5)list5.add(str);
		if(str.length()==6)list6.add(str);
		if(str.length()==7)list7.add(str);
		if(str.length()==8)list8.add(str);
		if(str.length()==9)list9.add(str);
		if(str.length()==10)list10.add(str);
		if(str.length()==11)list11.add(str);
		if(str.length()==12)list12.add(str);
		if(str.length()==13)list13.add(str);
		if(str.length()==14)list14.add(str);
		if(str.length()==15)list15.add(str);
		if(str.length()==16)list16.add(str);
	}
	public static List<String> checkListNo(int length){
		if(length==1)return list1;
		else if(length==2)return list2;
		else if(length==3)return list3;
		else if(length==4)return list4;
		else if(length==5)return list5;
		else if(length==6)return list6;
		else if(length==7)return list7;
		else if(length==8)return list8;
		else if(length==9)return list9;
		else if(length==10)return list10;
		else if(length==11)return list11;
		else if(length==12)return list12;
		else if(length==13)return list13;
		else if(length==14)return list14;
		else if(length==15)return list15;
		else{return list16;}
	}
}
