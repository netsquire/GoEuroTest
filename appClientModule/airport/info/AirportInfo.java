package airport.info;

public class AirportInfo {

	String _id;
	String name;
	String fullName;
	GeoPosition geo_position;
	String type;
	
	
	public AirportInfo() {}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public GeoPosition getGeoPosition() {
		return geo_position;
	}
	public void setGeoPosition(GeoPosition geoPosition) {
		this.geo_position = geoPosition;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}