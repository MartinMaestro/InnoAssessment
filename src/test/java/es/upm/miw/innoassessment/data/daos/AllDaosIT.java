package es.upm.miw.innoassessment.data.daos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ProductDaoIT.class, ModelDaoIT.class, ModelItemDaoIT.class})
public class AllDaosIT {}
