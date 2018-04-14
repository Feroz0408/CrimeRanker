import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 /**
 * 612-175 LBE10 (Multinomial) Naive Bayes Classification
 * Prof JKang
 */
public class NBClassifierB {
	public ArrayList<String> stopwords = new ArrayList<String>();
	private ArrayList<String> trainingDocs;         //training data
	private ArrayList<Integer> trainingClasses;         //training class values
   private int numClasses;
	private int[] classDocCounts;          //number of docs per class 
   private String[] classStrings;         //concatenated string for a given class 
	private int[] classTokenCounts;        //total number of tokens per class 
	private HashMap<String,Double>[] condProb; //term conditional prob
	private HashSet<String> vocabulary;    //entire vocabulary
	
   @SuppressWarnings("unchecked")
	public NBClassifierB(ArrayList<String> docs, ArrayList<Integer> classes, int numC) throws IOException
   {
		trainingDocs = docs;
        trainingClasses = classes;
		numClasses = numC;
		File stop_file = new File("stopwords.txt");
        stopWord(stop_file);
		//System.out.println(trainingClasses.size());
		//System.out.println(trainingDocs.size());
      
		classDocCounts = new int[numClasses];
		classStrings = new String[numClasses];
		classTokenCounts = new int[numClasses];
      
      condProb = new HashMap[numClasses];
		vocabulary = new HashSet<String>();
      
		for(int i=0;i<numClasses;i++){
			classStrings[i] = "";
			condProb[i] = new HashMap<String,Double>();
		}
      
		for(int i=0;i<trainingClasses.size();i++){
			classDocCounts[trainingClasses.get(i)]++;
			//System.out.println(trainingClasses.get(i));
			classStrings[trainingClasses.get(i)] += (trainingDocs.get(i) + " ");
		}
        //System.out.println("++++++++++++++" + classStrings[0]);
		for(int i=0;i<numClasses;i++){
			ArrayList<String> pureTokens = new ArrayList<String>();
			String[] tokens = classStrings[i].split("[-\"@.,_':;&__%$#!(){}/+?><*\\[\\] ]+");
			 for(String token:tokens) 
		     {
		        if(searchStopWord(token) == -1) {
		        	//System.out.println(token);\
		        	String w = Stemmer_fn(token);
		        	pureTokens.add(w);
		         }
		     }
			 for(String p: pureTokens) {
				 System.out.println(p);
			 }
			classTokenCounts[i] = pureTokens.size();
			for(String token:pureTokens){
				vocabulary.add(token);
				if(condProb[i].containsKey(token)){
					double count = condProb[i].get(token);
					condProb[i].put(token, count+1);
				}
				else
					condProb[i].put(token, 1.0);
			}
		}
		
		for(int i=0;i<numClasses;i++){
			Iterator<Map.Entry<String, Double>> iterator = condProb[i].entrySet().iterator();
			int vSize = vocabulary.size();
			while(iterator.hasNext())
			{
				Map.Entry<String, Double> entry = iterator.next();
				String token = entry.getKey();
				Double count = entry.getValue();
            Double prob = (count+1)/(classTokenCounts[i]+vSize);
            condProb[i].put(token, prob);
			}
			//System.out.println(condProb[i]);
		}
	}
   
   public void stopWord (File filename) throws IOException 
	{
		Scanner scan = new Scanner(filename);
		while(scan.hasNextLine()) 
		{
		    stopwords.add(scan.nextLine()); 
		}
		scan.close();
	}
   
   public int searchStopWord(String key) 
	{
	   int lo = 0;
	   int hi = lo + stopwords.size()-1;
	   //System.out.println(key + "Index : "+ stopwords.indexOf(key));
	   while(lo <= hi) 
	   {
	      int mid = lo + (hi - lo)/2;
	      int result = key.compareTo(stopwords.get(mid));
	      if(result <0) hi = mid - 1;
	      else if(result > 0) lo = mid + 1;
	      else return mid;
	   }
	   return -1;
	}
	
   public String Stemmer_fn(String token) 
	{
		Stemmer st = new Stemmer();
	         st.add(token.toCharArray(), token.length());
	         st.stem();
	         String word = st.toString();
	         
	         return word;
	}
   
	public ArrayList<Integer> classfiy(ArrayList<String> docs){
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int docId = 1;
		int count0 = 0; 
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int vSize = vocabulary.size();
		int numOfDocs = docs.size();
		for(String s: docs) {
			//System.out.println(s);
			 int label = 0;
		      double[] score = new double[numClasses];
		      
		      for(int i=0;i<score.length;i++) {
		         score[i] = classDocCounts[i] * 1.0/trainingDocs.size(); //prior prob
		      }
		      ArrayList<String> pureTokens = new ArrayList<String>();
				String[] tokens = s.split("[-\"@.,_':;&__%$#!(){}/+?><*\\[\\] ]+");
				 for(String token:tokens) 
			     {
			        if(searchStopWord(token) == -1) {
			        	//System.out.println(token);\
			        	String w = Stemmer_fn(token);
			        	pureTokens.add(w);
			         }
			     }
		      
		      for(int i=0;i<numClasses;i++) {
		         for(String token:pureTokens) {
		            if(condProb[i].containsKey(token))
		               score[i] *= condProb[i].get(token);
		            else
		               score[i] *= (1.0/(classTokenCounts[i] * vSize));
		         }
		         //System.out.println(score[i]);
		      }
		     
		      //argMax
		      double maxScore = 0;
		      //System.out.println("score[0]:" + score[0]);
		      for(int i=0;i<score.length;i++) {
		         //System.out.println("score[" + i + "]:" + score[i]);
		         if(score[i] > maxScore) {
		            maxScore = score[i];
		            label = i;
		            if(label == 0) count0++;
		            if(label == 1) count1++;
		            if(label == 2) count2++;
		            if(label == 3) count3++;
		            labels.add(Integer.toString(docId) + " : " + Integer.toString(label));
		         }
		      }
		      docId++;
		}
		System.out.println("Total number of docs: " + numOfDocs);
		int totalC = count0 + count1 + count2 + count3;
		result.add(totalC);
		result.add(count0);
		result.add(count1);
		result.add(count2);
		result.add(count3);
	 System.out.println(count0);
	 System.out.println(count1);
	 System.out.println(count2);
	 System.out.println(count3);
      		
		return result;
	}
}
