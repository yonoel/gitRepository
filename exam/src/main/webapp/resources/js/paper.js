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
	query();
	$("#paperbox").children("div:gt(1)").hide();
	// add
	$("#addpaperbtn").on("click",function(){
		$("#paperbox").children("div:gt(0)").hide();
		$("#addbox").show();
		$("#methodflag").val("add");
		$("#papertitle").html("新增试卷");
		$("#resetbtn").click();
	})
	// mod
	$("#modpaperbtn").on("click",function(){
		if(!ispaperchecked()){
			return ;
		}
		$("#paperbox").children("div:gt(0)").hide();
		// 数据显示 和填充
		// 获取了所有数据的集合
		var datas = $("#dataform input:checked").parent().siblings("td");
		// 获取需要填充的input标签集合-->太复杂了，因为嵌套了div 还需要testno
		$("#testno").val($("#dataform input:checked").val());
		$("#testname").val($(datas[0]).html());
		// console.log("testno:"+$("#testno").val());
		
		var str = $(datas[1]).html().split("到");
        // console.log(str[0])
		$("#tstart").val(str[0]);
		$("#tend").val(str[1]);
		
		$("#announcetime").val($(datas[3]).html())
		$("#addbox").show();
		$("#methodflag").val("mod");
		$("#papertitle").html("修改试卷");
	})
	// autopaper
	$("#autopaperbtn").on("click",function(){
		// 勾选到testpaper的主键才可以创造
		if(!ispaperchecked()){
			return ;
		}
		// 检索这个paper是不是有paper了，那就不能出卷了-->根据分数判断
		if(!hasPapaerInfo()){
			alert("本卷已经有试卷了，无需再次出卷");
			return;
		}
		var testno =$("#dataform input:checked").val();
		
		$("#paperbox").children("div:gt(0)").hide();
		$("#autopaperbox").show();
	})
	// 新增栏目最多四个
	$("#newsubject").on("click",function(){
		var length = $("#autopapertable tr").length;
		if(length <= 3){
		
			$("#autopapertable tbody").append("<tr>"+$("#autopapertable tbody tr:first").html()+"</tr>");
		
		}else {
			alert("考试栏目最多四项,其实可以N个，我懒得写check方法了。。");
		}
	})
	// 智能出卷系统
	$("#newpaper").on("click",function(){
		if(checknewpaper()){
			// 取表单数据，生成一个数组然后返回一个json字符串
			var subjectDTOs = new Array();
			
			 var nums = $("#autopapertable select[name=subType]").length;
			 var types = $("#autopapertable select[name=subType]");
			 var diffs = $("#autopapertable select[name=difficulty]");
			 var subjectnums = $("#autopapertable input[name=subjectnum]");
			 var subjectscores = $("#autopapertable input[name=subjectscore]");
		
			 for (var i = 0; i < nums; i++) {
				 // 取 subType
				 // 更新很慢啊
				 subjectDTOs.push({type:$(types[i]).children("option:selected").html(),subType:types[i].value,diff:$(diffs[i]).children("option:selected").html(),difficulty:diffs[i].value,subjectnum:subjectnums[i].value,score:subjectscores[i].value});
				 // 构造函数
			 }
			 // var en = "paper/sub2paper/"+$("#dataform
				// input:checked").val()+"?";
			// var encoded_uri = encodeURI(en+$.toJSON(subjectDTOs));
			$.ajax({
				url:"paper/sub2paper/"+$("#dataform input:checked").val(),
				type:'POST',
				contentType : 'application/json;',
				data:
				JSON.stringify(subjectDTOs),
				success:function(data){
					alert(data.message);
					if(data.flag){
						window.location.href = "totestpaper";
					}
				}
			})
		}
	})
	// 试题设置
	$("#setsubjectbtn").on("click",function(){
		if(!ispaperchecked()){
			return ;
		}
		// 获取单一的id
		var testno =$("#dataform input:checked").val();
		// 显示paper的具体内容
		$("#paperbox").children("div:gt(0)").hide();
		$("#setsubjectbox").show();
		$.ajax({
			url:"paper/"+testno+"/paperinfo",
			type:"post",
			dataType:"json",
			success:function(data){
				setsubjectbox(data);
			}
		})
	})
	// 删除
	$("#delpaperbtn").on("click",function(){
		// 允许批量删除的。。。所以这个方法要改写
		if(!ispaperschecked()){
			return ;
		}
		// 选择 根据主键删除
		var papers = new Array();
		$("#dataform input:checked").each(function(i) {
			papers.push($(this).val());
		});
		$.ajax({
			url:"paper/deletepapers",
			type:'POST',
			contentType : 'application/json;',
			data: JSON.stringify(papers),
			success:function(data){
				// alert(data);
				alert(data.message);
				window.location.href = "totestpaper";
			}
		})
	})
	
	// 表单提交
	$("#addpaper").on("click",function(){
		if(checkaddform()){
			$.ajax({
				url : "paper/paperhandler",
				dataType : "json",
				data : $("#paperform").serialize(),
				success : function(data) {
					$("#testno").val();
					alert(data);
					window.location.href = "totestpaper";
				}
			});
		}
		
	})
	
	
})


