package cn.ssm.xhchen.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ssm.xhchen.mapper.ItemsMapper;
import cn.ssm.xhchen.mapper.ItemsMapperCustomer;
import cn.ssm.xhchen.po.Items;
import cn.ssm.xhchen.po.ItemsCustomer;
import cn.ssm.xhchen.po.ItemsQueryVo;
import cn.ssm.xhchen.service.ItemsService;

/**
 * 
 * ClassName: ItemsServiceImpl
 * 
 * @Description: Items管理实现
 * @author XHChen
 * @date 2018年10月17日 下午8:50:58
 */
public class ItemsServiceImpl implements ItemsService {

	// applicationContext-dao.xml已通过包扫描配置了ItemsMapperCustomer
	@Autowired
	private ItemsMapperCustomer itemsMapperCustomer;
	
	// 自动注入ItemsMapper接口
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	/**
	 * 通过itemsQueryVo查询商品信息
	 */
	public List<ItemsCustomer> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {

		// 通过ItemsMapperCustomer查询数据库
		return itemsMapperCustomer.findItemsList(itemsQueryVo);
	}

	
	@Override
	/**
	 * 根据id查询商品信息
	 */
	public ItemsCustomer findItemsById(Integer id) throws Exception {
		
		// 根据id查询商品信息
		Items items = itemsMapper.findItemsById(id);
		
		// 创建ItemsCustomer对象
		ItemsCustomer itemsCustomer = new ItemsCustomer();
		
		// 把商品信息items复制到itemsCustomer
		BeanUtils.copyProperties(items, itemsCustomer);
		
		// 返回拓展类ItemsCustomer
		return itemsCustomer;
	}

	
	@Override
	/**
	 * 修改商品信息
	 */
	public void updateItems(Integer id, ItemsCustomer itemsCustomer) throws Exception {

		// 设置修改商品id
		itemsCustomer.setId(id);
		
		// 修改商品信息
		itemsMapper.updateItems(itemsCustomer);
		
	}
	
	
	@Override
	/**
	 * 根据id删除商品
	 */
	public void deleteItemsById(Integer id) throws Exception {
		
		// 调用itemsMapper接口方法
		itemsMapper.deleteItems(id);
	}

	
	@Override
	/**
	 * 单个删除数组商品信息
	 */
	public void deleteItemsArray(Integer[] items_ids) throws Exception {
		
		// 每次传一个id值删除
		try {
			for (Integer id : items_ids) {
				// 调用itemsMapper接口方法
				itemsMapper.deleteItems(id);
			}
		} catch (Exception e) {
			// 输出错误日志
			System.out.println(e.getMessage());
		}
	}

	
	@Override
	/**
	 * 一次性删除商品信息
	 */
	public void deleteItemsArrayAllIn(Integer[] items_ids) throws Exception {
		
		// 调用itemsMapperCustomer接口方法
		itemsMapperCustomer.deleteItemsArrayAllIn(items_ids);
	}
	
	
	@Override
	/**
	 * 逐条提交批量修改商品信息
	 */
	public void updateAllItems(List<ItemsCustomer> itemsList) throws Exception {
		
		try {
			for (ItemsCustomer itemsCustomer : itemsList) {
				// 调用itemsMapper接口方法
				itemsMapper.updateItems(itemsCustomer);
			}
		} catch (Exception e) {
			// 输出错误日志
			System.out.println(e.getMessage());
		}
	}

	
	@Override
	/**
	 * 一次性提交批量修改商品信息
	 */
	public void updateAllItemsSubmit(List<ItemsCustomer> itemsList) throws Exception {
		
		// 调用itemsMapperCustomer接口方法
		itemsMapperCustomer.updateAllItemsSubmit(itemsList);
	}

}
