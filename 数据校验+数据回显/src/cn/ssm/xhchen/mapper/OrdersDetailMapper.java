package cn.ssm.xhchen.mapper;

import cn.ssm.xhchen.po.OrdersDetail;

/**
 * 
 * ClassName: OrdersDetailMapper
 * 
 * @Description: OrdersDetail��mapper�ӿ�
 * @author XHChen
 * @date 2018��10��17�� ����5:11:51
 */
public interface OrdersDetailMapper {

	// ���
	public void insertOrdersDetail(OrdersDetail ordersDetail) throws Exception;

	// �޸�
	public void updateOrdersDetail(OrdersDetail ordersDetail) throws Exception;

	// ɾ��
	public void deleteOrdersDetail(int id) throws Exception;

	// ͨ��id��ѯ
	public OrdersDetail findOrdersDetailById(int id) throws Exception;

}
