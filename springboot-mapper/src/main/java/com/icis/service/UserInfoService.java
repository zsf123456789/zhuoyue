package com.icis.service;

import com.icis.pojo.UserInfo;

import java.util.List;

//用户service层接口
public interface UserInfoService {
    /*
    * 方法：List<T> select(T record);
说明：根据实体中的属性值进行查询，查询条件使用等号

方法：T selectByPrimaryKey(Object key);
说明：根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号

方法：List<T> selectAll();
说明：查询全部结果，select(null)方法能达到同样的效果

方法：T selectOne(T record);
说明：根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号

方法：int selectCount(T record);
说明：根据实体中的属性查询总数，查询条件使用等号
    * */
    //查询所有用户数据
    public List<UserInfo> findAll();

    //根据用户属性字段查询用户
    public List<UserInfo> findByUserInfo(UserInfo userInfo);

    //根据用户name属性模糊查询
    public List<UserInfo> findByUserLike(UserInfo userInfo);

    //保存用户
    public void addUser(UserInfo userInfo);

    //有选择的保存用户 null不添加
    void addUserSelective(UserInfo userInfo);

    //根据主键更新用户 null值会被更新
    void updateUser(UserInfo userInfo);

    //根据主键更新属性不为null的值
    void updateUserSelective(UserInfo userInfo);

    //根据主键属性删除用户 参数必须包含完整的主键属性
    void deleteUserByKey(UserInfo userInfo);

    //根据实体字段属性作为条件删除用户  查询条件使用等号
    void deleteUserByUser(UserInfo userInfo);
    //根据实体中的属性查询总数 查询条件用等号
    Integer selectCountByUser(UserInfo userInfo);
    //根据name属性模糊查询用户
    Integer selectCountByNameLike(UserInfo userInfo);
}
