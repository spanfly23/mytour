package com.mytour.models;

public class Place {

	private String placeName;

	private USState usStateName;

	private Country countryName;

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public USState getUsStateName() {
		return usStateName;
	}

	public void setUsStateName(USState usStateName) {
		this.usStateName = usStateName;
	}

	public Country getCountryName() {
		return countryName;
	}

	public void setCountryName(Country countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Place [placeName=" + placeName + ", usStateName=" + usStateName + ", countryName=" + countryName + "]";
	}

	
}