// 试题设置里的删除
function delparent(object){
		/*console.log($(object).parentsUntil("div .form-group").html());
		$(object).parentsUntil("div .form-group").remove();*/
	
	alert("确认删除么?这里应该有两个按钮");
	var sno = $(object).siblings("input[type='hidden']");
	//console.log(x.length);
	// 要把这个设为全局变量
	var tno =$("#dataform input:checked").val();
	var obj = {subno:sno,testno:tno};
	if(true){
		$.ajax({
			url:"paper/deletesubpaper",
			type:'POST',
			contentType : 'application/json;',
			data: JSON.stringify(obj),
			success:function(){
				alert(data.message);
				if(data.flag){
					$(object).parentsUntil("div .form-group").remove();
				}
			}
		})
	}
	
	
}
//试题设置里的修改分值
function changescore(object){
	/*console.log($(object).parentsUntil("div .form-group").html());
	$(object).parentsUntil("div .form-group").remove();*/
	alert("确认修改分值么?这里应该有两个按钮");
	var subno = $(object).siblings("input[type='hidden']");
	//console.log(x.length);
	// 要把这个设为全局变量
	var testno =$("#dataform input:checked").val();
	var score = $(object).siblings("input[name='score']").val()
	if(true){
		$.ajax({
			url:"paper/"+testno+"/"+subno+"/"+score+"/changescore",
			success:function(){
				alert(data.message);
				if(data.flag){
					alert("我不想改页面了");
					window.location.href = "totestpaper";
				}
			}
		})
	}
}
function setsubjectbox(args) {
	// 获取了paper数据的集合
	var datas = $("#dataform input:checked").parent().siblings("td");
	// 画setsubjectbox 页面
	var setbox = $("#setsubjectbox");
	// 设置papername
	setbox.append("<h3>"+$(datas[0]).html()+"</h3>");
	// 设置tstart->tend
	setbox.append("<h4>从"+$(datas[1]).html()+"总时长"+$(datas[2]).html()+"</h4>");
	// 获取数据，设置页面
	
	//console.log(args);
	// args:{判断: Array(11), 多选: Array(6), 问答: Array(3), 单选: Array(11)} 是这样的map
	var keys = new Array();
	for(var key in args){keys.push(key);}
	setbox.append("<form id='paperinfoform' class='form-horizontal'></from>");
	setbox = $("#paperinfoform");
	for (var i = 0; i < keys.length; i++) {
		console.log(keys[i]);
		var k = keys[i];
		// value里包括了一个数组，最后一个是总分 var value = args.k;这样取不到
		// 取到一个数组/ /最后一个是总分。。。直接reserver一下
		var value = args[k].reverse();
		//console.log(value.length);
		for (var j = 0; j < value.length; j++) {
			var sub = value[j];
			if( j == 0 ){
				setbox.append("<h4>"+k+"&nbsp总分:"+sub+"</h4>")
			}else{
				// 删除按钮记得绑定事件
				var str = "<div class='form-group form-inline'><p><input type='hidden' value='"+sub.subno+"'name='subno' >序号:"+j
				+"&nbsp题目编号:["+sub.subno+"]&nbsp&nbsp分值:&nbsp&nbsp<input type='text' name='score' value='"+sub.score+"'><button type='button' onclick='delparent(this)'>删除</button><button type='button' onclick='changescore(this)'>确认</button>&nbsp&nbsp|&nbsp"
				+"<a  href=javascript:void(0) onclick=showsubjectdetial(this,event,'"+sub.subContent+"','"+sub.optiona+"','"
				+sub.optionb+"','"+sub.optionc+"','"+sub.optiond+"','"+sub.answer+"','"+sub.subType+"')>详情</a><br>";
				str += sub.subContent+"</p></div>";
				setbox.append(str);
			}
		}
		console.log("一种类型结束了");
	}
	
}
function showsubjectdetial(object,e,context,oa,ob,oc,od,answer,subtype){
	var tooltip = "<div id='tooltip'><span style='font-weight:bold'>题干:<span><br/><span style='font-weight:400'>"+context+"</span><br/>";
	if(subtype == 1 || subtype == 2){
		tooltip+="<span style='font-weight:bold'>选项:<span><br/>";
		tooltip+="<span style='font-weight:400'>A:"+oa+"<span><br/>";
		tooltip+="<span style='font-weight:400'>B:"+ob+"<span><br/>";
		tooltip+="<span style='font-weight:400'>C:"+oc+"<span><br/>";
		tooltip+="<span style='font-weight:400'>D:"+od+"<span><br/>";
	}
	tooltip += "<span style='font-weight:bold'>答案：</span><span style='font-weight:400'>"+answer+"<span></div>";
	$("body").append(tooltip);
	$("#tooltip").css({"top": (e.pageY+5) + "px","left": (e.pageX-1000) + "px"}).show();
	
	$("#tooltip").hover(function(){
		$(this).show();
	},function(){
		$(this).remove();
	});
}
function hasPapaerInfo() {
	var datas = $("#dataform input:checked").parent().siblings("td");
	if($(datas[4]).html() != "0"){
		return false;
	}
	return true;
}

