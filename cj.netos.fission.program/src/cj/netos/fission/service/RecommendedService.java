package cj.netos.fission.service;

import cj.lns.chip.sos.cube.framework.TupleDocument;
import cj.netos.fission.AbstractService;
import cj.netos.fission.IRecommendedService;
import cj.netos.fission.model.Recommended;
import cj.netos.fission.model.Utils;
import cj.studio.ecm.annotation.CjService;

@CjService(name = "recommendedService")
public class RecommendedService extends AbstractService implements IRecommendedService {
    static final String _COL = "fission.mf.recommendeds";

    /**
     * 被抢过才算是推荐过
     *
     * @param person
     * @param friend
     */
    @Override
    public void snatch(String person, String friend) {
        if (getHome().tupleCount(_COL, String.format("{'tuple.person':'%s','tuple.friend':'%s'}", person, friend)) > 0) {
            return;
        }
        Recommended recommended = new Recommended();
        recommended.setPerson(person);
        recommended.setFriend(friend);
        recommended.setCtime(Utils.timeToStr(System.currentTimeMillis()));
        getHome().saveDoc(_COL, new TupleDocument<>(recommended));
    }
}
