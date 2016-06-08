package es.upm.miw.innoassessment.business.wrapper;

import es.upm.miw.innoassessment.data.entities.Product;

public class ProductWrapper {

	private int id;
	private String name;
	private String description;
	private String provider;
	

	public ProductWrapper() {
	}

	public ProductWrapper(int id, String name, String description, String provider) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.provider = provider;
		
	}

	public ProductWrapper(Product product) {
		this(product.getId(), product.getName(), product.getDescription(), product.getProvider());
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
		this.provider = provider;	}

	

}
