package cn.ssm.xhchen.mapper;

import cn.ssm.xhchen.po.User;

/**
 * 
 * ClassName: UserMapper
 * 
 * @Description: User��mapper�ӿ�
 * @author XHChen
 * @date 2018��10��17�� ����5:11:51
 */
public interface UserMapper {

	// ���
	public void insertUser(User user) throws Exception;

	// �޸�
	public void updateUser(User user) throws Exception;

	// ɾ��
	public void deleteUser(int id) throws Exception;

	// ͨ��id��ѯ
	public User findUserById(int id) throws Exception;

}
