import Exceptions.ServiceException;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.StudentXMLRepo;
import Service.XMLFileService.StudentXMLService;
import Validator.StudentValidator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AddStudentTest {

    // TC_final_1
    @Test
    public void whenPositiveIntegerGroupTestAdd(){
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","Petrica","931","p@gmail.com","Linus"};
        try {
            stsrv.add(params);
            assertTrue(true);
        } catch (ValidatorException e) {
            fail("It should not throw exception");
        }

        strepo.delete("1");
    }

    // TC_final_2

    @Test(expected = ValidatorException.class)
    public void whenRealNumberGroupTestAdd() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","Petrica","1.3","p@gmail.com","Linus"};
        stsrv.add(params);
    }

    // TC_final_3

    @Test(expected = ValidatorException.class)
    public void whenStringGroupTestAdd() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","Petrica","p","p@gmail.com","Linus"};
        stsrv.add(params);
    }

    // TC_final_4

    @Test(expected = ValidatorException.class)
    public void whenNegativeIntegerGroupTestAdd() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","Petrica","-1","p@gmail.com","Linus"};
        stsrv.add(params);
    }

    // TC_final_5

    @Test(expected = ValidatorException.class)
    public void whenIdEmptyTestAddStudent() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"","Petrica","-1","p@gmail.com","Linus"};
        stsrv.add(params);
    }

    // TC_final_6

    @Test(expected = ValidatorException.class)
    public void whenIdNullTestAddStudent() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={null,"Petrica","931","p@gmail.com","Linus"};
        stsrv.add(params);
    }

    // TC_final_7

    @Test(expected = ValidatorException.class)
    public void whenEmailIsEmptyTestAddStudent() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","Petrica","931","","Linus"};

        stsrv.add(params);
    }

    // TC_final_8

    @Test(expected = ValidatorException.class)
    public void whenEmailIsNullTestAddStudent() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","Petrica","931",null,"Linus"};

        stsrv.add(params);
    }

    // TC_final_9

    @Test(expected = ValidatorException.class)
    public void whenNameIsEmptyTestAddStudent() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","","931","p@gmail.com","Linus"};

        stsrv.add(params);
    }

    // TC_final_10

    @Test(expected = ValidatorException.class)
    public void whenNameIsNullTestAddStudent() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1",null,"931","p@gmail.com","Linus"};

        stsrv.add(params);
    }

    // TC_final_11

    @Test(expected = ValidatorException.class)
    public void whenIndrumatorIsNullTestAddStudent() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","Petrica","931","p@gmail.com",null};

        stsrv.add(params);
    }

    //TC_final_12
    @Test(expected = ServiceException.class)
    public void whenDuplicateIdAddStudent() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params1={"1","Petrica","931","p@gmail.com","Linus"};
        String[] params2={"1","Dorel","931","dorel@gmail.com","Linus"};

        stsrv.add(params1);
        try {
            stsrv.add(params2);
        }
        catch (ServiceException e) {
            strepo.delete("1");
            throw e;
        }

    }

    // TC_final_14

    @Test(expected = ValidatorException.class)
    public void whenGroupIsZeroTestAddStudent() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","Petrica","0","p@gmail.com","Linus"};

        stsrv.add(params);
    }

    // TC_final_17

    @Test
    public void whenGroupIsMaxIntTestAddStudent() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","Petrica",String.valueOf(Integer.MAX_VALUE),"p@gmail.com","Linus"};

        stsrv.add(params);
        assertTrue(true);

        strepo.delete("1");

    }

    // TC_final_18

    @Test(expected = ValidatorException.class)
    public void whenGroupIsMaxIntPLusOneTestAddStudent() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","Petrica",String.valueOf(Integer.MAX_VALUE+1),"p@gmail.com","Linus"};

        stsrv.add(params);
    }

    // TC_final_19

    @Test
    public void whenGroupIsMaxIntMinusOneTestAddStudent() throws ValidatorException {
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        //given
        String[] params={"1","Petrica",String.valueOf(Integer.MAX_VALUE-1),"p@gmail.com","Linus"};

        stsrv.add(params);
        assertTrue(true);

        strepo.delete("1");
    }

    // TC_final_19



}
