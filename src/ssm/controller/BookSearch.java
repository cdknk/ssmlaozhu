package ssm.controller;

public class BookSearch {
	private String bookTitle;
	private String bookAuthor;
	private String publisher;

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		if (!bookTitle.trim().isEmpty()) {
			this.bookTitle = bookTitle;
		}
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		if (!bookAuthor.trim().isEmpty()) {
			this.bookAuthor = bookAuthor;
		}
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		if (!publisher.trim().isEmpty()) {
			this.publisher = publisher;
		}
	}

	@Override
	public String toString() {
		return "BookSearch [bookTitle=" + bookTitle + ", bookAuthor="
				+ bookAuthor + ", publisher=" + publisher + "]";
	}
	
}
