package cj.netos.fission;

import cj.lns.chip.sos.cube.framework.ICube;
import cj.lns.chip.sos.disk.INetDisk;
import cj.studio.ecm.annotation.CjServiceRef;

public class AbstractService {
    @CjServiceRef(refByName = "mongodb.netos.home")
    ICube home;
    @CjServiceRef(refByName = "mongodb.netos")
    INetDisk disk;
    public ICube getHome() {
        return home;
    }
    public ICube cube(String name){
        return disk.cube(name);
    }
}
