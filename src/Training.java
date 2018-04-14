import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Training {


	public ArrayList<Integer> Train(double longitude, double latitude) {
		ArrayList<String> trainDocs = new ArrayList<String>();
		 ArrayList<Integer> trainLabels = new ArrayList<Integer>();
		 ArrayList<String> testDocs = new ArrayList<String>();
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 double longitude1 = longitude;
		 double latitude1 = latitude;
		//JOptionPane.showInternalMessageDialog(null, "Welcome to the crime world");
		//lblMessage.setText("Welcome to the crime world");
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("finaltrain_updated.csv"));
			String line;
				while ((line = reader.readLine()) != null) {
					trainDocs.add(line);
				}	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		BufferedReader reader1;
		try {
			reader1 = new BufferedReader(new InputStreamReader(new FileInputStream("finaltrain_updated_class val.csv"),"UTF-8"));
			String line1;
			while ((line1 = reader1.readLine()) != null) {
				//System.out.println(line1);
				trainLabels.add(Integer.parseInt(line1));
			}
		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		int numClass = 4;
		
		//create tweets file
		
		String[] terms = {"murder", "theft", "assault", "rape"};
		Tweets tw = new Tweets(terms, longitude1, latitude1 );
		
		try {
			NBClassifierB nb1 = new NBClassifierB(trainDocs, trainLabels, numClass);
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("new_test.csv"),"UTF-8"));
			String line2;
			while ((line2 = reader2.readLine()) != null) {
				testDocs.add(line2);
			}
			ArrayList<Integer> res= new ArrayList<Integer>();
			res = nb1.classfiy(testDocs);
			
			float f = (res.get(1) * 100.0f)/res.get(0);
			System.out.println(res.get(0));
			System.out.println(f);
			result.add((Math.round((res.get(1) * 100.0f)/res.get(0))));
			result.add((Math.round((res.get(2) * 100.0f)/res.get(0))));
			result.add((Math.round((res.get(3) * 100.0f)/res.get(0))));
			result.add((Math.round((res.get(4) * 100.0f)/res.get(0))));
			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
