package com.igeek.spring4;

import static java.lang.System.out;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.igeek.service.ISubjectService;
import com.igeek.serviceImpl.SubjectServicesImpl;

/**
 * @ClassName: Study
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月11日 下午3:17:18
 * 
 */
public class Study {
    public static void main(String[] args) {

        /*
         * try {
         * 
         * Method getScore = SubjectDTO.class.getMethod("getScore");
         * out.println(getScore.getName()); } catch (Exception e) { // TODO
         * Auto-generated catch block e.printStackTrace(); }
         */

        ISubjectService impl = (ISubjectService) Proxy.newProxyInstance(SubjectServicesImpl.class.getClassLoader(),
                new Class[] { ISubjectService.class }, new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                       
                        out.println("proxy name :" + proxy.getClass().getName());
                        out.println("method name :" + method.getName());
                        out.println("args name :" + proxy.getClass().getName());
                        return null;
                    }
                });
        out.println(impl);
    }

    /*
     * java.lang.reflect.Method[] methods = SubjectDTO.class.getMethods(); for
     * (java.lang.reflect.Method method : methods) {
     * out.println(method.getName()); }
     */
    // java.lang.reflect.Method getAnswer = clasz.getMethod("getAnswer",
    // null);
    /*
     * SubjectDTO subjectDTO = new SubjectDTO(); Object object =
     * subjectDTO.getClass().asSubclass(subjectDTO.getClass().getSuperclass( ));
     * 
     * int length = subjectDTO.getClass().getClasses().length; Class father =
     * Subject.class; length = father.getDeclaredClasses().length; boolean flag
     * = father.isMemberClass(); err.print(flag); err.print(length);
     * out.print(subjectDTO.getClassName());
     */
    /*
     * Type[] types = SubPaperServiceImpl.class.getGenericInterfaces(); for (int
     * i = 0; i < types.length; i++) { System.out.println(types[i]); }
     */
    /*
     * ResolvableType resolvableType1 =
     * ResolvableType.forClass(SubPaperServiceImpl.class);
     * System.out.println(resolvableType1.getType());
     */
    /*
     * Object object = new Object();
     * System.out.println(object.getClass().getSuperclass());
     */

}