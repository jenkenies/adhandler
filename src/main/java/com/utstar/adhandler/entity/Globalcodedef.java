package com.utstar.adhandler.entity;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table globalcodedef
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class Globalcodedef implements Serializable {
    /**
     * Database Column Remarks:
     *   pirmary key
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column globalcodedef.GLOBALCODEDEFID
     *
     * @mbg.generated
     */
    private Integer globalcodedefid;

    /**
     * Database Column Remarks:
     *   '0' – 默认匹配 
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column globalcodedef.OWNERTYPE
     *
     * @mbg.generated
     */
    private String ownertype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column globalcodedef.OWNERID
     *
     * @mbg.generated
     */
    private Integer ownerid;

    /**
     * Database Column Remarks:
     *   not null 1:¨C program 2: mediacontent 3:channel 4: schedule	5:bundledcontent	7:physicalchannel	
     *   		8:category	11:series	13:picture	23:iptvpackage	24:iptvproduct	25:contentservice	26:htmlcontent
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column globalcodedef.OBJECTTYPE
     *
     * @mbg.generated
     */
    private String objecttype;

    /**
     * Database Column Remarks:
     *   prefix of the global code
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column globalcodedef.PREFIX
     *
     * @mbg.generated
     */
    private String prefix;

    /**
     * Database Column Remarks:
     *   1:by objectid 2:by sequence (reserved)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column globalcodedef.BODYTYPE
     *
     * @mbg.generated
     */
    private String bodytype;

    /**
     * Database Column Remarks:
     *   1:auto size 2:fixed size
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column globalcodedef.BODYFORMAT
     *
     * @mbg.generated
     */
    private String bodyformat;

    /**
     * Database Column Remarks:
     *   when bodyformat is 2, it is available
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column globalcodedef.BODYLENGTH
     *
     * @mbg.generated
     */
    private Integer bodylength;

    /**
     * Database Column Remarks:
     *   suffix of the global code
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column globalcodedef.SUFFIX
     *
     * @mbg.generated
     */
    private String suffix;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column globalcodedef.GLOBALCODEDEFID
     *
     * @return the value of globalcodedef.GLOBALCODEDEFID
     *
     * @mbg.generated
     */
    public Integer getGlobalcodedefid() {
        return globalcodedefid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column globalcodedef.GLOBALCODEDEFID
     *
     * @param globalcodedefid the value for globalcodedef.GLOBALCODEDEFID
     *
     * @mbg.generated
     */
    public void setGlobalcodedefid(Integer globalcodedefid) {
        this.globalcodedefid = globalcodedefid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column globalcodedef.OWNERTYPE
     *
     * @return the value of globalcodedef.OWNERTYPE
     *
     * @mbg.generated
     */
    public String getOwnertype() {
        return ownertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column globalcodedef.OWNERTYPE
     *
     * @param ownertype the value for globalcodedef.OWNERTYPE
     *
     * @mbg.generated
     */
    public void setOwnertype(String ownertype) {
        this.ownertype = ownertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column globalcodedef.OWNERID
     *
     * @return the value of globalcodedef.OWNERID
     *
     * @mbg.generated
     */
    public Integer getOwnerid() {
        return ownerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column globalcodedef.OWNERID
     *
     * @param ownerid the value for globalcodedef.OWNERID
     *
     * @mbg.generated
     */
    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column globalcodedef.OBJECTTYPE
     *
     * @return the value of globalcodedef.OBJECTTYPE
     *
     * @mbg.generated
     */
    public String getObjecttype() {
        return objecttype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column globalcodedef.OBJECTTYPE
     *
     * @param objecttype the value for globalcodedef.OBJECTTYPE
     *
     * @mbg.generated
     */
    public void setObjecttype(String objecttype) {
        this.objecttype = objecttype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column globalcodedef.PREFIX
     *
     * @return the value of globalcodedef.PREFIX
     *
     * @mbg.generated
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column globalcodedef.PREFIX
     *
     * @param prefix the value for globalcodedef.PREFIX
     *
     * @mbg.generated
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column globalcodedef.BODYTYPE
     *
     * @return the value of globalcodedef.BODYTYPE
     *
     * @mbg.generated
     */
    public String getBodytype() {
        return bodytype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column globalcodedef.BODYTYPE
     *
     * @param bodytype the value for globalcodedef.BODYTYPE
     *
     * @mbg.generated
     */
    public void setBodytype(String bodytype) {
        this.bodytype = bodytype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column globalcodedef.BODYFORMAT
     *
     * @return the value of globalcodedef.BODYFORMAT
     *
     * @mbg.generated
     */
    public String getBodyformat() {
        return bodyformat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column globalcodedef.BODYFORMAT
     *
     * @param bodyformat the value for globalcodedef.BODYFORMAT
     *
     * @mbg.generated
     */
    public void setBodyformat(String bodyformat) {
        this.bodyformat = bodyformat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column globalcodedef.BODYLENGTH
     *
     * @return the value of globalcodedef.BODYLENGTH
     *
     * @mbg.generated
     */
    public Integer getBodylength() {
        return bodylength;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column globalcodedef.BODYLENGTH
     *
     * @param bodylength the value for globalcodedef.BODYLENGTH
     *
     * @mbg.generated
     */
    public void setBodylength(Integer bodylength) {
        this.bodylength = bodylength;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column globalcodedef.SUFFIX
     *
     * @return the value of globalcodedef.SUFFIX
     *
     * @mbg.generated
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column globalcodedef.SUFFIX
     *
     * @param suffix the value for globalcodedef.SUFFIX
     *
     * @mbg.generated
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}