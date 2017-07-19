package biblio.sentence;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heroinedor on 19/07/2017.
 */
public class SentenceWriterMockTest {
    private SentenceDao sentenceDao;
    private SentenceWriter writer;
    private List<Sentence> items;

    @Before
    public void setUp() {
        items = new ArrayList<Sentence>();
        Sentence sentence = new Sentence();
        sentence.setIdSentence(211);
        sentence.setSentence("Tester c'est douter.");
        sentence.setIdBook(1);
        items.add(sentence);
        Sentence sentenceBis = new Sentence();
        sentenceBis.setIdSentence(212);
        sentenceBis.setSentence("Pour croire avec certitude, il faut commencer par douter.");
        sentenceBis.setIdBook(1);
        items.add(sentenceBis);
        writer = new SentenceWriter();
        //TODO create a mock of sentenceDao and set it to the writer
    }

    @Test
    public void testWriteSentence() throws Exception {
        //TODO use the when / thenReturn methods of mockito
        // to let sentenceDao return 1 each time the insert method is called with a Sentence argument
        writer.write(items);
        //TODO Verify with mockito that the sentenceDao.insert method is called only 2 times with a Sentence argument
        //and that no more interactions occurs after
    }
}