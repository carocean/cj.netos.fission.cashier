package cj.netos.fission;

import cj.lns.chip.sos.cube.framework.CubeConfig;
import cj.lns.chip.sos.cube.framework.ICube;
import cj.lns.chip.sos.disk.INetDisk;
import cj.studio.ecm.CJSystem;
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
        try {
            return disk.cube(name);
        } catch (Exception e) {
            if (!disk.existsCube(name)) {
                CubeConfig cubeConfig = new CubeConfig();
                disk.createCube(name,cubeConfig);
                CJSystem.logging().info(getClass(),String.format("网盘已创建:%s",name));
            }
            return disk.cube(name);
        }
    }
}
