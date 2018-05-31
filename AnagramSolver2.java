
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
	static String[]strArray = new String[19];//store 16characters in arrays
	static List<String> bestWord = new ArrayList<String>();
	static int maxScore;
	static int smallest;
	static int biggest;
	public static void main(String[] args) {
		String sortedInput = null;
		/*access the site and read*/
		try {
			URL url = new URL("https://icanhazwordz.appspot.com/dictionary.words");
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"JISAutoDetect"))){
				while (reader.readLine()!=null) {
					String str=reader.readLine().toUpperCase();
					addInList(str);	
				}
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*read stdin*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		try {
			while((line=br.readLine())!=null){
				System.out.println("PLEASE INPUT CHARS. IF Qu IS INCLUDED, PLEASE INPUT Q & U");
				bestWord.removeAll(bestWord);
				line=line.toUpperCase();
				sortedInput = sort(line);
				strArray=null;
				strArray=sortedInput.split("");//store 16characters in arrays
				for(int i=3; i<=16; i++) {
					anagrams.put(i, checkListNo(i));
					for(String str:anagrams.get(i)){
						if(containsAllAlphabets(str)) {
							int score=scoreCalculator(str);
							System.out.println(str+" ");
							if(maxScore<score){//change the max score
								maxScore=score;
								bestWord.removeAll(bestWord);
								bestWord.add(str);
							}else if(maxScore==score){
								bestWord.add(str);
							}
						}
					}
				}
				System.out.println("");
				System.out.println("THE BEST WORD WAS FOUND!  Estimated Score is "+maxScore);
				for(int i=0; i<bestWord.size(); i++){
					System.out.print(bestWord.get(i)+" ");
				}
				System.out.println("");
			}
			br.close();
		} catch (IOException e){
			System.out.println(e);
		}
		
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
	        int flag=0;//0 : stdin doesn't include "Q"
		int cntU=0;
	        int cntQ=0;
		/*store temporarily*/
		for(int i=0; i<strArray.length; i++) {
		        if(strArray[i].equals("Q")){
				flag=1;
				cntQ++;
			}
			else if(strArray[i].equals("U")){
				cntU++;
			}
			stdin.addElement(strArray[i]);
		}
		//if(cntU!=0)System.out.println("U:"+cntU+" Q:"+cntQ);
	       	//if(flag!=0)System.out.println(flag);
		for(int i=0; i<alphabets.length; i++){
		    if(flag==0&&stdin.contains(alphabets[i])) {//stdin doesn't include "Q"
				stdin.remove(alphabets[i]);
		    }else if(flag==1&&stdin.contains(alphabets[i])){//stdin includes "Q"
			if(alphabets[i].equals("Q")){
					stdin.remove("U");
					cntU--;
					cntQ--;
					stdin.remove("Q");
					i++;
			}else if(alphabets[i].equals("U")&&(cntQ<cntU)){//"U" is independent
					cntU--;
					stdin.remove("U");
			}else if(alphabets[i].equals("U")&&(cntQ==cntU)){//"U" is a part of "Qu"
					return false;
				}else{
				    stdin.remove(alphabets[i]);
				}
		    }else if(!stdin.contains(alphabets[i])){
			     return false;
		    }else{
			return false;
		    }
		}
		return true;
	}
	/*method to calculate the score of individual words*/
	public static int scoreCalculator(String word){
		String[]words=word.split("");
		int score=0;
		int flag=0;//0:word doesn't include "Q"
		for(int i=0; i<words.length; i++){
			if(words[i].equals("J")||words[i].equals("K")||words[i].equals("X")||words[i].equals("Z")){
				score+=3;
			}else if(words[i].equals("Q")){
				score+=3;
				flag=1;
			}else if(words[i].equals("C")||words[i].equals("F")||words[i].equals("H")||words[i].equals("L")||words[i].equals("M")||words[i].equals("P")||words[i].equals("V")||words[i].equals("W")||words[i].equals("Y")){
				score+=2;
			}else if(words[i].equals("U")&&flag==1){
				flag=0;
				score+=0;//because this "U" is a part of "Qu"
			}else{
				score++;
			}
		}
		score++;
		return score*score;
	}
	/*method to add in the list*/
	public static void addInList(String str){
		if(str.length()<smallest)smallest=str.length();
		if(str.length()>biggest)biggest=str.length();
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
	/*method to check the list number*/
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
