package pl.wodkowski.job.interview.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import pl.wodkowski.job.interview.model.Author;

public class AuthorAdapter extends XmlAdapter<String, Author> {

	@Override
	public String marshal(Author a) throws Exception {
		return a.getId();
	}

	@Override
	public Author unmarshal(String a) throws Exception {
		return new Author(a, null, null, null, null);
	}

}
