package com.i18n_study;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @ClassName: I18NTest
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��5�� ����1:30:32
 * 
 */
public class I18NTest {
    public static void main(String[] args) {
        // ��Դ������(����+myproperties)
        String basename = "com.i18n_study.resources.myproperties";
        // �������Ի���
        Locale cn = Locale.CHINA;// ����
        Locale us = Locale.US;// Ӣ��
        // ���ݻ��������Ի������ض�Ӧ��������Դ�ļ�
        ResourceBundle myResourcesCN = ResourceBundle.getBundle(basename, cn);// ����myproperties_zh.properties
        ResourceBundle myResourcesUS = ResourceBundle.getBundle(basename, us);// ����myproperties_en.properties

        // ������Դ�ļ��� ����Ϳ��Ե���ResourceBundleʵ������� getString������ȡָ������Դ��Ϣ��������Ӧ��ֵ��
        String usernameCN = myResourcesCN.getString("username");
        String passwordCN = myResourcesCN.getString("password");

        String usernameUS = myResourcesUS.getString("username");
        String passwordUS = myResourcesUS.getString("password");

        System.out.println(usernameCN + "--" + passwordCN);
        System.out.println(usernameUS + "--" + passwordUS);
    }
}
