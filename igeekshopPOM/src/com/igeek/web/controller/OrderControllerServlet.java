package com.igeek.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.igeek.domain.Orderitem;
import com.igeek.domain.Orders;
import com.igeek.service.IOrderitemServices;
import com.igeek.service.IOrdersServices;
import com.igeek.service.impl.OrderitemServicesImpl;
import com.igeek.service.impl.OrdersServicesImpl;
import com.igeek.web.util.OrdersDTO;
import com.igeek.web.util.ProductDTO;
import com.igeek.web.util.WebUtils;

/**
 * Servlet implementation class OrderControllerServlet
 */
@WebServlet("/orderController")
public class OrderControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("methodflag");
        if (method.contains("addOrderitems")) {
            addOrderitems(request, response);
        } else if (method.contains("confirmorderitems")) {
            try {
                confirmOrderitems(request, response);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (method.contains("createorder")) {
            try {
                createOrder(request, response);
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * @Title: createOrder
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param request
     * @param response
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private void createOrder(HttpServletRequest request, HttpServletResponse response)
            throws IllegalAccessException, InvocationTargetException {
        String oid = request.getParameter("oid");
        // 获取订单对象
        List<OrdersDTO> oList = (List<OrdersDTO>) request.getSession().getAttribute("orderList");
        // 调用service层，写入数据
        boolean oflag = true;
        String msg = null;
        boolean flag = false;
        for (OrdersDTO ordersDTO : oList) {
            oflag = createOrders(request, ordersDTO);
            if (!oflag) {
                msg = "生成订单失败";
                break;
            }
        }
        if (oflag) {
            msg = "生成订单成功";
            flag = true;
            // 清空session的值
            oList.removeIf(p -> p.getOid().equals(oid));
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", flag);
        map.put("message", msg);
        map.put("oid", oid);
        // 将map转换成json字符串写到页面上
        WebUtils.object2Json(map, response);

    }

    /**
     * @Title: createOrders
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param request
     * @param oList
     * @param ordersServices
     * @param orderitemServices
     * @param ordersDTO
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public boolean createOrders(HttpServletRequest request, OrdersDTO ordersDTO)
            throws IllegalAccessException, InvocationTargetException {

        Orders orders = WebUtils.request2Bean(request, Orders.class);
        BeanUtils.copyProperties(orders, ordersDTO);
        orders.setOrdertime(new Date(System.currentTimeMillis()));
        orders.setState(0);
        IOrdersServices ordersServices = new OrdersServicesImpl();
        int oflag = ordersServices.creatNewOrder(orders);
        int iflag = 0;
        IOrderitemServices orderitemServices = new OrderitemServicesImpl();
        // orderitems
        List<ProductDTO> productDTOs = ordersDTO.getProductDTOs();
        for (ProductDTO productDTO : productDTOs) {
            Orderitem orderitem = new Orderitem();
            orderitem.setItemid(WebUtils.makeId());
            orderitem.setOid(orders.getOid());
            orderitem.setCount(productDTO.getQuantity());
            BeanUtils.copyProperties(orderitem, productDTO);
            iflag += orderitemServices.creatNewOrderitem(orderitem);
        }
        if ((oflag + iflag) != productDTOs.size() + 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @Title: confirmOrderitems
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param request
     * @param response
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IOException
     * @throws ServletException
     */
    private void confirmOrderitems(HttpServletRequest request, HttpServletResponse response)
            throws InstantiationException, IllegalAccessException, InvocationTargetException, ServletException,
            IOException {
        // 这个map里有PIDs这个数组，包含了所有的pid还有prices,quantities ，三个数组,quantities注定不相同
        // 需要把这三个数组，拆开来，封装成ProductDTO.java ---
        // >其实每次提交必定是一个oid，pid,prices,quantities....oid，所以可以以oid分割
        /*
         * Map<String, String[]> map = request.getParameterMap(); String[] pids
         * = request.getParameterValues("pids");
         * 
         * String[] quantities = request.getParameterValues("quantities");
         */

        List<ProductDTO> productDTOs = WebUtils.request2List(request, ProductDTO.class);
        List<OrdersDTO> oList = (List<OrdersDTO>) request.getSession().getAttribute("orderList");

        // 对每一个orders进行比对.不比了，直接填吧,否则是要一步步匹配哪一个orders
        String[] oids = request.getParameterValues("oids");
        // OrdersDTO ordersDTO = oList.get(0);
        // 把勾选的参数扔进这个订单列表
        /*
         * Set<Entry<String, List<ProductDTO>>> set = maps.entrySet(); for (int
         * i = 0; i < oids.length; i++) { String oid = oids[i]; // oList根据oid取
         * OrdersDTO ,maps //
         * 根据oid取List<ProductDTO>，然后置换OrdersDTO里的List<ProductDTO>
         * oList.stream().filter(p ->
         * p.getOid().equals(oid)).findAny().orElse(new OrdersDTO())
         * .setProductDTOs(maps.get(oid)); }
         */

        OrdersDTO orders = new OrdersDTO();
        orders.setOid(oids[0]);
        orders.setProductDTOs(productDTOs);

        request.setAttribute("orders", orders);
        oList.get(0).getProductDTOs().clear();
        oList.get(0).getProductDTOs().addAll(productDTOs);

        request.getRequestDispatcher("order_info.jsp").forward(request, response);
    }

    /**
     * @Title: doOrderitems
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void addOrderitems(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 提交表productDTO对象直接封装--》session是否为new ————》有没有 列表（修改数量） ——————》返回展示

        ProductDTO productDTO = WebUtils.request2Bean(request, ProductDTO.class);

        // (可能在一个session里有N个orders，那说明seesion域里放的绝不一个ordersDto，而是一个列表)
        HttpSession session = request.getSession();
        OrdersDTO ordersDTO = null;
        List<OrdersDTO> oList = null;
        // 新的session
        if (session.isNew()) {
            oList = new ArrayList<OrdersDTO>();
            ordersDTO = new OrdersDTO();
            ordersDTO.setOid(WebUtils.makeId());
            ordersDTO.getProductDTOs().add(0, productDTO);

            oList.add(0, ordersDTO);
        }
        // 如果是过去的session
        oList = (List<OrdersDTO>) session.getAttribute("orderList");
        // 1.判断过去有没有orders
        if (oList == null || oList.isEmpty()) {
            // 没有那也要初始化
            oList = new ArrayList<OrdersDTO>();
            ordersDTO = new OrdersDTO();
            ordersDTO.setOid(WebUtils.makeId());
            ordersDTO.getProductDTOs().add(0, productDTO);
            oList.add(0, ordersDTO);

        } else {
            // 有orders列表并且有 订单，继续追加项目
            ordersDTO = oList.get(0);
            if (!ordersDTO.getProductDTOs().contains(productDTO)) {
                // 此订单里没有这个商品
                ordersDTO.getProductDTOs().add(0, productDTO);

            } else {
                // 此订单里有这个商品 取这个商品修改数量
                ProductDTO oldProductDTO = ordersDTO.getProductDTOs().stream()
                        .filter(p -> p.getPid().equals(productDTO.getPid())).findAny().get();
                // 追加数量
                oldProductDTO.setQuantity(oldProductDTO.getQuantity() + productDTO.getQuantity());

            }

        }

        // 对订单对象操作完—>保存在session 里,跳转页面
        session.setAttribute("orderList", oList);
        response.sendRedirect("cart.jsp");

        // // 1 取 订单对象，没有创建新的,有就继续调用
        // Orders order = (Orders) request.getSession().getAttribute("order");
        // if (order == null) {
        // IOrdersServices ordersServices = new OrdersServicesImpl();
        // order = ordersServices.creatNewOrder();
        //
        // }
        // // 2. 对item进行 增删创 操作
        // IOrderitemServices orderitemServices = new OrderitemServicesImpl();
        // // 如果有，查询这个订单对象里有没有这个商品id
        // if (!orderitemServices.queryItemExsit(pid, order.getOid())) {
        // // 非 说明没有有这个订单项目-->追加一个订单项目
        // orderitem = orderitemServices.creatNewOrderitem(pid, num, order);
        // } else {
        // // 真 说明有这个项目-->修改数量和金额
        // orderitem = orderitemServices.updataItem(pid, num, order);
        // }
        //
        // // 3.把这个列表里的product放进session里
        // HttpSession session = request.getSession();
        //
        // // 跳转页面,session里存放所有购买的列表项目
        // Map<Product, Integer> map = (Map<Product, Integer>)
        // session.getAttribute("buyMap");
        // if (map == null) {
        // map = new LinkedHashMap<Product, Integer>();
        // }
        //
        // IProductServices productServices = new ProductServicesImpl();
        // Product product = (Product)
        // productServices.queryProductInfo(pid).get("object");
        // // 如果重复
        // if (map.containsKey(product)) {
        // map.put(product, map.get(product) + 1);
        // }
        // map.put(product, 1);
        // session.setAttribute("buyMap", map);
        //
        // if (orderitem != null) {
        // WebUtils.object2Json(true, response);
        // } else {
        // WebUtils.object2Json(false, response);
        // }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
