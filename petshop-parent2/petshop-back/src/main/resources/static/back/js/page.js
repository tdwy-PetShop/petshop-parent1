/**
 * @description 分页工具。1.需要导入js/page.js和css/page.css两个文件。2.<div id="page"></div>
 * @param {int} pageIndex 当前页码
 * @param {int} totalPages 总页数
 * @param {int} pageShow 奇数、一次显示多少页
 */
var pageIndex = 1;
var pageShow = 3;


// 使用说明：只需要调用getPage传入总页数和回调函数即可，当前页码是全局的，不用定义。
// 示例：
// window.onload = function(){
// 	getPage(10, test);
// }
// 
// function test() {
// 	alert(pageIndex);
// }




function getPage(totalPages, callback) {
	page(totalPages, callback);
	click(totalPages, callback);
}

function getPage(totalPages, callback) {
	if (totalPages <= 0)
		totalPages = 1;
	page(totalPages, callback);
	click(totalPages, callback);
}

function page(totalPages, callback) {
	if (callback != undefined && typeof(callback) === 'function')
		callback();
	var msg = '';
	msg += '<ul>';
	if (pageIndex > 1)
		msg += '<li class="xl-prevPage">&lt;&lt;</li>';
	else
		msg += '<li class="xl-prevPage xl-disabled">&lt;&lt;</li>';
	msg += '<li v='+1+'>1</li>';
	if (totalPages <= pageShow) {
		msg += buildPage(2, totalPages - 1);
	} else if (pageIndex <= pageShow/2+1) {
		msg += buildPage(2, pageShow);
		msg += '<li class="xl-disabled"> ... </li>';
	} else if (pageIndex >= totalPages - pageShow/2) {
		msg += '<li class="xl-disabled"> ... </li>';
		msg += buildPage(totalPages - pageShow+1, totalPages - 1);
	} else {
		msg += '<li class="xl-disabled"> ... </li>';
		msg += buildPage(pageIndex - (pageShow-3)/2, pageIndex + (pageShow-3)/2);
		msg += '<li class="xl-disabled"> ... </li>';
	}
	msg += totalPages > 1 ? '<li v='+totalPages+'>'+totalPages+'</li>' : '';
	if (pageIndex < totalPages)
		msg += '<li class="xl-nextPage">&gt;&gt;</li>';
	else
		msg += '<li class="xl-nextPage xl-disabled">&gt;&gt;</li>';
	msg += '</ul>';
	document.querySelector('#page').innerHTML = msg;
	document.querySelector('li[v="'+pageIndex+'"]').className = 'xl-active';
}

function buildPage(beginP, endP) {
	var msg = '';
	for (var i = beginP; i <= endP; i++) {
		msg += '<li v='+i+'>'+i+'</li>';
	}
	return msg;
}

function click(totalPages, callback) {
	document.querySelector('#page').onclick = function(e) {
		if (e.target.innerHTML == '&lt;&lt;') {
			if (pageIndex > 1) {
				pageIndex = pageIndex - 1;
				page(totalPages, callback);
			}
		} else if (e.target.innerHTML == '&gt;&gt;') {
			if (pageIndex < totalPages) {
				pageIndex = pageIndex + 1;
				page(totalPages, callback);
			}
		} else if (!isNaN(e.target.innerHTML)) {
			if (pageIndex != parseInt(e.target.innerHTML)) {
				pageIndex = parseInt(e.target.innerHTML);
				page(totalPages, callback);
			}
		}
	};
	
}


