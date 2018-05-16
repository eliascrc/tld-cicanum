package cr.ac.ucr.cicanum.tld.build;

import cr.ac.ucr.cicanum.tld.core.TestBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataImporter {

    final ClassPathXmlApplicationContext context;

    DataImporter(){
        this.context = new ClassPathXmlApplicationContext("talent-core.spring.xml");
    }

    void importData(){
        TestBean obj = (TestBean) this.context.getBean("testBean");
    }

    public static void main(String[] args) {
        DataImporter dataImporter = new DataImporter();
        dataImporter.importData();
    }

}
