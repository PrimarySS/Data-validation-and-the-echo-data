package cn.ssm.xhchen.mapper;

import cn.ssm.xhchen.po.User;

/**
 * 
 * ClassName: UserMapper
 * 
 * @Description: User的mapper接口
 * @author XHChen
 * @date 2018年10月17日 下午5:11:51
 */
public interface UserMapper {

	// 添加
	public void insertUser(User user) throws Exception;

	// 修改
	public void updateUser(User user) throws Exception;

	// 删除
	public void deleteUser(int id) throws Exception;

	// 通过id查询
	public User findUserById(int id) throws Exception;

}
