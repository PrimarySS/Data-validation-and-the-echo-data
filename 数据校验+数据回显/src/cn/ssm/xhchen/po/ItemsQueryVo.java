package cn.ssm.xhchen.po;

import java.util.List;

import javax.validation.Valid;

/**
 * 
 * ClassName: ItemsQueryVo
 * 
 * @Description: 商品信息包装类
 * @author XHChen
 * @date 2018年10月17日 下午8:03:46
 */
public class ItemsQueryVo {

	// 商品信息
	private Items items;

	// 系统拓展性，对原始po进行拓展
	private ItemsCustomer itemsCustomer;

	// 接收数组，属性名要和页面name保持一致
	private Integer[] items_ids;

	// 接受list集合,批量商品信息
	@Valid
	private List<ItemsCustomer> itemsList;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustomer getItemsCustomer() {
		return itemsCustomer;
	}

	public void setItemsCustomer(ItemsCustomer itemsCustomer) {
		this.itemsCustomer = itemsCustomer;
	}

	public Integer[] getItems_ids() {
		return items_ids;
	}

	public void setItems_ids(Integer[] items_ids) {
		this.items_ids = items_ids;
	}

	public List<ItemsCustomer> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustomer> itemsList) {
		this.itemsList = itemsList;
	}

	@Override
	public String toString() {
		return "ItemsQueryVo [items=" + items + ", itemsCustomer="
				+ itemsCustomer + "]";
	}

}
