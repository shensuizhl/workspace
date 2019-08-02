var modelProgress = 0;
var model_list = new Array(); //不定义元素个数
var myChart = null;
ip = "http://192.168.1.109:8080"
//var model_status = new Array();
//var model_status = new Array();
var model_num;
$(document).ready( //初始化页面
	function() {
		//获取文件列表,及是否存在大表
		$.ajax({
			url: ip + '/demo/model/training/list',
			method: "get",
			data: {},
			async: false,
			//async属性默认为true,即异步请求。当为同步请求时JS代码加载到当前AJAX的时候会把页面里所有的代码停止加载，页面出现假死状态，当这个AJAX
			//执行完毕后才会继续运行其他代码页面假死状态解除。而异步则这个AJAX代码运行中的时候其他代码一样可以运行。
			success: function(data) {
				if (data.code == "200") {
					//not_data = //未训练的最新时间数据
					modelName = data.data.modelName;
					modelProgress = data.data.modelProgress //模型训练状态 如modelProgress=20%
					model_list = data.data.list //文件列表
					//
				}
			},
		});
		// alert(modelProgress);
		model_num = model_list.length; //模型个数
		// if (not_data = "") {
		// 	document.getElementById("show_notdata").innerHTML = "提示：暂无新数据！";
		// } else {
		// 	document.getElementById("show_notdata").innerHTML = "提示：新加入的" + not_data + "数据待训练";
		// }
		//console.log("init", modelProgress);
		if (modelProgress < 1) {
			document.getElementById("train_but").disabled = false;
			$("#training_result").load("page/on_training.html", function() {
				//
				train_model();
			});

			//轮询
		}
		if (modelProgress == 1) { //所有status的积等于1代表都完成训练
			document.getElementById("train_but").disabled = true;
			$("#training_result").load("page/training_table.html", function() {
				load_table();
			});
			/* document.getElementById("train_but").disabled=true;
			$("#training_result").load("page/training_table.html");
			 */
		}
	})

/* if (allfile_flag == 0) { //无大表
	alert('目前没有生成数据表，无法进行训练')
} else {
	if (file_num == 0) {
		document.getElementById("show_status").innerHTML = "目前暂无训练记录";
	} else {
		show_text = "目前有" + file_num + "训练记录"
		for (i = 0; i < file_num; i++) {
			show_text = show_text + "<br>" + file_list[i];
		}
		document.getElementById("show_status").innerHTML = show_text;
	}
};
            
//对文件列表进行显示
document.getElementById("show_status").innerHTML = "welcome" + "<br>" + "_word"; */
//点击 开始训练按钮
function start_training() {
	modelProgress = 0; //开始进程等于0
	document.getElementById("train_but").disabled = false; //不可点击状态
	$("#training_result").load("page/on_training.html", function() {
		//load_table();	
		$.ajax({
			url: ip + '/demo/model/training/start',
			method: "get",
			data: {},
			async: false,
			//async属性默认为true,即异步请求。当为同步请求时JS代码加载到当前AJAX的时候会把页面里所有的代码停止加载，页面出现假死状态，当这个AJAX
			//执行完毕后才会继续运行其他代码页面假死状态解除。而异步则这个AJAX代码运行中的时候其他代码一样可以运行。
			success: function(data) {
				if (data.code == "200") {
					model_num = model_num + 1;
					model_list[model_num - 1] = data.data //最新的模型名
				}
			},
		});
		//console.log("load", modelProgress);
		document.getElementById("show_status").innerHTML = model_list[model_num - 1] + "文件正在训练...";
		myChart = echarts.init(document.getElementById('progressbar'));
		show_processbar(modelProgress, myChart);
	});
	//$("#training_result").load("page/on_training.html");
	//获取最新文件名

	modelProgress = train_model() //训练模型

	if (modelProgress == 1) { //完成训练
		document.getElementById("train_but").disabled = true;
		$("#training_result").load("page/training_table.html", function() {
			load_table();
		});

		//显示所有文件,绑数据函数
	}
}
//递归获取modelProgress
function train_model() {
	// 每隔  10 秒钟 运行一次，发送一个 ajax 请求

	// 1000 * 10 = 10 秒钟
	console.log(modelProgress);
	setTimeout(train_model, 1000 * 10);
	if (modelProgress == 1) {
		alert(modelProgress);
		document.getElementById("show_status").innerHTML = modelName + "已完成训练！";
		//document.getElementById("progressbar").innerHTML = "Completed";
		//document.getElementById("progressbar").className = 'progress-bar progress-bar-success'; //替换成一个通过的class
		//改变进度条颜色,名称
		return modelProgress; //返回modelProgress值的大小
	} else {
		$.ajax({
			"dataType": 'json',
			"type": "get",
			"url": ip + '/demo/model/training/progress',
			"data": {},
			"success": function(data) {
				modelProgress = data.data.modelProgress * 100;
				modelName = data.data.modelName;
			}
		});

		//document.getElementById("progressbar").innerHTML = modelProgress + "Complete";//换成新的进度条
		show_processbar(modelProgress, myChart);
	}
	//  
}

function load_table() {
	$(".userListTable tbody").empty(); //清空原有表
	//显示所有文件,绑数据函数

	for (var i = 0; i < model_num; i++) {
		$(".userListTable tbody")
			.append('<tr >' +
				'<td>' +
				model_list[i] +
				'</td>' +
				'<td><button type="button" class="btn btn-danger btn-xs" onclick="deleteOne(\'' +
				model_list[i] + '\')">删除</button></td>' +
				'</tr>')
	}
}
//删除功能
function deleteOne(model_name) {
	//var model_name;
	model_num = model_num - 1; //删除一次model_num减去1
	//
	$.ajax({
		url: ip + '/demo/model/training/delete',
		method: "DELETE",
		data: {
			"filename": model_name
		},
		contentType: "application/x-www-form-urlencoded",
		dataType: "json",
		async: true,
		success: function(data) {
			if (data.code == 200) {
				//model_status = //大表状态 如file_status=20%
				model_list = data.data.list //文件列表
				load_table();
			} else {
				alert("删除失败");
			}
		},
	});
	//alert(model_name);
}
