package ch01;

public class User {
	private int id;
	private String name;
	private String username;
	private String email;
	private String phone;
	private String website;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", phone=" + phone
				+ ", website=" + website + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

} // end of User class

class Company {
	private String name;
	private String catchPhrase;
	private String bs;

	@Override
	public String toString() {
		return "Company [name=" + name + ", catchPharse=" + catchPhrase + ", bs=" + bs + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPharse() {
		return catchPhrase;
	}

	public void setCatchPharse(String catchPharse) {
		this.catchPhrase = catchPharse;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

} // end of Company class

class Address {
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private Geo geo;

	@Override
	public String toString() {
		return "Address [street=" + street + ", suite=" + suite + ", city=" + city + ", zipcode=" + zipcode + "]";
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	class Geo {
		private String lat;
		private String lng;

		@Override
		public String toString() {
			return "Geo [lat=" + lat + ", lng=" + lng + "]";
		}

		public String getLat() {
			return lat;
		}

		public void setLat(String lat) {
			this.lat = lat;
		}

		public String getLng() {
			return lng;
		}

		public void setLng(String lng) {
			this.lng = lng;
		}

	}

} // end of Address class