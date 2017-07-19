package biblio.sentence;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        sentenceDao = mock(SentenceDao.class);
        writer.setSentenceDao(sentenceDao);
    }

    @Test
    public void testWriteSentence() throws Exception {
        when(sentenceDao.insert(any(Sentence.class))).thenReturn(1);
        writer.write(items);
        verify(sentenceDao, times(2)).insert(any(Sentence.class));
        verifyNoMoreInteractions(sentenceDao);
    }
}