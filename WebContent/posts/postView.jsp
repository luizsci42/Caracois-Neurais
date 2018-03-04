<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="nevicelabs.blog.Postagem" %>
<%@ page import="nevicelabs.blog.PostagemBean" %>
<%@ page import="nevicelabs.blog.PostagemDAO" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Meus Caracóis Neurais</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
		<link rel="stylesheet" type="text/css" href="../css/texto.css">
		<script type="text/javascript" src="../js/scripts.js"></script>
	</head>
 
	<body class="w3-light-grey">

		<!-- w3-content defines a container for fixed size centered content, 
		and is wrapped around the whole page content, except for the footer in this example -->
		<div class="w3-content" style="max-width: 1400px">

			<!-- Header -->
			<header class="w3-container w3-center w3-padding-32">
				<h1>
					<a href="../index.jsp"><b>Meus Caracóis Neurais</b></a>
				</h1>
				<p class="sub">
					Sobre a vida, o universo e <span class="w3-tag">tudo o mais</span>
				</p>
			</header>
			<!-- End Header -->

			<!-- Área dinâmica -->
			<% String postId = request.getParameter("id");
				int id = Integer.parseInt(postId);
				PostagemBean bean = new PostagemBean();

				Postagem post = bean.exibirPostagem(id);

				String titulo = post.getTitulo();
				String conteudo = post.getConteudo();

				System.out.println(titulo);
				System.out.println(conteudo);
			%>
			<!-- Grid -->
			<div class="w3-row" class="w3-container w3-white">
			<section class="w3-col l8 s12">
				<div class="w3-card-2 w3-margin w3-margin-top">
				<div class="w3-container w3-white">
					<h1 class="titulo"><%=titulo%></h1>
					<p>
						<%=conteudo%>
					</p>
				</div>
				</div>
			</section>
			<!-- Fim da área dinâmica -->

			<!-- Introduction menu -->
			<div class="w3-col l4">
				<!-- About Card -->
				<div class="w3-card-2 w3-margin w3-margin-top">
					<img src="../img/avatar.jpg" style="width: 100%">
					<div class="w3-container w3-white">
						<h4>
							<b>Luiz Felipe Souza</b>
						</h4>
						<p>
							Sabe, sempre fui uma criança estranha | Estudante de Ciência da Computação; louco já sou, só me falta ser cientista. Welcome to my weird little world.
						</p>
					</div>
				</div>
				<hr>

			<!-- END GRID -->
		</div>
		<br>
		<!-- END w3-content -->
	</div>

	<!-- Footer -->
	<footer class="w3-container w3-dark-grey w3-padding-32 w3-margin-top">
		<p>
			Powered by <a href="http://www.w3schools.com/w3css/default.asp"
				target="_blank">w3.css</a>
		</p>
	</footer>

</body>
</html>