package mapper;

import pojo.User;

import java.util.List;

/**
 * @author jiaqian
 */
public interface UserMapper {
    /**
     * 查询用户
     *
     * @param id
     * @return
     */

    User selectById(Integer id);


    /**
     * 添加用户
     *
     * @param id
     * @return
     */

    int addUser(Integer id);


    /**
     * 根据名称模糊查询
     *
     * @param name
     * @return
     */
    List<User> getUserList(String name);


    /**
     * 根据id批量删除
     *
     * @param ids
     * @return
     */
    int delUser(List<Integer> ids);
}
