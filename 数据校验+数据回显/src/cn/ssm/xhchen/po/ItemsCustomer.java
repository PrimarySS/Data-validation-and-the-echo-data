package cn.ssm.xhchen.po;

import java.util.Date;

/**
 * 
 * ClassName: Items
 * 
 * @Description: 商品信息po拓展类
 * @author XHChen
 * @date 2018年10月17日 下午5:09:14
 */
public class ItemsCustomer extends Items {

	// 添加拓展属性

	private Date items_creattime; // 商品生产时间

	public Date getItems_creattime() {
		return items_creattime;
	}

	public void setItems_creattime(Date items_creattime) {
		this.items_creattime = items_creattime;
	}

	@Override
	public String toString() {
		return "ItemsCustomer [toString()=" + super.toString()
				+ ", items_creattime=" + items_creattime + "]";
	}

}
