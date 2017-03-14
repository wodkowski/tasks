package pl.wodkowski.job.interview.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import pl.wodkowski.job.interview.adapter.AuthorAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "book")
public class Book {
	@XmlAttribute(name = "id")
	private String id;
	@XmlAttribute(name = "author-id")
	@XmlJavaTypeAdapter(value = AuthorAdapter.class)
	private Author author;
	private String title;
	@XmlElement
	private int published;
	private String isbn;

	public Book() {
	}

	public Book(String id, Author author, String title, int published, String isbn) throws Exception {
		this.id = id;
		this.author = author;
		this.title = title;
		this.published = published;
		this.isbn = isbn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublished() {
		return published;
	}

	public void setPublished(int published) {
		this.published = published;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", published=" + published + ", isbn="
				+ isbn + "]";
	}

}
