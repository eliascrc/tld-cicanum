package cr.ac.ucr.cicanum.tld.build;

import cr.ac.ucr.cicanum.tld.core.TestBean;
import cr.ac.ucr.cicanum.tld.core.security.ccss_manager.service.CcssManagerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataImporter {

    private final ClassPathXmlApplicationContext context;

    private DataImporter(){
        this.context = new ClassPathXmlApplicationContext("tld-cicanum-core.spring.xml", "tld-cicanum-persistence.spring.xml", "tld-cicanum-security.spring.xml");
    }

    private void importData(){
        CcssManagerService obj = (CcssManagerService) this.context.getBean("ccssManagerService");
        System.out.println(obj.getCcssManagerByUsername("eliasrc").getFirstName());

    }

    public static void main(String[] args) {
        DataImporter dataImporter = new DataImporter();
        dataImporter.importData();
    }

}
