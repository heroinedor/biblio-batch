package biblio.sentence;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by heroinedor on 18/07/2017.
 */
public class SentenceRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sentence phrase = new Sentence();
        phrase.setIdSentence(rs.getInt("idSentence"));
        phrase.setSentence(rs.getString("sentence"));
        phrase.setIdBook(rs.getInt("book_idbook"));
        return phrase;
    }
}
