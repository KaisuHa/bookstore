package palvelinohjelmointi.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title, author, bookyear, isbn, price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name = "categoryid")
	private Category category;

	public Book() {}
	
	public Book(String title, String author, String bookyear, String isbn, String price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.bookyear = bookyear;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookyear() {
		return bookyear;
	}

	public void setBookyear(String bookyear) {
		this.bookyear = bookyear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", bookyear=" + bookyear + ", isbn="
				+ isbn + ", price=" + price + "]";
	}

}
