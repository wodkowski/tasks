package pl.wodkowski.job.interview.task;

import java.io.File;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import pl.wodkowski.job.interview.adapter.DateYMDAdapter;
import pl.wodkowski.job.interview.model.Author;
import pl.wodkowski.job.interview.model.Book;
import pl.wodkowski.job.interview.model.Library;

public class MarshallingTask {
	public static void main(String[] args) throws Exception {
		Library library = new Library();

		Author a1 = new Author("a1", "John", "Applesed", DateYMDAdapter.Y_M_D_FORMATTER.parse("1979-11-11"), null);
		Author a2 = new Author("a2", "Krzysztof", "Habdank", DateYMDAdapter.Y_M_D_FORMATTER.parse("1965-12-12"), null);
		Author a3 = new Author("a3", "Paulo", "Coelho", DateYMDAdapter.Y_M_D_FORMATTER.parse("1915-06-17"), null);
		Author a4 = new Author("a4", "Miko³aj", "Kopernik", DateYMDAdapter.Y_M_D_FORMATTER.parse("1473-02-12"),
				DateYMDAdapter.Y_M_D_FORMATTER.parse("1543-05-24"));

		Book b1 = new Book("b1", a1, "Missing opportunity", 1992, "978-3-16-148410-0");
		Book b2 = new Book("b2", a4, "O obrotach sfer niebieskich", 1543, null);

		library.setBooks(Arrays.asList(b1, b2));
		library.setAuthors(Arrays.asList(a1, a2, a3, a4));

		JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(library, new File("excercise1_marshalling_test.xml"));

		System.out.println("Marshalling OK!");
	}
}
