import Exceptions.ValidatorException;
import Exceptions.ServiceException;
import Domain.TemaLab;
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

    @Test(expected = ValidatorException.class)
    public void termenLT1() throws ValidatorException {
        //given

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
        //given
        String[] params = {"1", "a", "0", "2"};

        tmsrv.add(params);

    }

    @Test(expected = ValidatorException.class)
    public void termenGT14() throws ValidatorException {
        //given

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
        //given
        String[] params = {"1", "a", "15", "2"};

        tmsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void predareLT1() throws ValidatorException {
        //given

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
        //given
        String[] params = {"1", "a", "2", "0"};

        tmsrv.add(params);

    }

    @Test(expected = ValidatorException.class)
    public void predareGT14() throws ValidatorException {
        //given

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
        //given
        String[] params = {"1", "a", "2", "15"};

        tmsrv.add(params);
    }

    @Test(expected = ServiceException.class)
    public void repoDuplicateId() throws ValidatorException {
        //given

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
        //given
        String[] params = {"1", "a", "2", "2"};

        tmsrv.add(params);

        tmrepo.save(new TemaLab(Integer.parseInt(params[0]),params[1],Integer.parseInt(params[2]),Integer.parseInt(params[3])));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullEntity() throws ValidatorException {
        //given

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");

        tmrepo.save(null);
    }
}
