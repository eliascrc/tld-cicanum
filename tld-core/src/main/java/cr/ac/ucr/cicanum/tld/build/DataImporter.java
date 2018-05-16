package cr.ac.ucr.cicanum.tld.build;

import cr.ac.ucr.cicanum.tld.core.TestBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataImporter {

    private final ClassPathXmlApplicationContext context;

    private DataImporter(){
        this.context = new ClassPathXmlApplicationContext("tld-cicanum-core.spring.xml");
    }

    private void importData(){
        TestBean obj = (TestBean) this.context.getBean("testBean");
        System.out.println(obj.getMessage());
    }

    public static void main(String[] args) {
        DataImporter dataImporter = new DataImporter();
        dataImporter.importData();
    }

}
