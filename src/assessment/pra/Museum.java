package assessment.pra;

public class Museum {
	
	private int museumId;
	private String museumName;
	private String museumLocation;
	private double rating;
	private boolean researchCentre;
	public int getMuseumId() {
		return museumId;
	}
	public void setMuseumId(int museumId) {
		this.museumId = museumId;
	}
	public String getMuseumName() {
		return museumName;
	}
	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}
	public String getMuseumLocation() {
		return museumLocation;
	}
	public void setMuseumLocation(String museumLocation) {
		this.museumLocation = museumLocation;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public boolean isResearchCentre() {
		return researchCentre;
	}
	public void setResearchCentre(boolean researchCentre) {
		this.researchCentre = researchCentre;
	}
	public Museum(int museumId, String museumName, String museumLocation, double rating, boolean researchCentre) {
		super();
		this.museumId = museumId;
		this.museumName = museumName;
		this.museumLocation = museumLocation;
		this.rating = rating;
		this.researchCentre = researchCentre;
	}
	
	

}
