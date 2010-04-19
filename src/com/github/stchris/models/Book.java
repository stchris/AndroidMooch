package com.github.stchris.models;

public class Book {
	public String title;
	public String author;
	public String publisher;
	public String publicationDate;
	public String edition;
	public String numberOfPages;
	public String binding;
	public String store;
	public String price;
	public String currency;
	public String smallImgUrl;
	public String smallImgHeight;
	public String smallImgWidth;
	public String largeImgUrl;
	public String largeImgHeight;
	public String largeImgWidth;
	public String isbn;

	public String toString() {
		return "\"" + title + "\"\nby " + author + "\n\nPublisher: "
				+ publisher + "\nPublication date: " + publicationDate
				+ "\nNumber of pages: " + numberOfPages + "\nBinding: "
				+ binding + "\n\nStore: " + store + "\nPrice: " + price + "(" + currency + ")";
	}
}
