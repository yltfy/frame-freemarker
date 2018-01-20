// 滑块 start
$(function(){
	$(".tmui-tips").tmTip();
});

//数据加载loading
function loading2(target,mark){
	$.loading({target:$(target),mark:1}); 
};


/* 日期函数 start */
function showdate1(){
	 WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});
}

function showdate2(){
	 WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});
}
/* 日期函数 start */


function setSession(key,value,mark){
	var stroage = mark?sessionStorage:localStorage;
	if(stroage)stroage.setItem("keant_"+key, value);
};


function getSession(key,mark){
	var stroage = mark?sessionStorage:localStorage;
	if(stroage){
		return stroage.getItem("keant_"+key);
	}else{
		return "";
	}
};

function removeSession(key,mark){
	var stroage = mark?sessionStorage:localStorage;
	if(stroage){
		return stroage.removeItem("keant_"+key);
	}else{
		return "";
	}
};



/* 二次封装ajax  start 运用真正节流方式进行二次开发    */
var ajaxMark = true;
var tzAjax = {
	request: function(options,params){
		//继承参数
		var opts = $.extend({},{
			path:"",
			type:"post",
			model:"",
			method:"",
			params:"",
			traditional:false,
			before:function(){
				loading("请稍后数据执行中...",3);
			},
			success:function(){},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				/*alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
				alert(errorThrown);*/
				loading("请求错误地址或者参数错误",4);
				ajaxMark=true;
			},//当访问地址不存在，或者参数不匹配或者服务器中途中断的时候，就会进入ajax的error方法
			logout:function(){
				$.tzConfirm({title:"重新登录提示",ghost:false,icon:"warn",content:"登录超时，请重新登录",callback:function(ok){
					if(ok){
						window.location.href = basePath;
					}
				}});
			},
			permission:function(){
				loading("对不起，访问受限",3);
			}
		},options);
		//url拼接
		if(!opts.url){
			opts.url = opts.path+"/"+opts.model+"/"+opts.method+(opts.params?"?"+opts.params:"");
		}
		if(ajaxMark){
			ajaxMark = !ajaxMark;
			$.ajax({
				type:opts.type,
				url:opts.url,
				beforeSend:opts.before,
				error:opts.error,
				traditional:opts.traditional,
				data:params,
				success:function(data){
					if(data=="logout"){
						if(opts.logout)opts.logout();//记录日志信息
					}
					if(data == "nopermission") {
						if(opts.permission)opts.permission();//提示方法
					}
					else{
						if(opts.success){
							opts.success(data);//成功执行下一步操作
						}
					}
					ajaxMark = true;
				}
			});
		}
	}	
};
/* end 二次封装ajax */

/* 属性查看封装 start */
var tzProperty = {
		property:function(obj){
			var $obj = $(obj);
			var code = $obj.data("code");
			var model = $obj.data("model");
			var title = "";
			var height = 0;
			if(model == "pdictionary"){
				title = "产品信息";
				height = 480;
			}
			if(model == "specification"){
				title = "规格信息";
				height = 350;
			}
			if(model == "supplier"){
				title = "供应商信息";
				height = 480;
			}
			if(model == "client"){
				title = "客户信息";
				height = 520;
			}
			tzAjax.request({
				path:adminPath,
				model:model,
				method:"property",
				success:function(data){
					$.tzConfirm({
						title:title,
						width:450,
						height:height,
						icon:"",
						ghost:false,
						content:data,
						callback:function(ok, $dialog, opts){
							if(ok){
								$dialog.next().remove();
								tzUtil.animates($dialog, opts.animate);
							}
						}
					});
					loading("数据加载成功",3);
				}
			}, {code:code});
		}
};
/* end 属性查看封装   */

/* 表格动态排序封装  start */
var tzSortTables = {
		toArray:function(doms){//将一个htmlcollection转换成数组对象
			return  Array.prototype.slice.call(doms);
		},
		dom:function(id){//通过id获取对象
			return  document.getElementById(id);
		},
		stringToDate:function(stringDate){//字符串转换成javascript中的日期对象
			return new Date(stringDate.replace(/-/g,"/").replace(".0",""));
		},
		getDomIndex:function(doms,dom){//获取某个元素在dom集合中的索引
			var _index = -1;
			for(var i=0,len=doms.length;i<len;i++){
				if(doms[i]==dom){
					_index = i;
					break;
				}
			}
			return _index;
		},
		sortTable:function(thead, tbody){
			//获取所有th对象
			var thDoms = tzSortTables.dom(thead).getElementsByClassName("sortd");
			//转成数组
			var thDomArry = tzSortTables.toArray(thDoms);
			thDomArry.forEach(function(obj){
				obj.addEventListener("click",function(){
					var thObj = this;
					var sortMark = this.getAttribute("sort");
					var index = tzSortTables.getDomIndex(thDoms,thObj);
					//获取所有要排序的行
					var trDoms = tzSortTables.dom(tbody).children;
					//转换成数组
					var trDomsArray = tzSortTables.toArray(trDoms);
					//控制排序的状态
					thObj.mark = !thObj.mark;
					//开始排序
					trDomsArray.sort(function(a,b){
						var v1 = a.children[index].innerHTML,
							v2=b.children[index].innerHTML;
						if(sortMark=="num"){
							v1= parseFloat(v1);
							v2 = parseFloat(v2);
							return thObj.mark?v1-v2:v2-v1;
						}else if(sortMark=="money"){
							v1= parseFloat(v1.replace(/^[￥|$]/,""));
							v2 = parseFloat(v2.replace(/^[￥|$]/,""));
							return thObj.mark?v1-v2:v2-v1;
						}else if(sortMark=="time"){
							v1 = tzSortTables.stringToDate(v1).getTime();
							v2 = tzSortTables.stringToDate(v2).getTime();
							return thObj.mark?v1-v2:v2-v1;
						}else if(sortMark=="char"){
							return thObj.mark?v1.localeCompare(v2):v2.localeCompare(v1);
						}
					});
					//重新设置到表格中
					trDomsArray.forEach(function(obj){
						tzSortTables.dom(tbody).appendChild(obj);
					});
				});
			});
		}
};
/* end 表格动态排序封装  */

//获取鼠标的位置。兼容ie678
function getXY(e){
	var ev = e || window.event;
	var x=0,y=0;
	if(ev.pageX){
		x = ev.pageX;
		y = ev.pageY;
	}else{
		//拿到scrollTop 和scrollLeft
		var sleft = 0,stop = 0;
		//ie678---
		if(document.documentElement){
			stop =document.documentElement.scrollTop;
			sleft = document.documentElement.scrollLeft;
		}else{
		//ie9+ 谷歌 
			stop = document.body.scrollTop;
			sleft = document.body.scrollLeft;
		}	
		x = ev.clientX + sleft;
		y = ev.clientY + stop;
	}
	return {x:x,y:y};
};