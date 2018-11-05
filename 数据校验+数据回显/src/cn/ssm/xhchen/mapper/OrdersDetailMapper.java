package cn.ssm.xhchen.mapper;

import cn.ssm.xhchen.po.OrdersDetail;

/**
 * 
 * ClassName: OrdersDetailMapper
 * 
 * @Description: OrdersDetail的mapper接口
 * @author XHChen
 * @date 2018年10月17日 下午5:11:51
 */
public interface OrdersDetailMapper {

	// 添加
	public void insertOrdersDetail(OrdersDetail ordersDetail) throws Exception;

	// 修改
	public void updateOrdersDetail(OrdersDetail ordersDetail) throws Exception;

	// 删除
	public void deleteOrdersDetail(int id) throws Exception;

	// 通过id查询
	public OrdersDetail findOrdersDetailById(int id) throws Exception;

}
