package cj.netos.fission.service;

import cj.lns.chip.sos.cube.framework.IDocument;
import cj.lns.chip.sos.cube.framework.IQuery;
import cj.netos.fission.AbstractService;
import cj.netos.fission.IPersonService;
import cj.netos.fission.model.LatLng;
import cj.netos.fission.model.Person;
import cj.studio.ecm.annotation.CjService;
import cj.ultimate.gson2.com.google.gson.Gson;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CjService(name = "personService")
public class PersonService extends AbstractService implements IPersonService {
    @Override
    public Person get(String unionid) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.id':'%s'}", _KEY_COL, Person.class.getName(), unionid);
        IQuery<Person> query = getHome().createQuery(cjql);
        IDocument<Person> document = query.getSingleResult();
        if (document == null) {
            return null;
        }
        return document.tuple();
    }

    @Override
    public List<Person> listPersonIn(List<String> persons) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.id':{'$in':%s}}", _KEY_COL, Person.class.getName(), new Gson().toJson(persons));
        IQuery<Person> query = getHome().createQuery(cjql);
        List<IDocument<Person>> documents = query.getResultList();
        List<Person> personList = new ArrayList<>();
        for (IDocument<Person> document : documents) {
            personList.add(document.tuple());
        }
        return personList;
    }

    @Override
    public Map<String, Person> mapPersonIn(List<String> persons) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.id':{'$in':%s}}", _KEY_COL, Person.class.getName(), new Gson().toJson(persons));
        IQuery<Person> query = getHome().createQuery(cjql);
        List<IDocument<Person>> documents = query.getResultList();
        Map<String, Person> map = new HashMap<>();
        for (IDocument<Person> document : documents) {
            Person person = document.tuple();
            map.put(person.getId(), person);
        }
        return map;
    }

    @Override
    public void updateLocation(String principal,LatLng location, String province, String city, String district, String town, String provinceCode, String cityCode, String districtCode, String townCode) {
        String filter = String.format("{'tuple.id':'%s'}", principal);
        String update = String.format("{'$set':{'tuple.province':'%s','tuple.provinceCode':'%s','tuple.city':'%s','tuple.cityCode':'%s','tuple.district':'%s','tuple.districtCode':'%s','tuple.town':'%s','tuple.townCode':'%s','tuple.location':%s}}",
                province,provinceCode, city,cityCode, district,districtCode, town,townCode, new Gson().toJson(location));
        getHome().updateDocOne(_KEY_COL, Document.parse(filter), Document.parse(update));

    }
}
