package com.utstar.adhandler.mapper;

import com.utstar.adhandler.entity.Adplace;
import com.utstar.adhandler.entity.AdplaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdplaceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table adplace
     *
     * @mbg.generated
     */
    long countByExample(AdplaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table adplace
     *
     * @mbg.generated
     */
    int deleteByExample(AdplaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table adplace
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer adplaceid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table adplace
     *
     * @mbg.generated
     */
    int insert(Adplace record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table adplace
     *
     * @mbg.generated
     */
    int insertSelective(Adplace record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table adplace
     *
     * @mbg.generated
     */
    List<Adplace> selectByExample(AdplaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table adplace
     *
     * @mbg.generated
     */
    Adplace selectByPrimaryKey(Integer adplaceid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table adplace
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Adplace record, @Param("example") AdplaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table adplace
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Adplace record, @Param("example") AdplaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table adplace
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Adplace record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table adplace
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Adplace record);
}