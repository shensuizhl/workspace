	// 当前页
	var currentPage = 1;
	// 总记录数量
	var total = 0;
	// 默认每页显示数
	var size = 10;
	// 总页数
	var totalPage = 1;
	var row={};//定义row变量
	var flag_num=0;//点第几个文件-1，默认第一个文件。
	var ip='http://192.168.1.112:8080'
//;findOne('+basepayId+')
//初始化分页栏
function initPagination(pageNum, total) {
	$('#pagination').html(" ");
	$('#pagination').append(
			'<ul class="pagination" style="display:inline;">'
					+ '<span style="float: right;">每页显示'   //分页栏右侧
					+ '<select id="dataNum">'
					+ '<option value="5">5</option>'
					+ '<option value="10">10</option>'
					+ '<option value="15">15</option>'
					+ '<select>条记录,总共有' + totalPage
					+ '页，总共' + total + '条记录</span>'
					+ '</ul>')
	$("#pagination ul")  //分页栏左侧
			.append(
					'<li><a href="javascript:void(0);" id="prev">上一页</a>')
	for (var i = 1; i <= totalPage; i++) {
		$("#pagination ul").append('<li id="page'
						+ i           //这里是给数字li设置id  如果是第一页id就为page1,第二页id就为page2
						+ '"><a href="javascript:void(0);" >' + i + '</a></li>' )
	}				//javascript:void(0):意义是让超链接去执行一个js函数，而不是去跳转到一个地址。每一个li的onclick事件在ready()中已经定义了						
	$("#pagination ul")
			.append(
					'<li><a href="javascript:void(0);"  id="next">下一页</a></li>')
	
	
	$("select option[value=" + size + "]").attr(      //设置分页栏右侧下拉框选中项
			'selected', true)
	$('#page'+currentPage+'').addClass("active");   //设置分页栏左侧下page1 <li>标签为选中项（在第一次载入时为active）
	checkA();
}




//主要是用于检测当前页如果为首页，或者尾页时，上一页和下一页设置为不可选中状态
function checkA() {
	currentPage == 1 ? $("#prev").addClass(
			"btn btn-default disabled") : $("#prev")
			.removeClass("btn btn-default disabled");
	currentPage == totalPage ? $("#next").addClass(
			"btn btn-default disabled") : $("#next")
			.removeClass("btn btn-default disabled");
}

//大表查询函数
			function search_table(search_but) {
				$.ajax({
					url: ip + '/demo/table/search/employee',
					method: "get",
					data: {
						"type": "employee",
						"page": currentPage,
						"rows": size,
					},
					async: false,
					//async属性默认为true,即异步请求。当为同步请求时JS代码加载到当前AJAX的时候会把页面里所有的代码停止加载，页面出现假死状态，当这个AJAX
					//执行完毕后才会继续运行其他代码页面假死状态解除。而异步则这个AJAX代码运行中的时候其他代码一样可以运行。
					success: function(data) {

						if (data.code == "200") {
							
						}
					},
				})
			}
            //重置函数
			function reset_table(reset_but) {//

			}
			//
			//获取cookie信息
function getRememberInfo(){
// alert("---获取cookie信息---");
var username="";
userName=getCookieValue("username");
document.getElementById("userName").value=userName;
//document.getElementById("userPassword").value=userPassword;
}
