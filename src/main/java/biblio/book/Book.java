package biblio.book;

/**
 * Created by heroinedor on 03/07/2017.
 */
public class Book {
    private long idBook;
    private String title;
    private String content;

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
