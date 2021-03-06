
function initFileInput() {
	 
	      var control = $("#ids");
	      control.fileinput({
	    	  language: 'zh', //设置语言
	          uploadUrl:'<%=request.getContextPath()%>/m/fileInput', //上传的地址
	         allowedFileExtensions: ['jpg', 'gif', 'png','jpeg'],//接收的文件后缀
	         //uploadExtraData:{"id": 1, "fileName":'123.mp3'},
	          uploadAsync: true, //默认异步上传
	          showUpload:true, //是否显示上传按钮
	          showRemove :true, //显示移除按钮
	          showPreview :true, //是否显示预览
	          showCaption:false,//是否显示标题
	          browseClass:"btn btn-primary", //按钮样式    
	         dropZoneEnabled: false,//是否显示拖拽区域
	         //minImageWidth: 50, //图片的最小宽度
	         //minImageHeight: 50,//图片的最小高度
	         //maxImageWidth: 1000,//图片的最大宽度
	         //maxImageHeight: 1000,//图片的最大高度
	          //maxFileSize:0,//单位为kb，如果为0表示不限制文件大小
	         //minFileCount: 0,
	          maxFileCount:10, //表示允许同时上传的最大文件个数
	          enctype:'multipart/form-data',
	         validateInitialCount:true,
	          previewFileIcon: "<iclass='glyphicon glyphicon-king'></i>",
	         msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
	      
	     }).on('filepreupload', function(event, data, previewId, index) {     //上传中
	          var form = data.form, files = data.files, extra = data.extra,
	          response = data.response, reader = data.reader;
	          console.log('文件正在上传');
	      }).on("fileuploaded", function (event, data, previewId, index) {    //一个文件上传成功
	          console.log('文件上传成功！'+data.id);
              $("#img").val(data.response.imgPath);
	              alert('处理成功');
	      }).on('fileerror', function(event, data, msg) {  //一个文件上传失败
	          console.log('文件上传失败！'+data.id);
	      })
}

function initFileInputs() {
	 
	      var control = $("#addids");
	      control.fileinput({
	    	  language: 'zh', //设置语言
	          uploadUrl:"<%=request.getContextPath()%>/appliances/add", //上传的地址
	         allowedFileExtensions: ['jpg', 'gif', 'png','jpeg'],//接收的文件后缀
	         //uploadExtraData:{"id": 1, "fileName":'123.mp3'},
	          uploadAsync: true, //默认异步上传
	          showUpload:true, //是否显示上传按钮
	          showRemove :true, //显示移除按钮
	          showPreview :false, //是否显示预览
	          showCaption:false,//是否显示标题
	          browseClass:"btn btn-primary", //按钮样式    
	         dropZoneEnabled: false,//是否显示拖拽区域
	         //minImageWidth: 50, //图片的最小宽度
	         //minImageHeight: 50,//图片的最小高度
	         //maxImageWidth: 1000,//图片的最大宽度
	         //maxImageHeight: 1000,//图片的最大高度
	          //maxFileSize:0,//单位为kb，如果为0表示不限制文件大小
	         //minFileCount: 0,
	          maxFileCount:10, //表示允许同时上传的最大文件个数
	          enctype:'multipart/form-data',
	         validateInitialCount:true,
	          previewFileIcon: "<iclass='glyphicon glyphicon-king'></i>",
	         msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
	      
	     }).on('filepreupload', function(event, data, previewId, index) {     //上传中
	          var form = data.form, files = data.files, extra = data.extra,
	          response = data.response, reader = data.reader;
	          console.log('文件正在上传');
	      }).on("fileuploaded", function (event, data, previewId, index) {    //一个文件上传成功
	          console.log('文件上传成功！'+data.id);
	          
	              alert('处理成功');
	              location.href="<%=request.getContextPath()%>/tolist.action";
	      }).on('fileerror', function(event, data, msg) {  //一个文件上传失败
	          console.log('文件上传失败！'+data.id);
	      })
}