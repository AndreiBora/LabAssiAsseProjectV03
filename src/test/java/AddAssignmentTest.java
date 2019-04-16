import Exceptions.ValidatorException;
import Exceptions.ServiceException;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.TemaLabXMLService;
import Validator.TemaLabValidator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AddAssignmentTest {

    @Test
    public void whenGroupIsMaxIntMinusOneTestAddStudent() throws ValidatorException {
        //given

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
        //given
        String[] params = {"1", "a", "2", "2"};
        try {
            tmsrv.add(params);
            assertTrue(true);
        } catch (Exception e) {
            fail("It should not throw exception");
        }
    }

    @Test(expected = ValidatorException.class)
    public void whenDescriptionEmpty() throws ValidatorException {
        //given

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
        //given
        String[] params = {"1", "", "2", "2"};

            tmsrv.add(params);

    }

    @Test(expected = ValidatorException.class)
    public void whenDescriptionNull() throws ValidatorException {
        //given

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
        //given
        String[] params = {"1", null, "2", "2"};

        tmsrv.add(params);
    }

    @Test(expected = ServiceException.class)
    public void serviceDuplicateId() throws ValidatorException {
        //given

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
        //given
        String[] params = {"1", "a", "2", "2"};

        tmsrv.add(params);

        tmsrv.add(params);
    }

    @Test(expected = NumberFormatException.class)
    public void whenIdEmpty() throws ValidatorException {
        //given

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
        //given
        String[] params = {"", "a", "2", "2"};

        tmsrv.add(params);
    }

    @Test(expected = NumberFormatException.class)
    public void whenIdNull() throws ValidatorException {
        //given

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
        //given
        String[] params = {null, "a", "2", "2"};

        tmsrv.add(params);
    }
}
