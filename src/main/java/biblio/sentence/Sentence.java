package biblio.sentence;

/**
 * Created by heroinedor on 04/07/2017.
 */
public class Sentence {
    private int idSentence;
    private String sentence;
    private int idBook;

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

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }
}
