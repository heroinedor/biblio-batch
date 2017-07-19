package biblio.sentence;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by heroinedor on 18/07/2017.
 */
public class SentenceDao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertActor;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insertActor = new SimpleJdbcInsert(dataSource).withTableName("sentence");
    }

    /**
     * Insert a @{@link Sentence} in the database and return its generated id
     *
     * @param phrase
     * @return the generated id
     */
    public int insert(Sentence phrase) {
        int idSentence;
        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("idSentence", phrase.getIdSentence());
        parameters.put("sentence", phrase.getSentence());
        parameters.put("book_idbook", phrase.getIdBook());
        idSentence = insertActor.execute(parameters);
        return idSentence;
    }

    /**
     * Update a @{@link Sentence} in the database
     * and return the number of rows affected
     *
     * @param sentence
     * @return the number of rows affected
     */
    public int update(Sentence sentence) {
        int rowsNb;
        String updateSql = "UPDATE books.sentence SET sentence = ?, book_idbook = ?  WHERE idsentence = ?";

        // define query arguments
        Object[] params = {sentence.getSentence(), sentence.getIdBook(), sentence.getIdSentence()};
        // define SQL types of the arguments
        int[] types = {Types.VARCHAR, Types.INTEGER, Types.INTEGER};
        rowsNb = jdbcTemplate.update(updateSql, params, types);
        return rowsNb;
    }

    /**
     * Find a @{@link Sentence} by its idsentence
     *
     * @param idSentence
     * @return sentence found
     */
    public Sentence findByIndex(int idSentence) {
        String sql = "SELECT * FROM books.sentence WHERE idsentence = ?";
        Sentence word = (Sentence) jdbcTemplate.queryForObject(
                sql, new Object[]{idSentence}, new SentenceRowMapper());
        return word;
    }
}
