package es.upm.miw.innoassessment.data.daos;

import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.upm.miw.innoassessment.config.PersistenceConfig;
import es.upm.miw.innoassessment.config.TestsPersistenceConfig;
import es.upm.miw.innoassessment.data.entities.Model;
import es.upm.miw.innoassessment.data.services.DataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, TestsPersistenceConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModelDaoIT {

	@Autowired
	private ModelDao modelDao;

	@Autowired
	private DataService dataService;
	
	@Before
	public void deleteAllBefore(){
		dataService.deleteAll();
	}
	
	@Test
	public void Test01_CreateModel() {
		Model model = new Model("testModelDao", "2016", "v.1.0", "demo model");
		modelDao.saveAndFlush(model);
		assertTrue(modelDao.count() > 0);
	}

	@Test
	public void Test02_FindByName() {
		Model model = new Model("testModelDao", "2016", "v.1.0", "demo model");
		modelDao.saveAndFlush(model);
		model = modelDao.findByName("testModelDao");
		assertEquals("testModelDao", model.getName());
	}

	@Test
	public void Test03_DeleteModel() {
		Model model = new Model("testModelDao", "2016", "v.1.0", "demo model");
		modelDao.saveAndFlush(model);
		model = modelDao.findByName("testModelDao");
		assertEquals("testModelDao", model.getName());
		modelDao.delete(model);
		assertNull(modelDao.findByName("testModelDao"));
	}
}
