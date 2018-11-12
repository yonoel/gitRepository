package com.igeek.domain;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "`master`")
public class Master implements Serializable{
    /**  
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
    */  
    private static final long serialVersionUID = 4593726508409491160L;

    @Column(name = "`key_name`")
    private String keyName;

    @Column(name = "`code_no`")
    private String codeNo;

    @Column(name = "`code_name`")
    private String codeName;

    /**
     * @return key_name
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * @param keyName
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    /**
     * @return code_no
     */
    public String getCodeNo() {
        return codeNo;
    }

    /**
     * @param codeNo
     */
    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    /**
     * @return code_name
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * @param codeName
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}