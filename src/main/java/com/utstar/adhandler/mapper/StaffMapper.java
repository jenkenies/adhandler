package com.utstar.adhandler.mapper;

import com.utstar.adhandler.entity.Staff;
import com.utstar.adhandler.entity.StaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table staff
     *
     * @mbg.generated
     */
    long countByExample(StaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table staff
     *
     * @mbg.generated
     */
    int deleteByExample(StaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table staff
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer staffid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table staff
     *
     * @mbg.generated
     */
    int insert(Staff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table staff
     *
     * @mbg.generated
     */
    int insertSelective(Staff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table staff
     *
     * @mbg.generated
     */
    List<Staff> selectByExample(StaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table staff
     *
     * @mbg.generated
     */
    Staff selectByPrimaryKey(Integer staffid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table staff
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table staff
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Staff record, @Param("example") StaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table staff
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Staff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table staff
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Staff record);
}