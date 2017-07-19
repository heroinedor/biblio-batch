package biblio.sentence;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by heroinedor on 19/07/2017.
 */
public class SentenceWriter implements ItemWriter<Sentence> {
    @Autowired
    private SentenceDao sentenceDao;

    public void write(List<? extends Sentence> items) throws Exception {
        for (Sentence phrase : items) {
            sentenceDao.insert(phrase);
        }
    }
}
