package cj.netos.fission.service;

import cj.lns.chip.sos.cube.framework.TupleDocument;
import cj.netos.fission.AbstractService;
import cj.netos.fission.IUpdateManager;
import cj.netos.fission.UpdateEvent;
import cj.studio.ecm.annotation.CjService;

/**
说明
<pre>
- 更新位置 website&cashier
	参数：用户标识、位置
- 更新余额
	* 充值 cashier
	* 提现 cashier
	* 收益 cashier
	* 支付 cashier
      统一个事件，参数：用户标识、动作（无意义，但保留）
- 添加属性标签 website&cashier
	参数：用户标识、动作、标签
- 移除属性标签 website&cashier
	参数：用户标识、动作、标签
- 添加地域限定 cashier
	参数：用户标识、动作、地域类型、地域代码
- 移除地域限定 cashier
	参数：用户标识、动作、地域类型、地域代码
- 添加标签限定 cashier
	参数：用户标识、动作、标签
- 移除标签限定 cashier
	参数：用户标识、动作、标签
 </pre>
 */
@CjService(name = "updateManager")
public class UpdateManager extends AbstractService implements IUpdateManager {
    static final String _COL="fission.mf.update.events" ;
    @Override
    public void addEvent(UpdateEvent event) {
        getHome().saveDoc(_COL, new TupleDocument<>(event));
    }
}
