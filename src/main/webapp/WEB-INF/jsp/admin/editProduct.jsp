<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/17
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/admin/adminHeader.jsp" %>
<%@include file="../include/admin/adminNavigator.jsp" %>

<style>
    .layui-form-label {
        width: 100px !important;
    }
</style>

<script>
    $(function () {
        $("editForm").submit(function () {
            if (!checkEmpty("name", "产品名称")) {
                return false;
            }
            if (!checkNumber("originalPrice", "原价格")) {
                return false;
            }
            if (!checkNumber("promotePrice", "优惠价格")) {
                return false;
            }
            if (!checkInt("stock", "库存")) {
                return false;
            }
        })
    });
</script>
<title>产品编辑</title>

<div class="workingArea">
    <ol class="breadcrumb">
        <li><a href="/admin_category_list">所有分类</a></li>
        <li><a href="/admin_product_list?cid=${product.category.id}">${product.category.name}</a></li>
        <li class="active">${product.name}</li>
        <li class="active"> 编辑产品</li>
    </ol>

    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑产品</div>
        <div class="panel-body">
            <form class="layui-form" method="post" action="admin_product_update"
                  id="editForm">

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">产品名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="phone" lay-verify="required|phone" autocomplete="off"
                                   value="${product.name}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">产品小标题</label>
                        <div class="layui-input-inline">
                            <input type="text" name="email" lay-verify="email"
                                   value="${product.subTitle}"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">原价格</label>
                        <div class="layui-input-inline">
                            <input type="text" lay-verify="email"
                                   value="${product.originalPrice}"
                                   id="originalPrice"
                                   name="originalPrice"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-inline">
                        <label class="layui-form-label">优惠价格</label>
                        <div class="layui-input-inline">
                            <input type="text"
                                   id="promotePrice"
                                   name="promotePrice"
                                   value="${product.promotePrice}"
                                   lay-verify="email" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-inline">
                        <label class="layui-form-label">库存</label>
                        <div class="layui-input-inline">
                            <input type="text"
                                   id="stock"
                                   name="stock"
                                   value="${product.stock}"
                                   lay-verify="email" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-input-block">
                        <input type="hidden" name="id" value="${product.id}">
                        <input type="hidden" name="cid" value="${product.category.id}">
                        <button class="layui-btn" lay-submit=""
                                lay-filter="demo1">立即提交
                        </button>
                    </div>
                </div>


            </form>
        </div>
    </div>
</div>
