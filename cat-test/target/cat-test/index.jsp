<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>


<form action="registration" method="post" name="catform">
					<label for="personal-name">Име на собственика</label> <input type="text"
						name="personal-name" id="personal-name"
						placeholder="Въведете име на собственик" /> <br>
						
					<label for="cat-name">Име на котка</label> <input type="text"
						name="cat-name" id="cat-name"
						placeholder="Въведете име на котка" /> <br>
						
					<label for="breed">Порода</label> <input type="text"
						name="breed" id="breed"
						placeholder="Въведете порода" /> <br>
						
					<label for="description">Описание</label> 
					<textarea name="description" id="description"  rows="10" cols="30"
					 	placeholder="Въведете кратко описание на домашния любимец"></textarea> <br>
						
				<input type="submit" value="Вход" />
			</form>
</body>
</html>