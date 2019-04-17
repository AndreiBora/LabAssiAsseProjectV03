import Exceptions.ServiceException;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class IntegrationTest {

    // TC_final_1
    @Test
    public void whenCorrectIntegrationGrade(){
        //given

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);

        TemaLabValidator vt = new TemaLabValidator();
        TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);

        NotaValidator vn=new NotaValidator();
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        //given
        String[] student={"1","Petrica","931","p@gmail.com","Linus"};
        String[] assignment = {"1", "a", "2", "2"};
        String[] grade = {"1","1","1","10","2011-12-03T10:15:30"};
        try {
            stsrv.add(student);
            tmsrv.add(assignment);
            ntsrv.add(grade);
            assertTrue(true);
        } catch (ValidatorException e) {
            fail("It should not throw exception");
        }
    }

    @Test
    public void whenCorrectAddAssignment() throws ValidatorException {
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

    // TC_final_1
    @Test
    public void whenCorrectAddStudent(){
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
    }


}