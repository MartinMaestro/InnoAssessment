package es.upm.miw.innoassessment.business.wrapper;

import es.upm.miw.innoassessment.data.entities.Product;

public class ProductWrapper {

	private int id;
	private String name;
	private String description;
	private String provider;
	private String version;

	public ProductWrapper() {
	}

	public ProductWrapper(int id, String name, String description, String provider, String version) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.provider = provider;
		this.version = version;
	}

	public ProductWrapper(Product product) {
		this(product.getId(), product.getName(), product.getDescription(), product.getProvider(), product.getVersion());
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
