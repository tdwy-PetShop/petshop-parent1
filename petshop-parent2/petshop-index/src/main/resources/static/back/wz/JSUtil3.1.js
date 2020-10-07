

//全局变量
var _pageIndex = 1	//当前页
var _pageSize=6 		//每页显示多少数据
var _quantity		//总记录
var _pageId			//分页所在的DIV
var _endPage		//最后一页


//----------------------分页


/**
 * 初始化分页方法，使用此工具调用此方法即可
 * quntity:数据数量
 * pageId:分页DIV的ID
 * pageSize:每页显示数量，不给的话默认为10
 * */
function initPagin(quantity,pageId,pageSize){
	_quantity = quantity
	_pageId = pageId
	/* if(pageSize)
		_pageSize = pageSize
	else
		_pageSize = 10 */
	_endPage = Math.ceil(_quantity/_pageSize)
	
	createPagin(_pageIndex,_pageSize,_endPage,_pageId)
}

/**
 * pageIndex:当前页
 * pageSize:每页记录条数
 * endPage:最后一页
 * pageId:分页div的id
 * */
 
/* <a class="prev" href="">&lt;&lt;</a>
 <a class="num" href="">1</a>
 <span class="current">2</span>
 <a class="num" href="">3</a>
 <a class="num" href="">489</a>
 <a class="next" href="">&gt;&gt;</a> */
function createPagin(pageIndex,pageSize,endPage,pageId){
	var pagin = document.querySelector("#"+pageId)
	pagin.innerHTML = " <a href='#' onclick='setPageIndex("+(pageIndex==1?1:pageIndex-1)+")' class='page'>&lt;&lt;</a> "
	pagin.innerHTML += " <a href='#' onclick='setPageIndex(1)' class='page'>1</a> "
	if(endPage<=12){
		pagin.innerHTML += createPaginFor(2,endPage-1)
	}else if(pageIndex<=7){
		pagin.innerHTML += createPaginFor(2,12)
		pagin.innerHTML += " ... "
	}else if(pageIndex>=endPage-6){
		pagin.innerHTML += " ... "
		pagin.innerHTML += createPaginFor(endPage-11,endPage-1)
	}else{
		pagin.innerHTML += " ... "
		pagin.innerHTML += createPaginFor(pageIndex-5,pageIndex+5)
		pagin.innerHTML += " ... "
	}
	if(endPage!=1)
		pagin.innerHTML += " <a href='#' onclick='setPageIndex("+endPage+")' class='page'>"+endPage+"</a> ";
	pagin.innerHTML += " <a href='#' onclick='setPageIndex("+(pageIndex==endPage?endPage:pageIndex+1)+")' class='page'>&gt;&gt;</a> "
	setPageCss()
}

function createPaginFor(begin,end){
	var msg = "";
	for(var i=begin;i<=end;i++){
		msg += " <a href='#' onclick='setPageIndex("+i+")' class='page'>"+i+"</a> "
	}
	return msg;
}

//分页触发的事件
function setPageIndex(pageIndex){
	_pageIndex = pageIndex
		
	vm.$data.tlist=getData()
	
	createPagin(_pageIndex,_pageSize,_endPage,_pageId)
}

//设置分页样式
function setPageCss(){
	var pages = document.querySelectorAll("a[class='page']")
	for(var i=0;i<pages.length;i++){
		if(pages[i].innerHTML==_pageIndex)
			setAtStyle(pages[i])
		else
			setAllStyle(pages[i])
	}
}

//设置所有样式
function setAllStyle(aid){
	aid.style.color = "gray"
	aid.style.textDecoration = "none"
	aid.style.border = "1px solid gray"
	aid.style.paddingRight = "5px"
	aid.style.paddingLeft = "5px"
	aid.style.textAlign = "center"
}

//设置当前选择的样式
function setAtStyle(aid){
	aid.style.backgroundColor = "#009393"
	aid.style.color = "#6c6c6c"
	aid.style.textDecoration = "none"
	aid.style.border = "1px solid gray"
	aid.style.paddingRight = "5px"
	aid.style.paddingLeft = "5px"
	aid.style.textAlign = "center"
	
}


//----------------------滚动加载

//创建滚动条监听,直接用这个方法
function createRollLoad(){
	window.onscroll = function(){
	　　if(getScrollTop() + getWindowHeight() == getScrollHeight()){
			alert("已经到底部了！")
	　　}
	}
}

//滚动条在Y轴上的滚动距离
function getScrollTop(){
　　var scrollTop = 0, bodyScrollTop = 0, documentScrollTop = 0
　　if(document.body){
　　　　bodyScrollTop = document.body.scrollTop
　　}
　　if(document.documentElement){
　　　　documentScrollTop = document.documentElement.scrollTop
　　}
　　scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop
　　return scrollTop
}
 
//文档的总高度
function getScrollHeight(){
　　var scrollHeight = 0, bodyScrollHeight = 0, documentScrollHeight = 0;
　　if(document.body){
　　　　bodyScrollHeight = document.body.scrollHeight
　　}
　　if(document.documentElement){
　　　　documentScrollHeight = document.documentElement.scrollHeight
　　}
　　scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight
　　return scrollHeight
}
 
//浏览器视口的高度
function getWindowHeight(){
　　var windowHeight = 0
　　if(document.compatMode == "CSS1Compat"){
　　　　windowHeight = document.documentElement.clientHeight
　　}else{
　　　　windowHeight = document.body.clientHeight
　　}
　　return windowHeight
}



//---------------------自己创建表格数据

/**
 * 开始创建表格
 * 这个方法会自动创建表头，只需要一个table就行了
 * tableId：表格的id
 * json，需要入表的json数据
 * */
function createTableData(tableId,json){
	var table = document.querySelector("#"+tableId)
	table.innerHTML = ""
	createTableHeader(table,json)
	createTableBody(table,json)
}

//创建表头
function createTableHeader(table,json){
	var msg = "<thead>"
	var sign = false
	for(var i in json[0]){
		if(json[0][i] instanceof Object){
			for(var j in json[0][i]){
				for(var k in json[0]){
					if(j!=k){
						sign=true
					}else{
						sign=false
						break
					}
				}
				if(sign&&json[0][i][j]!=null)
					msg += "<th>"+j+"</th>"
			}
		}else{
			msg += "<th>"+i+"</th>"
		}
	}
	msg += "</thead>"
	table.innerHTML += msg
}

//创建表数据
function createTableBody(table,json){
	var msg = "<tbody>"
	var sign = false
	for(var i in json){
		msg += "<tr>"
		for(var j in json[i]){
			if(json[i][j] instanceof Object){
				for(var k in json[i][j]){
					for(var r in json[i]){
						if(json[i][r]!=json[i][j][k]){
							sign=true
						}else{
							sign=false
							break
						}
					}
					if(sign){
						msg += "<td>"+json[i][j][k]+"</td>"
					}
				}
			}else{
				msg += "<td>"+json[i][j]+"</td>"
			}
		}
		msg += "</tr>"
	}
	msg += "</tbody>"
	table.innerHTML += msg
}