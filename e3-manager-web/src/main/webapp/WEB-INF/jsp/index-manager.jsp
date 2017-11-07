<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="${pageContext.request.contextPath }/layout/inc.jsp"></jsp:include>
<div style="padding:10px 10px 10px 10px">	
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="dataImport()">导入索引</a>
	</div>
</div>
<script type="text/javascript">
	//定义导入索引库函数
	function dataImport(){
		
		$.ajax({
			type:'POST',
			url:'${pageContext.request.contextPath}/item/dataImport',
			success:function(data){
				if(data.status==200){
					$.messager.alert('提示','导入索引库成功!');
				}else{
					$.messager.alert('提示','导入失败!');
				}
			}
			
		})
		
	}



</script>
