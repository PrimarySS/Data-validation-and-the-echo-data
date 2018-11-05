package cn.ssm.xhchen.mapper;

import cn.ssm.xhchen.po.Items;

/**
 * 
 * ClassName: ItemsMapper
 * 
 * @Description: Items的mapper接口
 * @author XHChen
 * @date 2018年10月17日 下午5:11:51
 */
public interface ItemsMapper {

	// 添加
	public void insertItems(Items items) throws Exception;

	// 修改
	public void updateItems(Items items) throws Exception;

	// 删除
	public void deleteItems(int id) throws Exception;

	// 通过id查询
	public Items findItemsById(int id) throws Exception;

}
