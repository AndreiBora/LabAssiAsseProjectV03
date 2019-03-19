import Exceptions.ValidatorException;
import Repository.XMLFileRepository.StudentXMLRepo;
import Service.XMLFileService.StudentXMLService;
import Validator.StudentValidator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AddStudentTest {
    @Test
    public void whenPositiveIntegerGroupTestAdd(){
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","Andrei","931","a@a","Chiorean"};
        try {
            stsrv.add(params);
            assertTrue(true);
        } catch (ValidatorException e) {
            fail("It should not throw exception");
        }
    }

    @Test(expected = ValidatorException.class)
    public void whenNegativeIntegerGroupTestAdd() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","Andrei","-931","a@a","Chiorean"};
        stsrv.add(params);


    }
}
