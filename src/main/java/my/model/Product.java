package my.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Image smallImage;
    @OneToOne(cascade =CascadeType.PERSIST)
    private Image bigImage;
    private String title;
    @Column(length = 1023)
    private String description;
    private double price;
    //@OneToOne(cascade=CascadeType.PERSIST)
    //private Category category;
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

//    public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Product (){};

    public Image getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(Image smallImage) {
        this.smallImage = smallImage;
    }

    public Image getBigImage() {
        return bigImage;
    }

    public void setBigImage(Image bigImage) {
        this.bigImage = bigImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(Image smallImage, Image bigImage, String title, String description, double price, String category) {
        this.smallImage = smallImage;
        this.bigImage = bigImage;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category=category;
    }
}
