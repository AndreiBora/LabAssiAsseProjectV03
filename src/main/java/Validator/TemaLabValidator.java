package Validator;
import Exceptions.ValidatorException;
import Domain.TemaLab;
import Validator.IValidator;

public class TemaLabValidator implements IValidator<TemaLab> {

    public void validate(TemaLab t) throws ValidatorException {
        if(t.getId()== null || t.getId().equals("")){  // cond 3, 4
            throw new ValidatorException("Nr tema invalid\n");
        }else if(t.getDescriere()== null || t.getDescriere().equals("")) {  // cond 5, 6
            throw new ValidatorException("Descriere tema invalida\n");
        }else if(t.getSaptammanaPredarii()<=0 || t.getSaptammanaPredarii()>14) {  // cond 7, 8
            throw new ValidatorException("Sapatamana predarii invalida\n");
        }else if(t.getTermenLimita()<=0 || t.getTermenLimita()>14) {  // cond 9, 10
            throw new ValidatorException("Termen limita invalid\n");
        }
    }
}
