package es.upm.miw.innoassessment.data.daos;

import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.upm.miw.innoassessment.config.PersistenceConfig;
import es.upm.miw.innoassessment.config.TestsPersistenceConfig;
import es.upm.miw.innoassessment.data.entities.Product;
import es.upm.miw.innoassessment.data.entities.ProductVersion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, TestsPersistenceConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoITest {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductVersionDao productVersionDao;

	@Test
	public void Test01_CreateProduct() {
		Product product = new Product("testProductDao", "v0", "demo provider");
		productDao.saveAndFlush(product);
		assertTrue(productDao.count() > 0);
	}

	@Test
	public void Test01_FindAnyProduct() {
		assertNotNull(productDao.findOne(1));
	}

	@Test
	public void Test02_FindByName() {
		Product product = productDao.findByName("testProductDao");
		assertEquals("testProductDao", product.getName());
	}

	
	@Test
	public void Test03_AddProductVersion() {
		Product product = productDao.findByName("testProductDao");
		assertEquals("testProductDao", product.getName());
		ProductVersion productVersion = new ProductVersion("testProductVersion", product);
		productVersionDao.saveAndFlush(productVersion);
		assertTrue(productVersion.getName() == "testProductVersion");
		assertEquals(1,productVersionDao.findByProduct(product).size());
	}
	

	@Test
	public void Test04_FindProductVersion() {
		Product product = productDao.findByName("testProductDao");
		assertEquals("testProductDao", product.getName());
		assertEquals(1,productVersionDao.findByProduct(product).size());
		List<ProductVersion> listProductVersion = productVersionDao.findByProduct(product);
		assertEquals(1, listProductVersion.size());
	}

	@Test
	public void Test05_DeleteProductVersion() {
    	Product product = productDao.findByName("testProductDao");
		assertEquals(1,productVersionDao.findByProduct(product).size());

        List<ProductVersion> listProductVersion = productVersionDao.findByProduct(product);
        ProductVersion productVersion = listProductVersion.get(0);
        assertEquals("testProductDao", productVersion.getProduct().getName());
        productVersionDao.delete(productVersion);
        productVersionDao.flush();       
        //assertNull(productDao.findByName("testProductDao"));
	}

	@Test
	public void Test06_DeleteProduct() {
		Product product = productDao.findByName("testProductDao");
		assertEquals("testProductDao", product.getName());
		productDao.delete(product);
	}

	/*
	 * 
	 * @Test public void Test03_FindByUserAndDate() { User user =
	 * userDao.findByUsernameOrEmail("t0"); assertEquals("t0",
	 * user.getUsername()); Calendar date = Calendar.getInstance();
	 * date.add(Calendar.DAY_OF_YEAR, 1); date.set(Calendar.HOUR_OF_DAY, 9);
	 * date.set(Calendar.MINUTE, 0); date.set(Calendar.SECOND, 0);
	 * date.set(Calendar.MILLISECOND, 0);
	 * assertNotNull(trainingDao.findByUserAndDate(user, date)); }
	 * 
	 * @Test public void Test04_FindByCourtAndDate() { Court court =
	 * courtDao.findOne(1); assertEquals(1, court.getId()); Calendar date =
	 * Calendar.getInstance(); date.add(Calendar.DAY_OF_YEAR, 1);
	 * date.set(Calendar.HOUR_OF_DAY, 9); date.set(Calendar.MINUTE, 0);
	 * date.set(Calendar.SECOND, 0); date.set(Calendar.MILLISECOND, 0);
	 * assertNotNull(trainingDao.findByCourtAndDate(court, date)); }
	 * 
	 * @Test public void Test05_CreateTraining2() { Calendar date =
	 * Calendar.getInstance(); date.add(Calendar.DAY_OF_YEAR, 2);
	 * date.set(Calendar.HOUR_OF_DAY, 10); date.set(Calendar.MINUTE, 0);
	 * date.set(Calendar.SECOND, 0); date.set(Calendar.MILLISECOND, 0); Court
	 * court = courtDao.findOne(2); assertEquals(2, court.getId()); User user =
	 * userDao.findByUsernameOrEmail("t1"); assertEquals("t1",
	 * user.getUsername()); Training training = new Training(court, user, date);
	 * trainingDao.saveAndFlush(training); assertEquals(2, trainingDao.count());
	 * }
	 * 
	 * @Test public void Test06_ExistTraining() { assertEquals(2,
	 * trainingDao.count()); Calendar date = Calendar.getInstance();
	 * date.add(Calendar.DAY_OF_YEAR, 2); date.set(Calendar.HOUR_OF_DAY, 10);
	 * date.set(Calendar.MINUTE, 0); date.set(Calendar.SECOND, 0);
	 * date.set(Calendar.MILLISECOND, 0); Court court = courtDao.findOne(2);
	 * assertEquals(2, court.getId());
	 * assertTrue(trainingDao.existTraining(court.getId(), date)); }
	 * 
	 * @Test public void Test07_testAddTrainingPlayer() { Court court =
	 * courtDao.findOne(1); assertEquals(1, court.getId()); Calendar date =
	 * Calendar.getInstance(); date.add(Calendar.DAY_OF_YEAR, 1);
	 * date.set(Calendar.HOUR_OF_DAY, 9); date.set(Calendar.MINUTE, 0);
	 * date.set(Calendar.SECOND, 0); date.set(Calendar.MILLISECOND, 0); String
	 * student = "u0"; int courtId = court.getId();
	 * trainingDao.addTrainingPlayer(courtId, date, student); Training training
	 * = trainingDao.findByCourtAndDate(court, date); assertEquals(1,
	 * training.numStudents()); }
	 * 
	 * @Test public void Test08_testIsVacancyInTraining() { Court court =
	 * courtDao.findOne(1); Calendar date = Calendar.getInstance();
	 * date.add(Calendar.DAY_OF_YEAR, 1); date.set(Calendar.HOUR_OF_DAY, 9);
	 * date.set(Calendar.MINUTE, 0); date.set(Calendar.SECOND, 0);
	 * date.set(Calendar.MILLISECOND, 0); String student = "u0"; int courtId =
	 * court.getId(); trainingDao.addTrainingPlayer(courtId, date, student);
	 * assertTrue(trainingDao.isVacancyInTraining(courtId, date)); for (int i =
	 * 1; i < 4; i++) { trainingDao.addTrainingPlayer(courtId, date, "u"+i); }
	 * assertFalse(trainingDao.isVacancyInTraining(courtId, date)); }
	 * 
	 * 
	 * @Test public void Test09_DeleteTrainingPlayer() { Court court =
	 * courtDao.findOne(1); assertEquals(1, court.getId()); Calendar date =
	 * Calendar.getInstance(); date.add(Calendar.DAY_OF_YEAR, 1);
	 * date.set(Calendar.HOUR_OF_DAY, 9); date.set(Calendar.MINUTE, 0);
	 * date.set(Calendar.SECOND, 0); date.set(Calendar.MILLISECOND, 0); Training
	 * training = trainingDao.findByCourtAndDate(court, date); String student =
	 * "u0"; int courtId = court.getId();
	 * trainingDao.deleteTrainingPlayer(courtId, date, student); training =
	 * trainingDao.findByCourtAndDate(court, date); assertEquals(3,
	 * training.numStudents()); }
	 * 
	 * @Test public void Test10_DeleteTraining() { assertEquals(2,
	 * trainingDao.count()); Court court = courtDao.findOne(1); assertEquals(1,
	 * court.getId()); Calendar date = Calendar.getInstance();
	 * date.add(Calendar.DAY_OF_YEAR, 1); date.set(Calendar.HOUR_OF_DAY, 9);
	 * date.set(Calendar.MINUTE, 0); date.set(Calendar.SECOND, 0);
	 * date.set(Calendar.MILLISECOND, 0);
	 * trainingDao.deleteTraining(court.getId(), date); trainingDao.flush();
	 * assertEquals(1, trainingDao.count()); }
	 */
}
