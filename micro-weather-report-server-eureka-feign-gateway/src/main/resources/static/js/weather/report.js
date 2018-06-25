/**
 * 页面下拉框事件
 */
$(function () {
	$("#selectId").change(function (e) {
		var cityId= $("#selectId").val();
		var url = "/report/cityId/"+cityId;
		window.location.href = url;
	})
})