package cn.ssm.xhchen.mapper;

import cn.ssm.xhchen.po.Orders;

/**
 * 
 * ClassName: OrdersMapper
 * 
 * @Description: Orders的mapper接口
 * @author XHChen
 * @date 2018年10月17日 下午5:11:51
 */
public interface OrdersMapper {

	// 添加
	public void insertOrders(Orders user) throws Exception;

	// 修改
	public void updateOrders(Orders user) throws Exception;

	// 删除
	public void deleteOrders(int id) throws Exception;

	// 通过id查询
	public Orders findOrdersById(int id) throws Exception;

}
