<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>My Tour</title>

<link rel="stylesheet" href="resources/css/normalize.css" />
<link rel="stylesheet" href="resources/css/theme.css" />

</head>
<body>

	<div class="container">

		<div class="title">Add place</div>

		<%
			if (request.getAttribute("errors") != null) {
		%>
		<fieldset id="error_fieldset">
			<legend align="center">Errors</legend>
			<ul>

				<%
					if (request.getAttribute("placename_error") != null) {
				%>
				<li class="error">Place name error</li>
				<%
					}
				%>
				
				<%
					if (request.getAttribute("statename_error") != null) {
				%>
				<li class="error">State name error</li>
				<%
					}
				%>


				<%
					if (request.getAttribute("countryname_error") != null) {
				%>
				<li class="error">Country name error</li>
				<%
					}
				%>
			</ul>

		</fieldset>
		<%
			}
		%>

		<fieldset>

			<legend align="center">Places details</legend>

			<form action="AddPlace" method="post">

				<div class="inputField">
					<label for="place-name" class="inputLabel">Place name: </label> <input
						name="place-name" type="text" value="<%= request.getAttribute("place_name") %>"></input>
				</div>

				<div class="inputField">
					<label for="state-name" class="inputLabel">State: </label> <select
						name="state-name">
						<option value="CA">CA</option>
						<option value="NC">NC</option>
					</select>
				</div>
				
				<div class="inputField">
					<label for="country-name" class="inputLabel">Country: </label> <select
						name="country-name">
						<option value="USA">USA</option>
					</select>
				</div>
				
		</fieldset>

		<div class="inputField" id="submitField">
			<input id="submitBtn" type="submit" value="Add new place"></input>
		</div>


		</form>

	</div>

</body>
</html>