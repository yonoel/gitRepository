package com.web.listener;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @ClassName: Demo01
 * @Description: TODO(������һ�仰��������������)
 * @date 2018��7��5�� ����8:41:34
 * 
 */
public class Demo01 {
    /**
     * java���¼��������� 1���¼������漰������������¼�Դ���¼������¼�������
     * 2�����¼�Դ�Ϸ���ĳһ������ʱ����������¼���������һ�����������ڵ��ø÷���ʱ���¼����󴫵ݽ�ȥ��
     * ������Ա�ڼ�������ͨ���¼����󣬾Ϳ����õ��¼�Դ���Ӷ����¼�Դ���в�����
     */
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setSize(400, 400);
        f.setVisible(true);

        // ע���¼�������
        f.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            /**
             * ��window����ر�ʱ�ͻ�WindowListener�����������������
             * �������ͻ����windowClosing��������window����ر�ʱ�Ķ���
             */
            @Override
            public void windowClosing(WindowEvent e) {
                // ͨ���¼�����e����ȡ�¼�Դ����
                Frame f = (Frame) e.getSource();
                System.out.println(f + "�������ڹر�");
                f.dispose();

            }

            @Override
            public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }
}
