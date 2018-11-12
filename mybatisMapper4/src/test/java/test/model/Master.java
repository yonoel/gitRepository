package test.model;

import javax.persistence.*;

@Table(name = "`master`")
public class Master {
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