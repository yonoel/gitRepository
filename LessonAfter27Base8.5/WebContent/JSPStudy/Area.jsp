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
		var provinces = $('#provincestag');
	    var cities = $('#citiestag');
	    var zones = $('#zonestag');
	    
		// 获取provinces的值--->下面其实
		$.ajax({
			url : "/LessonAfter27Base8.5/AreaSelect",
			data : {
				message : "getProvinces"
			},
			type : "get",
			dataType : "json"
		}).done(function(json){
			iterator(json,provinces);
		
		})
		  //获取cities
            provinces.on('change', function(event) {
            event.preventDefault();
            /* Act on the event */
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
        });
		//获取zones
        cities.on('change', function(event) {
            event.preventDefault();
            /* Act on the event */
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
		
		
		
	})
	// 封装方法
	function getdatas(){
		var nextSelector = getNextSelector(this);
		var message = "get"+nextSelector[0].id;
		var id = this.id;
		
	}
	function getNextSelector(obj){
		var nextSelector = $("select").eq($("select").index(obj)+1);
		return nextSelector;
	}
	function getField(data,obj){
		// 很明显,每次执行的方法参数不同,迭代的选择器对象不同
		$.ajax({
            url : "/LessonAfter27Base8.5/AreaSelect",
            data : data,
            type : "get",
            dataType : "json"
        }).done(function(json){
        	// 如果是pro->那就是cities 如果是cities->那就是zones ,共同点都是selector标签 -- >取select下一个元素
            iterator(json,obj);
        
        })
	}
	
	
	
	
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
</script>
</head>
<body>
	<select id="provincestag" name="provinces">
		<option value="dochoice">请选择</option>
	</select>
	<select id="citiestag" name="cities">
		<option value="dochoice">请选择</option>
	</select>
	<select id="zonestag" name="zones">
		<option value="dochoice">请选择</option>
	</select>
</body>
</html>