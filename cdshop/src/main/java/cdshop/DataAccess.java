package cdshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DataAccess {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public DataAccess(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<CD> list() {
		String sql = "SELECT * FROM CD";
		
		List<CD> listCD = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CD.class));
        return listCD;
    }
  
	public void save(CD cd) {
	    SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
	    insertActor.withTableName("cd").usingColumns("title","artist", "stock", "price");
	    BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(cd);
	     
	    insertActor.execute(param);    
	}
  
    public CD get(int id) {
    	String sql ="SELECT * FROM CD WHERE id=?";
    	Object[] args = {id};
    	CD cd = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(CD.class));
        return cd;
    }
  
    public void update(CD cd) {
    	String sql = "UPDATE CD SET title=:title, artist=:artist, stock=:stock, price=:price WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(cd);  
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
  
    public void delete(int id) {
        String sql = "DELETE FROM CD WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
