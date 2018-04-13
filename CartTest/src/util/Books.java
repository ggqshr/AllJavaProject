package util;

import java.util.ArrayList;

public class Books {

	private ArrayList<Book> books = new ArrayList<>();
	public Books() {
		// TODO Auto-generated constructor stub
		addBook("java�����ŵ�����", 12,1);
		addBook("c���Դ����ŵ�����", 15,2);
		addBook("python�����ŵ�����", 20,3);
	}
	public void addBook(String name,int price,int num)
	{
		Book book =new Book(name, price,num);
		books.add(book);
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public Book getBookById(int id)
	{
		for (Book book : books) {
			if(book.getNum()==id)
			{
				return book;
			}
		}
		return null;
	}
	
}
