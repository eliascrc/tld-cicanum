package cr.ac.ucr.cicanum.tld.build;

import cr.ac.ucr.cicanum.tld.core.security.cicanum_user.service.CicanumUserService;
import cr.ac.ucr.cicanum.tld.model.CicanumUser;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataImporter {

    private final ClassPathXmlApplicationContext context;

    private DataImporter(){
        this.context = new ClassPathXmlApplicationContext("tld-cicanum-core.spring.xml", "tld-cicanum-persistence.spring.xml", "tld-cicanum-security.spring.xml");
    }

    private void importData(){
        // Hard coded users are persisted for testing purposes

        CicanumUser cicanumUser1 = new CicanumUser();
        cicanumUser1.setFirstName("Elias");
        cicanumUser1.setLastName("Calderon Calderon");
        cicanumUser1.setUsername("eliasrc");
        cicanumUser1.setPassword("tld.123");
        cicanumUser1.setPhoneNumber("22554411");
        cicanumUser1.setEmail("elias.calderon@gmail.com");
        cicanumUser1.setEnabled(true);
        cicanumUser1.setResetPassword(false);
        cicanumUser1.setUpdateInformation(false);
        cicanumUser1.setLoginCount(1);
        cicanumUser1.setLastLogin(new Date());
        cicanumUser1.setInitials("ERC");
        cicanumUser1.setGroup(1);
        cicanumUser1.setCanSign(true);

        CicanumUser cicanumUser2 = new CicanumUser();
        cicanumUser2.setFirstName("Roberto");
        cicanumUser2.setLastName("Leandro Flores");
        cicanumUser2.setUsername("farol");
        cicanumUser2.setPassword("tld.123");
        cicanumUser2.setPhoneNumber("22884477");
        cicanumUser2.setEmail("roberto.leandro@gmail.com");
        cicanumUser2.setEnabled(true);
        cicanumUser2.setResetPassword(false);
        cicanumUser2.setUpdateInformation(false);
        cicanumUser2.setLoginCount(0);
        cicanumUser2.setLastLogin(new Date());
        cicanumUser2.setInitials("RLF");
        cicanumUser2.setGroup(2);
        cicanumUser2.setCanSign(false);

        CicanumUserService cicanumUserService = (CicanumUserService) context.getBean("cicanumUserService");
        cicanumUserService.create(cicanumUser1);
        cicanumUserService.create(cicanumUser2);
    }

    public static void main(String[] args) {
        DataImporter dataImporter = new DataImporter();
        dataImporter.importData();
    }

}
