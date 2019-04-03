import Exceptions.ValidatorException;
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
        String[] params = {"1", "VVSS in class", "1", "2"};
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
        String[] params = {"1", "", "1", "2"};

            tmsrv.add(params);

    }
}
