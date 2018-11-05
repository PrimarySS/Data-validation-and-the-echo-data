package cn.ssm.xhchen.mapper;

import cn.ssm.xhchen.po.Orders;

/**
 * 
 * ClassName: OrdersMapper
 * 
 * @Description: Orders��mapper�ӿ�
 * @author XHChen
 * @date 2018��10��17�� ����5:11:51
 */
public interface OrdersMapper {

	// ���
	public void insertOrders(Orders user) throws Exception;

	// �޸�
	public void updateOrders(Orders user) throws Exception;

	// ɾ��
	public void deleteOrders(int id) throws Exception;

	// ͨ��id��ѯ
	public Orders findOrdersById(int id) throws Exception;

}
