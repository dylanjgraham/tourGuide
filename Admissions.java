
public class Admissions 
{
	public boolean homeTownMatch(TourGuide guide, ProspectiveStudent student)
	{
		if (guide.homeTown.equals(student.homeTown))
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}

	
	public boolean majorMatch(TourGuide guide, ProspectiveStudent student)
	{
		if (guide.major.equals(student.major))
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	public boolean minorMatch(TourGuide guide, ProspectiveStudent student)
	{
		if (guide.minor.equals(student.minor))
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	public String findMatches(ProspectiveStudent student)
	{
		TourGuide tony = new TourGuide("Anthony", "Hillburough", "who knows anymore", "idk maybe acounting?");
		//would take all tour guide info here and loop through all possible guides with the same student passed each time looking for best match
		if (homeTownMatch(tony, student))
		{
			return "You are both from " + student.homeTown;
		}
		if (majorMatch(tony,student))
		{
			return tony.name + " is a " + tony.major + " major";
		}
		if (minorMatch(tony, student))
		{
			return tony.name + " is a " + tony.minor + " minor";
		}
		return "No matches";
	}
}
