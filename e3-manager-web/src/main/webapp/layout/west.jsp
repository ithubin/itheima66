<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function(){
		$('#menu').tree({
			onClick: function(node){
				if($('#menu').tree("isLeaf",node.target)){
					
									
						addTab({
							url : node.attributes.url,
							title : node.text,
							iconCls : node.iconCls
						})
						
					}
				}
			})
		});
	$(function(){
		$('#menu1').tree({
			onClick: function(node){
				if($('#menu').tree("isLeaf",node.target)){
						addTab({
							url : node.attributes.url,
							title : node.text,
							iconCls : node.iconCls
						})
						
					}
				}
			})
		});
	function addTab(params) {
		var iframe = '<iframe src="' + params.url + '" frameborder="0" style="border:0;width:100%;height:98%;"></iframe>';
		var t = $('#index_tabs');
		var opts = {
			title : params.title,
			closable : true,
			iconCls : params.iconCls,
			content : iframe,
			border : false,
			fit : true
		};
		if (t.tabs('exists', opts.title)) {
			t.tabs('select', opts.title);
			parent.$.messager.progress('close');
		} else {
			t.tabs('add', opts);
		}
	}
</script>
<div class="easyui-accordion" data-options="fit:true,border:false">	
	<div title="商品管理" data-options="border:false">
		<ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
         	
	         		<li data-options="attributes:{'url':'item-add'}">新增商品</li>
	         		<li data-options="attributes:{'url':'item-list'}">查询商品</li>
	         		<li data-options="attributes:{'url':'item-param-list'}">规格参数</li>
	        
         </ul>
	</div>
	<div title="广告管理" data-options="border:false">
		<ul id="menu1" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
         	
	         		<li data-options="attributes:{'url':'content-category'}">内容分类管理</li>
	         		<li data-options="attributes:{'url':'content'}">内容管理</li>
	         		<li data-options="attributes:{'url':'index-manager'}">索引库维护</li>
	         
         </ul>
	</div>
	<div title="促销管理" data-options="border:false">
		<ul>
			<li>菜单</li>
			<li>菜单</li>
			<li>菜单</li>
		</ul>
	</div>
	<div title="订单管理" data-options="border:false">
		<ul>
			<li>菜单</li>
			<li>菜单</li>
			<li>菜单</li>
		</ul>
	</div>
	<div title="报表统计" data-options="border:false">
		<ul>
			<li>菜单</li>
			<li>菜单</li>
			<li>菜单</li>
		</ul>
	</div>
	<div title="文章管理" data-options="border:false">
		<ul>
			<li>菜单</li>
			<li>菜单</li>
			<li>菜单</li>
		</ul>
	</div>
	<div title="会员管理" data-options="border:false">
		<ul>
			<li>菜单</li>
			<li>菜单</li>
			<li>菜单</li>
		</ul>
	</div>
	<div title="权限管理" data-options="border:false">
		<ul>
			<li>菜单</li>
			<li>菜单</li>
			<li>菜单</li>
		</ul>
	</div>
	<div title="系统设置" data-options="border:false">
		<ul>
			<li>菜单</li>
			<li>菜单</li>
			<li>菜单</li>
		</ul>
	</div>
	<div title="短信管理" data-options="border:false">
		<ul>
			<li>菜单</li>
			<li>菜单</li>
			<li>菜单</li>
		</ul>
	</div>
	<div title="邮件群发管理" data-options="border:false">
		<ul>
			<li>菜单</li>
			<li>菜单</li>
			<li>菜单</li>
		</ul>
	</div>
	<div title="云服务中心" data-options="border:false">
		<ul>
			<li>菜单</li>
			<li>菜单</li>
			<li>菜单</li>
		</ul>
	</div>
</div>