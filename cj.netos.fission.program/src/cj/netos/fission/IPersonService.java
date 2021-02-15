package cj.netos.fission;

import cj.netos.fission.model.Person;

import java.util.List;
import java.util.Map;

public interface IPersonService {
    public  static  String _KEY_COL="fission.mf.persons";


    Person get(String unionid);

    List<Person> listPersonIn(List<String> persons);

    Map<String, Person> mapPersonIn(List<String> ids);

}
