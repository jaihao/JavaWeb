/*V3.0　2016-1-4*/
function $(id){
	return document.getElementById(id);
}
function ClassName(ClassName){
	return document.getElementsByClassName(ClassName);	//获得Class名
}
function TagName(TagName){
	return document.getElementsByTagName(TagName);		//获得标签名
}  
function Name(name){
	return document.getElementsByName(name);		//获取name标签
}
var eventBind={
	/*	绑定事件
	用法1:匿名事件处理程序
	语法:eventBind.addEvent(src, type, func)
	src:html页面元素对象,DOM对象类型
	type:js中所使用事件类型,如：click(单击)之类,String类型
	func:js中的事件处理程序,function类型
	示例:
		html代码:
		<input id="demo" value="测试">
		js代码:
		eventBind.addEvent($("demo"),"click",function(){
			alert("您好!");
		});	
		结果:
		单击id名为"demo"的按钮时,弹出对话框，显示"您好!"
	========================================================
	用法2:已经定义的事件处理程序
	语法:eventBind.addEvent(src, type, func)
	src:html页面元素对象,DOM对象类型
	type:js中所使用事件类型,如：click(单击)之类,String类型
	func:js中的事件处理程序,function类型
	示例:
		html代码:
		<input id="demo" value="测试">
		js代码:
		function sayHi(){
			alert("您好!");
		}
		eventBind.addEvent($("demo"),"click",sayHi);	
		结果:
		单击id名为"demo"的按钮时,弹出对话框，显示"您好!"
	*/
	"addEvent":function (obj_eventSrc, str_eventType, fun_callback){
		if(obj_eventSrc.addEventListener)
			obj_eventSrc.addEventListener(
				str_eventType
				,fun_callback
				,false
			);
		else if(obj_eventSrc.attachEvent)
			obj_eventSrc.attachEvent(
				"on"+str_eventType
				,fun_callback
			);
		else
			obj_eventSrc["on"+str_eventType]=fun_callback;
			
	}
	,
	/*	取消事件,并不能取消所事件，如匿名事件处理不能取消
	
	用法:已经定义的事件处理程序
	语法:eventBind.cancleEvent(src, type, func)
	src:html页面元素对象,DOM对象类型
	type:js中所使用事件类型,如：click(单击)之类,String类型
	func:js中要取消的事件处理程序,function类型
	示例:
		html代码:
		<input id="demo" value="测试">
		<input id="demo2" value="取消测试'按钮'的事件处理">
		js代码:
		function sayHi(){
			alert("您好!");
		}
		eventBind.addEvent($("demo"),"click",sayHi);	
		
		function moverEvent(){
			//取消测试'按钮'的事件处理
			eventBind.cancleEvent($("demo"),"click",sayHi);	
			alert("取消事件处理完成!");
		}
		eventBind.addEvent($("demo2"),"click",moverEvent);	
		
		结果:
		单击id名为"demo"的按钮时,弹出对话框，显示"您好!"
		单击id名为"demo2"的按钮时,弹出对话框，显示"取消事件处理完成!"
		再次单击id名为"demo"的按钮时,没有事件绑定了
		　
	*/
	"cancelEvent":function (obj_eventSrc, str_eventType, fun_callback){
		if(obj_eventSrc.removeEventListener)
			obj_eventSrc.removeEventListener(
				str_eventType
				,fun_callback
				,false
			);
		else if(obj_eventSrc.detachEvent)
			obj_eventSrc.detachEvent(
				"on"+str_eventType
				,fun_callback
			);
		else
			obj_eventSrc["on"+str_eventType]=null;
			
	}
	,
	/*
	批量事件绑定,同时为多个事件源绑定相同事件
	objs:多个元素构成的数组
	*/
	"addEvents":function(objs, str_eventType, fun_callback){
		for(var i=0; i<objs.length; i++){
			eventBind.addEvent($(objs[i]),str_eventType, fun_callback );
		}
	}
	,
	/*获取事件对象*/
	"getEvent":function(){
		return event?event:window.event;
	}
	,
	/*获取事件源的实际目标对象*/
	"getEventSrc":function(){
		var event=eventBind.getEvent();
		if(event.target)
			return event.target;//非IE
		else
			return event.srcElement;//IE
	}
	,
	/*取消默认行为*/
	"cancelDefault":function(){
		var event=eventBind.getEvent();
		if(event.preventDefault)
			event.preventDefault();
		else
			event.returnValue=false;
	}
	,
	/*阻止事件冒泡*/
	"stopBubble":function(){
		var event=eventBind.getEvent();
		if(event.stopPropagation)
			event.stopPropagation();
		else
			event.cancelBubble=true;
	}
}

