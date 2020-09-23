//------------------------------分页


var PaginJson = new Object()

function Pagin(paginJson){
	paginJson.pageIndex = 1
	paginJson.endPage = Math.ceil(paginJson.dataSize/paginJson.pageSize)
	//alert(paginJson.endPage)
	PaginJson = paginJson
	createPagin()
}

function createPagin(){
	var pagin = document.querySelector(PaginJson.el)
	pagin.innerHTML = " <a href='javascript:void(0)' onclick='setPageIndex("+(PaginJson.pageIndex==1?1:PaginJson.pageIndex-1)+")' class='page'><<</a> "
	pagin.innerHTML += " <a href='javascript:void(0)' onclick='setPageIndex(1)' class='page'>1</a> "
	if(PaginJson.endPage<=12){
		pagin.innerHTML += createPaginFor(2,PaginJson.endPage-1)
	}else if(PaginJson.pageIndex<=7){
		pagin.innerHTML += createPaginFor(2,12)
		pagin.innerHTML += " ... "
	}else if(PaginJson.pageIndex>=PaginJson.endPage-6){
		pagin.innerHTML += " ... "
		pagin.innerHTML += createPaginFor(PaginJson.endPage-11,PaginJson.endPage-1)
	}else{
		pagin.innerHTML += " ... "
		pagin.innerHTML += createPaginFor(PaginJson.pageIndex-5,PaginJson.pageIndex+5)
		pagin.innerHTML += " ... "
	}
	if(PaginJson.endPage!=1)
		pagin.innerHTML += " <a href='javascript:void(0)' onclick='setPageIndex("+PaginJson.endPage+")' class='page'>"+PaginJson.endPage+"</a> ";
	pagin.innerHTML += " <a href='javascript:void(0)' onclick='setPageIndex("+(PaginJson.pageIndex==PaginJson.endPage?PaginJson.endPage:PaginJson.pageIndex+1)+")' class='page'>>></a> "
	setPageCss()
}

function createPaginFor(begin,end){
	var msg = "";
	for(var i=begin;i<=end;i++){
		msg += " <a href='javascript:void(0)' onclick='setPageIndex("+i+")' class='page'>"+i+"</a> "
	}
	return msg;
}

//分页触发的事件
function setPageIndex(pageIndex){
	PaginJson.pageIndex = pageIndex
	PaginJson.func()
	createPagin()
}

//设置分页样式
function setPageCss(){
	var pages = document.querySelectorAll("a[class='page']")
	for(var i=0;i<pages.length;i++){
		if(pages[i].innerHTML==PaginJson.pageIndex)
			setAtStyle(pages[i])
		else
			setAllStyle(pages[i])
	}
}

/* //设置所有样式
function setAllStyle(aid){
	//aid.style.color = "blue"
	aid.style.textDecoration = "none"
	aid.style.border = "1px solid #FF8040"
	aid.style.paddingRight = "5px"
	aid.style.paddingLeft = "5px"
	aid.style.textAlign = "center"
}

//设置当前选择的样式
function setAtStyle(aid){
	aid.style.color = "#000000"
	aid.style.textDecoration = "none"
	aid.style.border = "1px solid #FF8040"
	aid.style.paddingRight = "5px"
	aid.style.paddingLeft = "5px"
	aid.style.textAlign = "center"
	aid.style.backgroundColor = "#FF8040" 
}

 */

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

//--------------------------------------------滚动加载

function RollLoad(func){
	window.onscroll = function(){
	　　if(getScrollTop() + getWindowHeight() == getScrollHeight()){
			func()
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