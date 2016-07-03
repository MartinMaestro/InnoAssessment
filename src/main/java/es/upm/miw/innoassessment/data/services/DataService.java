package es.upm.miw.innoassessment.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upm.miw.innoassessment.data.daos.AssessmentLineDao;
import es.upm.miw.innoassessment.data.daos.DimensionDao;
import es.upm.miw.innoassessment.data.daos.EvaluationDao;
import es.upm.miw.innoassessment.data.daos.EvaluationResultDao;
import es.upm.miw.innoassessment.data.daos.FactorDao;
import es.upm.miw.innoassessment.data.daos.LineValueDao;
import es.upm.miw.innoassessment.data.daos.ModelDao;
import es.upm.miw.innoassessment.data.daos.ModelItemDao;
import es.upm.miw.innoassessment.data.daos.ProductDao;
import es.upm.miw.innoassessment.data.daos.ProductVersionDao;
import es.upm.miw.innoassessment.data.daos.QuestionnaireDao;
import es.upm.miw.innoassessment.data.daos.SourceFileDao;
import es.upm.miw.innoassessment.data.daos.SourceUrlDao;

@Service
public class DataService {

	@Autowired
	private AssessmentLineDao assessmentLineDao;
	
	@Autowired
	private DimensionDao dimensionDao;
	
	@Autowired
	private FactorDao factorDao;
	
	@Autowired
	private SourceFileDao sourceFileDao;
	
	@Autowired
	private SourceUrlDao sourceUrlDao;
	
	@Autowired
	private LineValueDao lineValueDao;
	
	@Autowired
	private EvaluationResultDao evaluationResultDao;
	
	@Autowired
	private EvaluationDao evaluationDao;
	
	@Autowired
	private QuestionnaireDao questionnaireDao;
	
	@Autowired
	private ModelItemDao modelItemDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ModelDao modelDao;
	
	@Autowired
	private ProductVersionDao productVersionDao;
	
	public void deleteAll(){
		sourceUrlDao.deleteAll();
		sourceUrlDao.flush();
		sourceFileDao.deleteAll();
		sourceFileDao.flush();
		lineValueDao.deleteAll();
		lineValueDao.flush();
		evaluationResultDao.deleteAll();
		evaluationResultDao.flush();
		evaluationDao.deleteAll();
		evaluationDao.flush();
		assessmentLineDao.deleteAll();
		assessmentLineDao.flush();
		questionnaireDao.deleteAll();
		questionnaireDao.flush();
		productVersionDao.deleteAll();
		productVersionDao.flush();
		modelItemDao.deleteAll();	
		modelItemDao.flush();
		modelDao.deleteAll();
		modelDao.flush();
		productDao.deleteAll();
		productDao.flush();
		factorDao.deleteAll();
		factorDao.flush();
		dimensionDao.deleteAll();
		dimensionDao.flush();
	}
	
}