function ispaperschecked() {
	var num = $("#dataform input:checked").length;
	if(num == 0){
		alert("没有选中要删除的试卷");
		return false;
	}
	return true;
}
function deleteparent(obj) {
	$(this).parent("tr").remove();
	console.log(aa)
}
function checknewpaper() {
	var types = $("#autopapertable select[name=subType]");
	// types里不能有空值，不能有重复
	if(!checkNull(types)){
		alert("题目类型不能为空");
		return false;
	}
	if(!checkDistinct(types)){
		alert("题目类型不能重复");
		return false;
	}
	var diffs = $("#autopapertable select[name=difficulty]");
	// diffs里不能有空值
	if(!checkNull(diffs)){
		alert("题目难度不能为空");
		return false;
	}
	var inputs = $("#autopapertable input[type=text]");
	if(!checkInputNull(inputs)){
		alert("请把数据填完");
		return false;
	}
	return true;
}
function checkInputNull(data){
	for (var i = 0; i < data.length; i++) {
		if($(data[i]).val() == "" || $(data[i]).val() == null){
			return false;
		}
	}
	return true;
}
function checkNull(data) {
	for (var i = 0; i < data.length; i++) {
		if($(data[i]).val() == "null"){
			return false;
		}
	}
	return true;
}
function checkDistinct(data) {
	for (var i = 0; i < data.length; i++) {
		for (var j = i+1; j < data.length; j++) {
			if($(data[i]).val() == $(data[j]).val()){
				return false;
			}
		}
	}
	return true;
}
function ispaperchecked() {
	var num = $("#dataform input:checked").length;
	if(num == 0){
		alert("没有选中试卷");
		return false;
	}else if (num > 1) {
		alert("选中的试卷太多了，请一个个修改");
		return false;
	}
	
	return true;
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
// 新增和修改考卷 的表单验证
function checkaddform() {
	return true
}
function gettesttime(){
			var starttime = $("#tstart").val();
			var tend = $("#tend").val();
			var testtime="";
			if(starttime.length > 0 && tend.length > 0){
				var d1 = new Date(starttime);
				var d2 = new Date(tend);
				var testtime = parseInt(Math.abs(d2 - d1)/1000/60);
			}
			$("#testtime").val(testtime);
			
		}

function checkall(obj) {
	var flag = $(obj).prop("checked");
	$(":checkbox").prop("checked", flag);
}
function query() {
	$.ajax({
		url : "paper/pagequery",
		dataType : "json",
		data : {
			pagenum : $("#pagenum").val()
		},
		success : function(data) {
			// console.log("paper" + data);
			if (data.flag) {
				subject2table(data.pages);
				$("#pages").val(data.total);
			} else if (!data.flag) {
				alert("没有查询到数据");
			}

		}
	})
}
function subject2table(data) {

	var table = $("#papertable");
	// console.log(data);
	$("#papertable tr:gt(0)").remove();
	// console.log("tr"+$("#subjecttable tr:gt(0)").length);
	if (data.length > 0) {
		for (var i = 0; i < data.length; i++) {
			var str = "<tr><td  align='center' width='40'><input type='checkbox' value='"
					+ data[i].testno + "' name='testno' /></td>";
			str += "<td width='100'>" + data[i].testname + "</td>";
			str += "<td width='500'>" + data[i].tstart + "到" + data[i].tend
					+ "</td>";
			str += "<td width='200'>" + data[i].testtime + "</td>";
			str += "<td width='200'>" + data[i].announcetime + "</td>";
			str += "<td width='100'>" + data[i].dtoscore + "</td></tr>";
			// console.log(str);
			table.append(str);
		}
	}
}