var setter={
	/*	设置样式
	用法1:指定三个参数:
	语法:setter.setCSS(obj, style, value)
	obj:html页面元素对象,DOM对象类型
	style:js中所使用css样式属性名,String类型
	value:js中所使用css样式属性值,String类型
	示例:
		html代码:
		<p id="demo">测试</p>
		js代码:
		setter.setCSS($("demo"),"color","red");	
		结果:
		将id名为"demo"的段落设置红色字
	===========================================
	用法2:指定两个参数
	语法:setter.setCSS(obj, json)
	obj:html页面元素对象,DOM对象类型
	json:js中所使用css样式属性的"键－值"对象,JSON类型
	示例:
		html代码:
		<p id="demo">测试</p>
		js代码:
		var json={"color":"red","backgroundColor":"gray","fontSize":"30px"};
		setter.setCSS($("demo"),json);	
		结果:
		将id名为"demo"的段落设置灰色底，红色字和30像素大小字体
	*/
	"setCSS":function(obj_ele, styleAttr, value){
		//参数个数
		var len = arguments.length;
		if(len==3)
			obj_ele.style[styleAttr]=value;
		else if(len==2){
			var jsonObj = styleAttr;
			for(var i in jsonObj){
				obj_ele.style[i] = jsonObj[i];
			}
		}		
	}
	,
	/*	设置html属性
	用法1:指定三个参数:
	语法:setter.setAttr(obj, html, value)
	obj:html页面元素对象,DOM对象类型
	html:js中所使用html标签属性名,String类型
	value:js中所使用html标签属性值,String类型
	示例:
		html代码:
		<img id="demo" />
		js代码:
		setter.setAttr($("demo"),"src","demo.png");	
		结果:
		将id名为"demo"的图片元素设置图片为"demo.png"
	===========================================
	用法2:指定两个参数
	语法:setter.setAttr(obj, html)
	obj:html页面元素对象,DOM对象类型
	html:js中所使用html标签属性"键－值"对象,JSON类型
	示例:
		html代码:
		<img id="demo" />
		js代码:
		var attr={"src":"demo.png","width":400,"height":300}
		setter.setAttr($("demo"),attr);	
		结果:
		将id名为"demo"的图片元素设置图片为"demo.png",显示的宽为400,高为300
	*/
	"setAttr":function(obj_ele, htmlAttr, value){
		var len = arguments.length;
		if(len==3){
			obj_ele[htmlAttr] = value;
		}else if(len==2){
			for(var i in htmlAttr){
				obj_ele[i] = htmlAttr[i];
			}
		}
	}
	,
	/*	设置html元素之间文本
	用法:指定两个参数:
	语法:setter.setTxt(obj,txt)
	obj:html页面元素对象,DOM对象类型
	txt:html标签之间显示的文本,String类型
	示例:
		html代码:
		<div id="demo"></span>
		js代码:
		setter.setTxt($("demo"),"你好!");	
		结果:
		将id名为"demo"的块标记之间显示“你好!”
	*/
	"setTxt":function(obj_ele, txt){
		obj_ele.innerText = txt;
	}
	,
	/*	设置html元素之间hmtl文本
	用法:指定两个参数:
	语法:setter.setHTML(obj,html)
	obj:html页面元素对象,DOM对象类型
	hmtl:html标签之间显示的文本,可包含html标签,String类型
	示例:
		html代码:
		<div id="demo"></span>
		js代码:
		setter.setHTML($("demo"),"<font color='red'>你好!</font>");	
		结果:
		将id名为"demo"的块标记之间显示红色字体的“你好!”
	*/
	"setHTML":function(obj_ele, html){
		obj_ele.innerHTML = html;
	}
}