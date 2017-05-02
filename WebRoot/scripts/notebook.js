function loadNoteBooks(){
	$.ajax({
		url:"http://localhost:8088/cloud_note/notebook/loadbooks.do",
		type:"post",
		data:{"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				var books = result.data;//笔记本json集合信息
				//循环集合生成笔记本li列表
				for(var i = 0;i <books.length; i++){
				//获取每个笔记本元素的笔记本名称
					var bookName = books[i].cn_notebook_name;
					//获取每个笔记本元素的笔记本id
					var bookId = books[i].cn_notebook_id;
					//拼成li元素
					var s_li = '<li class="online"><a>';
					s_li += '<i class="fa fa-book" title="online" rel="tooltip-bottom">';
					s_li += '</i>'+bookName+'</a></li>';
					//将s_li字符串转成jquery对象,藏bookid
					var $li = $(s_li);
					$li.data("bookId",bookId);
					//将li添加到笔记本ul中
					$("#book_list").append($li);
				}
			}
		}
	}
	);
};

//弹出添加笔记本对话框
function showAddBookWindow(){
	//发出一个alert/alert_notebook.html
	//将请求返回的结果放入id=can的div
		$(".opacity_bg").show();//显示背景
		$("#can").load("alert/alert_notebook.html");//显示对话框				
};

//关闭对话框
function closeWindow(){
	$("#can").empty();
	$(".opacity_bg").hide();
};

//确认创建笔记本
function sureAddBook(){
	//获取笔记本名
	var bookName = $("#input_notebook").val().trim();
	//todo 检查笔记本是否为空
	//发送请求
	$.ajax({					
		url:"http://localhost:8088/cloud_note/notebook/add.do",
		type:"post",
		data:{"bookName":bookName,"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				closeWindow();//关闭对话框
				//添加一个笔记本li
				var bookId = result.data;//获取返回的bookId
				//拼成li元素
				var s_li = '<li class="online"><a>';
				   	s_li += '<i class="fa fa-book" title="online" rel="tooltip-bottom">';
					s_li += '</i>'+bookName+'</a></li>';
				//将s_li字符串转成jquery对象,藏bookid
					var $li = $(s_li);
					$li.data("bookId",bookId);
				//将li添加到笔记本列表区中
					$("#book_list").prepend($li);
			}
		},
		error:function(){
			alert("创建笔记本异常");
		}
	});
};