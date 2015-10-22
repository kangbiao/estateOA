package estate.service;

import estate.entity.app.BindPropertyAppUser;
import estate.entity.database.OwnerEntity;
import estate.entity.database.PropertyOwnerInfoEntity;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-10-13.
 *
 */
public interface PropertyOwnerService
{
    /**
     * 通过业主的电话和物业ID删除对应的业主物业绑定关系<br/>
     * 同时会查询该业主是否还绑定有其他物业,如果没有,则会从app用户中将该业主的账号删除<br/>
     *
     * @param phone
     * @param propertyID
     */
    void deleteOwnerPropertyBind(String phone,Integer propertyID);

    /**
     * 通过用户的电话返回用户的角色
     * @param phone
     * @return
     */
    String getRoleStringByPhone(String phone);

    /**
     * 通过用户电话返回用户物业关系
     * @param phone
     * @return
     */
    ArrayList<PropertyOwnerInfoEntity> getByPhone(String phone);

    /**
     * 通过物业的id获取绑定到该物业的用户信息
     * @param propertyID
     * @param status 业主是否同意审核
     * @return
     */
    ArrayList<PropertyOwnerInfoEntity> getBindBypropertyIDStatus(Integer propertyID,Byte status);

    /**
     * 根据业主的电话获取该业主名下物业的所有绑定
     * @param phone
     * @param status 审核状态
     * @return
     */
    ArrayList<BindPropertyAppUser> getBindInfoByOwnerInfo(String phone,Byte status);


    /**
     * 给物业增加业主,如果该业主信息则更新,否则创建
     * @param ownerEntity
     * @param propertyID
     * @return 成功则返回succ,其余为错误信息
     */
    String addOwnerToProperty(OwnerEntity ownerEntity,Integer propertyID);

}
