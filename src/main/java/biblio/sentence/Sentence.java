package biblio.sentence;

/**
 * Created by heroinedor on 04/07/2017.
 */
public class Sentence {
    private int idSentence;
    private String sentence;
    private long idBook;

    public int getIdSentence() {
        return idSentence;
    }

    public void setIdSentence(int idSentence) {
        this.idSentence = idSentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }
}
