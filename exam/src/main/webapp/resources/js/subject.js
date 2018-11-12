$(function() {
	// 下拉列表填值
	$.ajax({
		url : "meta/queryall",
		dataType : "json",
		success : function(data) {
			
			var diffs = data.diffList;
			var types = data.typeList;
			// 这是查询用的
			dropdown($("select[name=difficulty]"), diffs);
			dropdown($("select[name=subType]"), types);
			// 不如把上面那两个下拉直接复制到其他表单里。。//或者干脆扔给这个方法一个jquery对象数组。。。
		
		}
	});

	// 页面初始加载时
	pagequery();
	// 除了databox 和 btnbox，其他都要隐藏
	$("#subjectbox").children("div:gt(1)").hide();
	
	
	// 分页功能
	$("#pre").on("click", "a", function() {
		// num > 2
		var num = parseInt($("#pagenum").val());
		if (num == 1) {
			alert("目前是首页，不能向前查询了");
		} else {
			$("#pagenum").val(num - 1);
			pagequery();
		}
		return false;
	})
	$("#next").on("click", "a", function() {
		// num > 2
		var num = parseInt($("#pagenum").val());
		if (num == parseInt($("#pages").val())) {
			alert("目前是尾页，不能向后查询了")
		} else {
			$("#pagenum").val(num + 1);
			pagequery();
		}
		return false;
	})
	// 查询
	$("#querybtn").on("click", function() {
		// 先要对$("#queryform")的参数进行验证
		if (checkform()) {
			$.ajax({
				url : "subject/querylist",
				dataType : "json",
				data : $("#queryform").serialize(),
				success : function(data) {
					console.log(data);
					if(!data.flag){
						alert("么有查询到数据");
					}else{
						subject2table(data.pages);
						$("#pages").val(data.total);
					}
				}
			});
		}

	})
	// add
	$("#addsubjectbtn").on("click",function(){
		$("#subjectbox").children("div:gt(0)").hide();
		$("#modbox").hide();
		$("#addbox").show();
		$("#methodflag").val("add");
		$("#subjecttitle").html("新增试卷");
	})
	
	$("#addsubject").on("click",function(){
		if(checkaddform()){
			alert(1);
			$.ajax({
				url : "subject/subjecthandler",
				dataType : "json",
				data : $("#subjectform").serialize(),
				success : function(data) {
					alert(data);
					window.location.href = "tosubject";
				}
			});
		}
		
	})
	// mod
	$("#modsubjectbtn").on("click",function(){
		$("#subjectbox").children("div:gt(0)").hide();
		$("#addbox").show();
		$("#modbox").show();
		$("#methodflag").val("mod");
		$("#subjecttitle").html("修改试卷");
	})
	// delete
	$("#delsubjectbtn").on("click",function(){
		var num = $("#deleteform input:checked").length;
		if(num == 0){
			alert("没有选中要删除的题目");
			window.location.href = "tosubject";
		}else{
			$.ajax({
				url : "subject/deletesubject",
				dataType : "json",
				data : $("#deleteform").serialize(),
				success : function(data) {
					alert(data);
					window.location.href = "tosubject";
				}
			});
		}
	})

})
function checkaddform() {
	return true;
}
function checkall(obj) {
	var flag = $(obj).prop("checked");
	$(":checkbox").prop("checked", flag);
}
function dropdown(selectors, data) {
	if(selectors.length > 0){
		for (var j = 0; j < selectors.length; j++) {
			for (var i = 0; i < data.length; i++) {
				var opt = "<option value='" + data[i].codeNo + "'>"
						+ data[i].codeName + "</option>";
				$(selectors[j]).append(opt);
			}
		}
	}
	
}
function subject2table(data) {
	var table = $("#subjecttable");
	// console.log("table:"+table.length);
	$("#subjecttable tr:gt(0)").remove();
	// console.log("tr"+$("#subjecttable tr:gt(0)").length);
	if (data.length > 0) {
		for (var i = 0; i < data.length; i++) {
			var str = "<tr><td  align='center' width='40'><input type='checkbox' value='"
					+ data[i].subno + "' name='subNo' /></td>";
			str += "<td width='100'>" + data[i].subno + "</td>";
			str += "<td width='100'>" + data[i].type + "</td>";
			str += "<td width='100'>" + data[i].diff + "</td>";
			str += "<td width='700'>" + data[i].subContent + "</td></tr>";
			table.append(str);
		}
	}
}
function checkform() {
	var id = $("#queryid").val();
	var type = $("#seltype option:selected").attr("value");
	var diff = $("#seldiff option:selected").attr("value");
	if (id != "" || type != "null" || diff != "null") {
		return true;
	}
	alert("没有查询条件");
	return false;
}
function pagequery() {
	$.ajax({
		url : "subject/pagequery",
		dataType : "json",
		data : {
			pagenum : $("#pagenum").val()
		},
		success : function(data) {
			// console.log(data);
			if (data.flag) {
				subject2table(data.pages);
				$("#pages").val(data.total);
			} else if (!data.flag) {
				alert("没有查询到数据")
			}

		}
	});
}
