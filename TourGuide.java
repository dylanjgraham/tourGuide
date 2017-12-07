import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class TourGuide 
{
	Map<Integer, List<String>> mapOfGuides = new HashMap<Integer, List<String>>();
	String name;
	String homeTown;
	String major;
	String minor;
	List<String> listOfGuides = new ArrayList<String>();
	
	public TourGuide(String name1, String homeTown1, String major1, String minor1)
	{
		name = name1;
		homeTown = homeTown1;
		major = major1;
		minor = minor1;
	}
	
	
	
}
