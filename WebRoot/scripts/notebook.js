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
}