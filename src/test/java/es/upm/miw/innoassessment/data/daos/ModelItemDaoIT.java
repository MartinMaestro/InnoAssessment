package es.upm.miw.innoassessment.data.daos;

import org.junit.runners.MethodSorters;
import org.junit.Before;
import org.junit.FixMethodOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.upm.miw.innoassessment.config.PersistenceConfig;
import es.upm.miw.innoassessment.config.TestsPersistenceConfig;
import es.upm.miw.innoassessment.data.entities.Dimension;
import es.upm.miw.innoassessment.data.entities.Factor;
import es.upm.miw.innoassessment.data.entities.Model;
import es.upm.miw.innoassessment.data.entities.ModelItem;
import es.upm.miw.innoassessment.data.services.DataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, TestsPersistenceConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModelItemDaoIT {

	@Autowired
	private ModelItemDao modelItemDao;

	@Autowired
	private ModelDao modelDao;

	@Autowired
	private DimensionDao dimensionDao;

	@Autowired
	private FactorDao factorDao;

	@Autowired
	private DataService dataService;
	
	@Before
	public void deleteAllBefore(){
		dataService.deleteAll();
	}
	
	@Test
	public void Test01_CreateModelItem() {
		Model model = new Model("testModelDao", "2016", "v.1.0", "demo model");
		assertTrue(model.getName() == "testModelDao");
		modelDao.saveAndFlush(model);
		Dimension dimension = new Dimension("testDimensionDao");
		assertTrue(dimension.getName() == "testDimensionDao");
		dimensionDao.saveAndFlush(dimension);
		Factor factor = new Factor("testFactorDao", "test Factor");
		assertTrue(factor.getName() == "testFactorDao");
		factorDao.saveAndFlush(factor);
		int numModelItems = (int) modelItemDao.count();
		ModelItem modelItem = new ModelItem(model, dimension, factor, "Positive", 0.1f, "demo model Item",
				"help model Item");
		modelItemDao.saveAndFlush(modelItem);
		assertEquals(numModelItems + 1, modelItemDao.count());
	}

	@Test
	public void Test02_FindByDimension() {
		Model model = new Model("testModelDao2", "2016", "v.1.0", "demo model");
		modelDao.saveAndFlush(model);
		Dimension dimension = new Dimension("testDimensionDao2");
		dimensionDao.saveAndFlush(dimension);
		Factor factor = new Factor("testFactorDao2", "test Factor");
		factorDao.saveAndFlush(factor);
		ModelItem modelItem = new ModelItem(model, dimension, factor, "Positive", 0.1f, "demo model Item",
				"help model Item");
		modelItemDao.saveAndFlush(modelItem);
		ModelItem modelItemFind = modelItemDao.findByDimension(dimension).get(0);
		assertEquals(modelItemFind.getDimension().getId(),dimension.getId());
	}

	@Test
	public void Test03_DeleteModel() {
		Model model = new Model("testModelDao", "2016", "v.1.0", "demo model");
		model = modelDao.saveAndFlush(model);
		modelDao.delete(model);
		assertNull(modelDao.findByName("testModelDao"));
	}

	@Test
	public void Test06_DeleteModelItem() {
		Model model = new Model("testModelDao", "2016", "v.1.0", "demo model");
		model = modelDao.saveAndFlush(model);
		Dimension dimension = new Dimension("testDimensionDao2");
		dimensionDao.saveAndFlush(dimension);
		Factor factor = new Factor("testFactorDao2", "test Factor");
		factorDao.saveAndFlush(factor);
		ModelItem modelItem = new ModelItem(model, dimension, factor, "Positive", 0.1f, "demo model Item",
				"help model Item");
		modelItem = modelItemDao.saveAndFlush(modelItem);
		assertNotNull(modelItem);
		modelItemDao.deleteAll();
		modelItemDao.flush();
		assertNull(modelItemDao.findOne(modelItem.getId()));
	}
}
