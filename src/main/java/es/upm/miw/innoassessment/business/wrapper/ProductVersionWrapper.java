package es.upm.miw.innoassessment.business.wrapper;

import es.upm.miw.innoassessment.data.entities.ProductVersion;

public class ProductVersionWrapper {

	private int id;
	private String name;
	private String description;
	private int productId;
	private String productName;
	private String productDescription;
	private String productProvider;

	public ProductVersionWrapper() {
	}
	
	public ProductVersionWrapper(int productId) {
		this.productId = productId;
	}

	public ProductVersionWrapper(int id, String name,String description, int productId, String productName, String productDescription,
			String productProvider) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productProvider = productProvider;
	}

	public ProductVersionWrapper(ProductVersion productVersion) {
		this(productVersion.getId() , productVersion.getName(), productVersion.getDescription(),
				productVersion.getProduct().getId(), productVersion.getProduct().getName(),
				productVersion.getProduct().getDescription(), productVersion.getProduct().getDescription());
	}
	
	/*
	public void ProductVersionWrapper2(ProductVersion productVersion) {
		this(String.valueOf(productVersion.getId()) , productVersion.getName(), productVersion.getDescription(),
				productVersion.getProduct().getId(), productVersion.getProduct().getName(),
				productVersion.getProduct().getDescription(), productVersion.getProduct().getDescription());
	}
*/
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductProvider() {
		return productProvider;
	}

	public void setProductProvider(String productProvider) {
		this.productProvider = productProvider;
	}

	@Override
	public String toString() {
		return "ProductVersionWrapper [id=" + id + ", name=" + name + ", description=" + description + ", productId="
				+ productId + ", productName=" + productName + ", productDescription=" + productDescription
				+ ", productProvider=" + productProvider + "]";
	}
	
	

}
