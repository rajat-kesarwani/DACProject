package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
//	create table Product (
//	          Product_Id INTEGER PRIMARY KEY,
//	          Product_Title VARCHAR(50),
//	          Description VARCHAR(100),
//	          Category_Id INTEGER(FK),
//	          Price DECIMAL,
//	          Image VARCHAR(100)
//	          );

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Product_Id;
	
	@Column(length = 20)
	private String Product_Title;
	
	@Column(length = 30)
	private String Description;
	
	private Integer Category_Id;
	
	private Integer Price;
	
	@Column(length = 100)
	private String Image;

	public Product(Integer product_Id, String product_Title, String description, Integer category_Id, Integer price,
			String image) {
		super();
		Product_Id = product_Id;
		Product_Title = product_Title;
		Description = description;
		Category_Id = category_Id;
		Price = price;
		Image = image;
	}

	public Integer getProduct_Id() {
		return Product_Id;
	}

	public void setProduct_Id(Integer product_Id) {
		Product_Id = product_Id;
	}

	public String getProduct_Title() {
		return Product_Title;
	}

	public void setProduct_Title(String product_Title) {
		Product_Title = product_Title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Integer getCategory_Id() {
		return Category_Id;
	}

	public void setCategory_Id(Integer category_Id) {
		Category_Id = category_Id;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	@Override
	public String toString() {
		return "Product [Product_Id=" + Product_Id + ", Product_Title=" + Product_Title + ", Description=" + Description
				+ ", Category_Id=" + Category_Id + ", Price=" + Price + ", Image=" + Image + "]";
	}
	
	
	
	
	
}
