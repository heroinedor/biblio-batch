package biblio.sentence;

import org.springframework.batch.item.file.LineMapper;

/**
 * Created by heroinedor on 05/07/2017.
 */
public class SentenceMapper implements LineMapper<Sentence> {

    public Sentence mapLine(String line, int lineNumber) throws Exception {
        Sentence phrase = new Sentence();
        phrase.setSentence(line);
        return phrase;
    }
}
