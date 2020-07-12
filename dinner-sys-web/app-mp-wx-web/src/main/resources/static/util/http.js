
(function($){
	


	//cookie
	function getCookie(name) {
						var cookieValue = null;
						if (document.cookie && document.cookie !== '') {
							var cookies = document.cookie.split(';');
							for (var i = 0; i < cookies.length; i++) {
								var cookie = $.trim(cookies[i]);
								if (cookie.substring(0, name.length + 1) === (name + '=')) {
									cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
									break;
								}
							}
						}
						return cookieValue;
					}
   //备份jquery的ajax方法     
   var _ajax=$.ajax;     
   var token_name = "user_openId_token";  //cookie放token的名称
   var shop_id = "shop_id";
   var http_head = "http://small.nat300.top/";  //统一API域名
   //重写jquery的ajax方法     
 
   $.ajax=function(opt){     
   	opt.data["token"] = getCookie(token_name);
	opt.data['shop_id'] = getCookie(shop_id);
	opt.data['url'] = http_head.concat(opt.data['url']);
   //	console.log(opt)
   	 var loading = weui.loading('loading');
       //备份opt中error和success方法     
       var fn = {     
           error:function(XMLHttpRequest, textStatus, errorThrown){},     
           success:function(data, textStatus){}
           
        }     
        if(opt.error){     
            fn.error=opt.error;     
        }     
        if(opt.success){     
            fn.success=opt.success;     
        }     
            
        //扩展增强处理     
        var _opt = $.extend(opt,{     
            error:function(XMLHttpRequest, textStatus, errorThrown){     
                //错误方法增强处理     
             
                fn.error(XMLHttpRequest, textStatus, errorThrown);     
                 loading.hide();//关闭
            },     
            success:function(data, textStatus){   
            
                //成功回调方法增强处理     
                var error = data.error;  
                if (error != undefined && error == true) {  
                    if (layer) {  
                        $.toast(data.msg, "forbidden");  
                    } else {  
                         $.toast(data.reason, 'error');  
                    }  
                    return;  
                }  
                fn.success(data, textStatus);     
                  loading.hide();//关闭
            }     
        });     
        
       
        _ajax(_opt);     
    };     
})(jQuery);    