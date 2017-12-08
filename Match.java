import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Match 
{
	public static boolean hometownMatch(String home, ProspectiveStudent student)
	{
		if (home.equals(student.homeTown))
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	public static boolean majorMatch(String major, ProspectiveStudent student)
	{
		if (major.equals(student.major))
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	public static boolean minorMatch(String minor, ProspectiveStudent student)
	{
		if (minor.equals(student.minor))
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	public static String findMatches(ProspectiveStudent student)
	{
			int count = 1;
			int i = 0;
			//scan in tour guides
			Scanner scanner = null;
			Map<Integer, List<String>> mapOfGuides = new HashMap<Integer, List<String>>();
			List<String> listOfGuides = new ArrayList<String>();
			String name = "";
			String homeTown = "";
			String major = "";
			String minor = "";
			String response ="";
			
	        try
	        {
	        		scanner = new Scanner(new File("guide.csv"));
	        }
	        catch (FileNotFoundException e)
	        {
	            System.out.println("Error opening file");
	            System.exit(0);
	        }
			scanner.useDelimiter(",|" + System.getProperty("line.separator"));
			//scanner.useDelimiter(System.getProperty("line.separator"));
			while (scanner.hasNext())
			{
				if (count == 1)
				{
					name = scanner.next();
					listOfGuides.add(name);
					count++;
				}
				else if (count == 2)
				{
					homeTown = scanner.next();
					listOfGuides.add(homeTown);
					count++;
				}
				else if (count == 3)
				{
					major = scanner.next();
					listOfGuides.add(major);
					count++;
				}
				else if(count == 4)
				{
					minor = scanner.next();
					listOfGuides.add(minor);
					count++;
				}
				else
				{
					//create response
					boolean similarFlag = false;
					mapOfGuides.put(i,listOfGuides);
					TourGuide tony = new TourGuide(name, homeTown, major, minor);
					response += tony.name + ":\n";
					
					if (hometownMatch(tony.homeTown, student))
					{
						response+= "\tYou are both from " + student.homeTown + "\n";
						similarFlag = true;
					}
					if (majorMatch(tony.major,student))
					{
						response+= "\t" + tony.name + " is a " + tony.major + " major \n";
						similarFlag = true;
					}
					if (minorMatch(tony.minor, student))
					{
						response+= "\t" + tony.name + " is a " + tony.minor + " minor \n";
						similarFlag = true;
					}
					if (similarFlag == false)
					{
						response = response.substring(0, response.length() - tony.name.length() -2);
						//response += "\t not compatible";
					}
					i++;
					count = 1;
					listOfGuides.clear();
				}
			}
			
			//System.out.println(mapOfGuides);
			//System.out.println(response);
			return response;
	}
	
	public static ProspectiveStudent gui()
	{
		//JFrame frame = new JFrame("InputDialog Example #1");
		JTextField nameField = new JTextField(5);
		JTextField homeTownField = new JTextField(5);
		JTextField majorField = new JTextField(5);
		JTextField minorField = new JTextField(5);
		
	    JPanel myPanel = new JPanel();
	    myPanel.add(new JLabel("Name"));
	    myPanel.add(nameField);
	    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	    myPanel.add(new JLabel("Home town"));
	    myPanel.add(homeTownField);
	    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	    myPanel.add(new JLabel("Prospective Major"));
	    myPanel.add(majorField);
	    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	    myPanel.add(new JLabel("Prospective Minor"));
	    myPanel.add(minorField);

	    int result = JOptionPane.showConfirmDialog(null, myPanel,
	            "Please Enter the following information", JOptionPane.OK_CANCEL_OPTION);
	        if (result == JOptionPane.OK_OPTION) {
	         // System.out.println("x value: " + xField.getText());
	         // System.out.println("y value: " + yField.getText());
	        	ProspectiveStudent dylan = new ProspectiveStudent(nameField.getText(), homeTownField.getText(), majorField.getText(), minorField.getText());
	        return dylan;
	        }
			return null;
	}
	
	
	public static void main(String [] args)
	{
		
		//ProspectiveStudent dylan = new ProspectiveStudent("Dylan","Hillsborough", "Computer Science", "");
		
		String result = findMatches(gui());
		System.out.println(result);
		System.out.print("");
		
        
	}
}
