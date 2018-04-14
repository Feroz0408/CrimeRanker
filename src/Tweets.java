import java.io.File;
import java.io.FileNotFoundException;
import twitter4j.*;
import com.*;
import twitter4j.conf.ConfigurationBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;
import java.io.FileWriter;

public class Tweets {
	//get live tweets and create a zip file
	
	public Tweets (String[] terms, double lg, double lt) {
		double longitude = lg;
		double latitude = lt;
		 ConfigurationBuilder cb = new ConfigurationBuilder();
	       cb.setDebugEnabled(true).setOAuthConsumerKey("S4rWtnRiNZSn9Nf3qliSfwLzO").setOAuthConsumerSecret("gn2f5nG8jOMHf8kRa3wip0MXWlnhPIuv3eNIqY0XGiezb4XMNu").setOAuthAccessToken("962442942093852673-30KtT6lp8cmiSxZZ7ISe55UWMh7DraS").setOAuthAccessTokenSecret("IO9orHOkauFetXxbXYZv7357e81Ql9gxLGBDRuYQBc5nP");
	       TwitterFactory tf = new TwitterFactory(cb.build());
	       Twitter twitter = tf.getInstance();
	       QueryResult result = null;
	       for(String s: terms) {
	    	   Query query = new Query(s);
	    	   query.geoCode(new GeoLocation(lg, lt), 200, "km");
		       query.setCount(200);
		       try {
					result = twitter.search(query);
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	       }
			
	       
			 // CSVWriter writer = new CSVWriter(new FileWriter("text.csv"), '\t');
		       PrintWriter pw;
				try {
					pw = new PrintWriter(new File("new_test.csv"));
				
		       StringBuilder sb = new StringBuilder();
		       
		          for (Status status : result.getTweets()) {
		          //  System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
		        
		           sb.append(status.getText());
		           sb.append('\n');
		        }                
		          pw.write(sb.toString());
		             pw.close();
				}  
		             catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 

	}
	
	
  
     
	

}
