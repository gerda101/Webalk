package cdshop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataAccessTest {
	
	private DataAccess dao;

	@Before
	public void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@localhost:1522:xe");
		datasource.setUsername("system");
		datasource.setPassword("1234");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		dao= new DataAccess(new JdbcTemplate(datasource));
	}

	@Test
	public void testList() {
		List<CD> listCD = dao.list();	
		assertFalse(listCD.isEmpty());
	}

	@Test
	public void testSave() {
		CD cd = new CD("Test Title", "Test Band", 0, 0.00f);
		dao.save(cd);
	}

	@Test
	public void testGet() {
		int id = 4;
		CD cd = dao.get(id);	
		assertNotNull(cd);
	}

	@Test
	public void testUpdate() {
		CD cd = new CD();
		cd.setId(4);
		cd.setTitle("Test 2");
		cd.setArtist("Test Band 2");
		cd.setStock(10);	
		cd.setPrice(4.56f);
		dao.update(cd);
	}

	@Test
	public void testDelete() {
		int id= 4;
		dao.delete(id);
	}

}
