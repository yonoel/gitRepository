<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省市区三级联动AJAX</title>
<script type="text/javascript">

    $(function() {
    	
    	var cities = $('#cities');
    	var zones = $('#zones');
    
       // console.log($("#cities").length);
       
        //$("#first").change();
            // 封装方法
        $("select").each(function(i){
            $(this).on("change",function(){  
            	//console.log("this:"+this.id);
                var next = $(this).next();
                //console.log("next:"+next[0].id);
                //var pre =  $("select").eq(i-1);
                console.log("ajax被调用了");
                 $.ajax({
                        url : "/LessonAfter27Base8.5/AreaSelect",
                        data : {
                            message:"get"+next[0].id,
                            parentid: $(this).val()
                        },
                        type : "get",
                        dataType : "json",
                        async:false
                    }).done(function(data){
                        // 如果是pro->那就是cities 如果是cities->那就是zones ,共同点都是selector标签 -- >取select下一个元素
                        next.children(":not(:first)").remove();
                        next.next().children(":not(:first)").remove();
                        console.log(data);
                        console.log(this);
                        iterator(data,next);
                    
                    })
            })
        });
            // 方法没有注册，触发以后也么有方法
        $("#btn1").click(function(){
          
        	$("#first").trigger("change");
        });
        
        $("#btn1").click();
        
        // 获取provinces的
        /*$.ajax({
            url : "/LessonAfter27Base8.5/AreaSelect",
            data : {
                message : "getProvinces"
            },
            type : "get",
            dataType : "json"
        }).done(function(json){
            iterator(json,$('#provinces'));
    
        })*/
     
          //获取cities
          /*   provinces.on('change', function(event) {
            event.preventDefault();
           
            $("#citiestag option:gt(0)").remove();
            $.ajax({
                url: "/LessonAfter27Base8.5/AreaSelect",
                data: {
                    message: "getcities",
                    parentid: provinces.val(),
                },
                type: "get",
                dataType: "json"
            }).done(function(json) {
                iterator(json, cities);

            })
        }); */
        //获取zones
      /*   cities.on('change', function(event) {
            event.preventDefault();
          
           $("#zonestag option:gt(0)").remove();
            $.ajax({
                url: "/LessonAfter27Base8.5/AreaSelect",
                data: {
                    message: "getzones",
                    parentid: cities.val(),
                },
                type: "get",
                dataType: "json"
            }).done(function(json) {
                iterator(json, zones);

            })
        });
         */
        
        
    })

   
  
    function iterator(json,selector){
            if(json != null && json.length>0){
                for(var i=0;i<json.length;i++){
                    var obj = json[i];
                    //创建option元素
                    var option = "<option value='"+obj.id+"'>"+obj.name+"</option>";
                    selector.append(option);
                }
            }
            
  }
   /*  function fn1() {
    	  alert("haha");
          $("#first").trigger("change");
          alert("haha");
	} */
</script>
</head>
<body>
    <button id="btn1" >触发事件的测试</button>
    <select id="first" style="visibility: hidden;"></select>
    <select id="provinces" name="provinces">
        <option value="dochoice">请选择</option>
    </select>
    <select id="cities" name="cities">
        <option value="dochoice">请选择</option>
    </select>
    <select id="zones" name="zones">
        <option value="dochoice">请选择</option>
    </select>
</body>
</html>