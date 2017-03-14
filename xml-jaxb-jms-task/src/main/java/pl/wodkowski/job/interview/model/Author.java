package pl.wodkowski.job.interview.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import pl.wodkowski.job.interview.adapter.DateYMDAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "author")
public class Author {
	@XmlAttribute(name = "id")
	private String id;
	private String name;
	private String surname;
	@XmlElement(required = true)
	@XmlJavaTypeAdapter(value = DateYMDAdapter.class)
	private Date born;
	@XmlJavaTypeAdapter(value = DateYMDAdapter.class)
	private Date died;

	public Author(String id, String name, String surname, Date born, Date died) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.born = born;
		this.died = died;
	}

	public Author() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public Date getDied() {
		return died;
	}

	public void setDied(Date died) {
		this.died = died;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", surname=" + surname + ", born=" + born + ", died=" + died
				+ "]";
	}

}
