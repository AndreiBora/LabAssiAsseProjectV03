package Validator;
import Exceptions.ValidatorException;
import Domain.Student;

public class StudentValidator implements IValidator<Student> {

    public void validate(Student s) throws ValidatorException {
        String errors="";
        if(s.getId() == null || s.getId().equals("")){
            errors +="Id is invalid\n";
        }
        if(s.getNume()==null || s.getNume().equals("") ){
            //throw new ValidatorException("Nume invalid\n");
            errors+="Nume invalid\n";
        }
        if(s.getGrupa()<=0){
            //throw new ValidatorException("Grupa invalida\n");
            errors+="Grupa invalid\n";
        }
        if( s.getEmail()==null || s.getEmail().equals("")  ){
            //throw new ValidatorException("Email invalid\n");
            errors+="Email invalid\n";
        }
        if(s.getIndrumator() == null || s.getIndrumator().equals("")){
            errors += "Invalid indrumator";
        }
        if (errors.length()!=0){
            throw  new ValidatorException(errors);
        }

    }
}