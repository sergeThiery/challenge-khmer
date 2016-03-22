<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel='stylesheet'
	href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<title>Spring pagination using data tables</title>

	<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
<script type="text/javascript"
	src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {

				var table = $("#teamTable").dataTable({
					"sAjaxSource" : "v1/Teams",
					"fnServerData" : function(sSource, aoData, fnCallback) {
						$.ajax({
							"dataType" : 'json',
							"type" : "GET",
							"url" : sSource,
							"data" : aoData,
							"success" : fnCallback
						});
					},
					"sServerMethod" : "GET",
					"sAjaxDataProp" : "",
					"aoColumns" : [ {
						"mData" : "name"
					}, {
						"mData" : "sportType"
					}, {
						"mData" : "city"
					} ]

				});
				$('#teamTable tbody').on('click', 'tr', function() {
					if ($(this).hasClass('selected')) {
						$(this).removeClass('selected');
					} else {
						table.$('tr.selected').removeClass('selected');
						$(this).addClass('selected');
					}
				});

				$('#button').click(function() {
					table.row('.selected').remove().draw(false);
				});

				var counter = 1;

				$('#addRow').on(
						'click',
						function() {
							table.row.add(
									[ counter + '.1', counter + '.2',
											counter + '.3', counter + '.4',
											counter + '.5' ]).draw();

							counter++;
						});

				// Automatically add a first row of data
				$('#addRow').click();

			});
</script>
</head>
<body>


	<form:form action="" method="GET">
		<h2>
			Challenge Camerounais 2016 - Teams <br> <br>
		</h2>
		<table width="70%"
			style="border: 3px; background: rgb(243, 244, 248);">
			<tr>
				<td>
					<table id="teamTable" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>Name</th>
								<th>Sport</th>
								<th>City</th>
							</tr>
						</thead>
					</table>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>