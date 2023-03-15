
package ch03;

public class Company {

	private String name;
	private String catchPhrase;
	private String bs;

	@Override
	public String toString() {
		return "Company [name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

//	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
//
//	public Map<String, Object> getAdditionalProperties() {
//		return this.additionalProperties;
//	}
//
//	public void setAdditionalProperty(String name, Object value) {
//		this.additionalProperties.put(name, value);
//	}

}
