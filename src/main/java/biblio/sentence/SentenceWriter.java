package biblio.sentence;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by heroinedor on 19/07/2017.
 */
public class SentenceWriter implements ItemWriter<Sentence> {
    private SentenceDao dao;

    public void write(List<? extends Sentence> items) throws Exception {
        for (Sentence phrase : items) {
            dao.insert(phrase);
        }
    }

    public void setDao(SentenceDao dao) {
        this.dao = dao;
    }
}
