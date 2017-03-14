package pl.wodkowski.job.interview.task;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import pl.wodkowski.job.interview.model.Library;

public class UnmarshallingTask {
	public static void main(String[] args) throws Exception {

		ClassLoader classLoader = UnmarshallingTask.class.getClassLoader();
		File file = new File(classLoader.getResource("excercise/excercise-1.xml").getFile());

		JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Library library = (Library) jaxbUnmarshaller.unmarshal(file);
		System.out.println("Books: ");
		library.getBooks().forEach(System.out::println);
		System.out.println("Authors:");
		library.getAuthors().forEach(System.out::println);

	}
}
