package cr.ac.ucr.cicanum.tld.build;

import cr.ac.ucr.cicanum.tld.core.security.ccss_manager.service.CcssManagerService;
import cr.ac.ucr.cicanum.tld.core.security.cicanum_user.service.CicanumUserService;
import cr.ac.ucr.cicanum.tld.core.security.service_manager.service.ServiceManagerService;
import cr.ac.ucr.cicanum.tld.model.CcssManager;
import cr.ac.ucr.cicanum.tld.model.CicanumUser;
import cr.ac.ucr.cicanum.tld.model.ServiceManager;
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

        ServiceManager serviceManager1 = new ServiceManager();
        serviceManager1.setFirstName("Elias");
        serviceManager1.setLastName("Calderon Calderon");
        serviceManager1.setUsername("eliasrcSM");
        serviceManager1.setPassword("tld.123");
        serviceManager1.setPhoneNumber("22554411");
        serviceManager1.setEmail("elias.calderon@gmail.com");
        serviceManager1.setEnabled(true);
        serviceManager1.setResetPassword(false);
        serviceManager1.setUpdateInformation(false);
        serviceManager1.setLoginCount(1);
        serviceManager1.setLastLogin(new Date());

        ServiceManager serviceManager2 = new ServiceManager();
        serviceManager2.setFirstName("Roberto");
        serviceManager2.setLastName("Leandro Flores");
        serviceManager2.setUsername("farolSM");
        serviceManager2.setPassword("tld.123");
        serviceManager2.setPhoneNumber("22884477");
        serviceManager2.setEmail("roberto.leandro@gmail.com");
        serviceManager2.setEnabled(true);
        serviceManager2.setResetPassword(false);
        serviceManager2.setUpdateInformation(false);
        serviceManager2.setLoginCount(0);
        serviceManager2.setLastLogin(new Date());

        CcssManager ccssManager1 = new CcssManager();
        ccssManager1.setFirstName("Elias");
        ccssManager1.setLastName("Calderon Calderon");
        ccssManager1.setUsername("eliasrcCS");
        ccssManager1.setPassword("tld.123");
        ccssManager1.setPhoneNumber("22554411");
        ccssManager1.setEmail("elias.calderon@gmail.com");
        ccssManager1.setEnabled(true);
        ccssManager1.setResetPassword(false);
        ccssManager1.setUpdateInformation(false);
        ccssManager1.setLoginCount(1);
        ccssManager1.setLastLogin(new Date());

        CcssManager ccssManager2 = new CcssManager();
        ccssManager2.setFirstName("Roberto");
        ccssManager2.setLastName("Leandro Flores");
        ccssManager2.setUsername("farolCS");
        ccssManager2.setPassword("tld.123");
        ccssManager2.setPhoneNumber("22884477");
        ccssManager2.setEmail("roberto.leandro@gmail.com");
        ccssManager2.setEnabled(true);
        ccssManager2.setResetPassword(false);
        ccssManager2.setUpdateInformation(false);
        ccssManager2.setLoginCount(0);
        ccssManager2.setLastLogin(new Date());

        CicanumUserService cicanumUserService = (CicanumUserService) context.getBean("cicanumUserService");
        cicanumUserService.create(cicanumUser1);
        cicanumUserService.create(cicanumUser2);

        ServiceManagerService serviceManagerService = (ServiceManagerService) context.getBean("serviceManagerService");
        serviceManagerService.create(serviceManager1);
        serviceManagerService.create(serviceManager2);

        CcssManagerService ccssManagerService = (CcssManagerService) context.getBean("ccssManagerService");
        ccssManagerService.create(ccssManager1);
        ccssManagerService.create(ccssManager2);
    }

    public static void main(String[] args) {
        DataImporter dataImporter = new DataImporter();
        dataImporter.importData();
    }

}
