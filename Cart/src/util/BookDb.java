package util;

import java.util.Collection;
import java.util.HashMap;

public class BookDb {

	private static HashMap<String, Book> books = new HashMap<String, Book>();
	public BookDb() {
		// TODO Auto-generated constructor stub
		books.put("1", new Book(1, "java�����ŵ�����", 12.00));
		books.put("2", new Book(2,"Python�����ŵ�����", 13.00));
		books.put("3", new Book(3, "C���Դ����ŵ�����", 15.00));
		books.put("4", new Book(4, "PHP�����ŵ�����", 16.00));
		books.put("5", new Book(5, "javaweb�����ŵ�����", 16.00));
	}
	public Collection<Book> getAll()
	{
		return books.values();
	}
	public Book getBook(String id)
	{
		return books.get(id);
	}
}
