package cn.ssm.xhchen.service;

import java.util.List;

import cn.ssm.xhchen.po.ItemsCustomer;
import cn.ssm.xhchen.po.ItemsQueryVo;

/**
 * 
 * ClassName: ItemsService
 * 
 * @Description: Items管理接口
 * @author XHChen
 * @date 2018年10月17日 下午8:49:43
 */
public interface ItemsService {

	/**
	 * 
	 * @Description: 商品列表查询
	 * @param @param itemsQueryVo 封装商品信息的类
	 * @param @return
	 * @param @throws Exception
	 * @return List<ItemsCustomer> 数据库返回的值映射到ItemsCustomer
	 * @throws
	 * @author XHChen
	 * @date 2018年10月20日 下午8:23:28
	 */
	public List<ItemsCustomer> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

	/**
	 * 
	 * @Description: 找到修改商品信息
	 * @param @param id 查询商品的id
	 * @param @return
	 * @param @throws Exception
	 * @return ItemsCustomer
	 * @throws
	 * @author XHChen
	 * @date 2018年10月20日 下午8:23:06
	 */
	public ItemsCustomer findItemsById(Integer id) throws Exception;

	/**
	 * 
	 * @Description: 修改商品信息
	 * @param @param id 修改商品的id
	 * @param @param itemsCustomer 修改商品的信息
	 * @param @throws Exception
	 * @return void
	 * @throws
	 * @author XHChen
	 * @date 2018年10月20日 下午8:23:00
	 */
	public void updateItems(Integer id, ItemsCustomer itemsCustomer) throws Exception;
	
	/**
	 * 
	 * @Description: 根据id删除商品
	 * @param @param id   
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018年11月2日 上午9:37:38
	 */
	public void deleteItemsById(Integer id) throws Exception;

	/**
	 * 
	 * @Description: 逐次删除数组商品信息
	 * @param @param items_id 商品id
	 * @return void
	 * @throws
	 * @author XHChen
	 * @date 2018年10月26日 上午11:22:56
	 */
	public void deleteItemsArray(Integer[] items_id) throws Exception;
	
	/**
	 * 
	 * @Description: 一次性删除商品信息
	 * @param @param items_ids
	 * @param @throws Exception   
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018年10月27日 上午11:33:32
	 */
	public void deleteItemsArrayAllIn(Integer[] items_ids) throws Exception;

	/**
	 * 
	 * @Description:逐次提交批量修改商品信息
	 * @param @param itemsList   
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018年10月27日 上午10:16:57
	 */
	public void updateAllItems(List<ItemsCustomer> itemsList) throws Exception;

	/**
	 * 
	 * @Description: 一次性提交批量修改商品信息
	 * @param @param itemsList   
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018年10月27日 上午10:47:18
	 */
	public void updateAllItemsSubmit(List<ItemsCustomer> itemsList) throws Exception;

}
