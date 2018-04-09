<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="nevicelabs.blog.Postagem" %>
<%@ page import="nevicelabs.blog.PostagemBean" %>
<%@ page import="nevicelabs.blog.PostagemDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Meus Caracóis Neurais</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
		<link rel="stylesheet" type="text/css" href="css/texto.css">
		<script type="text/javascript" src="js/scripts.js"></script>
	</head>
 
	<body class="w3-light-grey">

		<!-- w3-content defines a container for fixed size centered content, 
		and is wrapped around the whole page content, except for the footer in this example -->
		<div class="w3-content" style="max-width: 1400px">

			<!-- Header -->
			<header class="w3-container w3-center w3-padding-32">
				<h1>
					<a href="index.jsp"><b>Meus Caracóis Neurais</b></a>
				</h1>
				<p class="sub">
					Sobre a vida, o universo e <span class="w3-tag">tudo o mais</span>
				</p>
			</header>
			<!-- End Header -->

			<!-- Área dinâmica -->
			<% if(pageid == 1) {
				PostagemBean bean = new PostagemBean();
				List<Postagem> postagens = bean.getPostagens();

				if(postagens.isEmpty()) { %>
					<!-- Grid -->
					<form action="servlet" method="post" id="postPanel">
						<div class="w3-row" class="w3-container w3-white">
						<section class="w3-col l8 s12">
							<div class="w3-card-2 w3-margin w3-margin-top">
							<div class="w3-container w3-white">
								<h1 class="titulo">Nenhuma Postagem</h1>
								<p>
									<a href="restrito/novaPostagem.xhtml">Nova Postagem</a>
								</p>
							</div>
							</div>
						</section>
					</form>
			<% } else { %>
			<!-- Grid -->
			<form action="servlet" method="post" id="postPanel">
				<div class="w3-row" class="w3-container w3-white">
				<section class="w3-col l8 s12">
					<% for (Postagem post : postagens) { 
						String postTitulo = post.getTitulo();
						String pagina = postTitulo.toLowerCase().replaceAll("\\s","");
						%>
					<div class="w3-card-2 w3-margin w3-margin-top">
					<div class="w3-container w3-white">
						<h1 class="titulo"><a href="posts/<%=pagina%>.html"><%=postTitulo%></a></h1>
					</div>
					</div>
					<% } %>
				</section>
			</form>
			<% } 
			}%>
			<!-- Fim da área dinâmica -->

			<!-- Introduction menu -->
			<div class="w3-col l4">
				<!-- About Card -->
				<div class="w3-card-2 w3-margin w3-margin-top">
					<img src="img/avatar.jpg" style="width: 100%">
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

				<!-- Posts -->
				<div class="w3-card-2 w3-margin">
					<div class="w3-container w3-padding">
						<h4>Popular Posts</h4>
					</div>
					<ul class="w3-ul w3-hoverable w3-white">
						<li class="w3-padding-16"><img src="/w3images/workshop.jpg"
							alt="Image" class="w3-left w3-margin-right" style="width: 50px">
							<span class="w3-large">Lorem</span><br> <span>Sed
								mattis nunc</span></li>
						<li class="w3-padding-16"><img src="/w3images/gondol.jpg"
							alt="Image" class="w3-left w3-margin-right" style="width: 50px">
							<span class="w3-large">Ipsum</span><br> <span>Praes
								tinci sed</span></li>
						<li class="w3-padding-16"><img src="/w3images/skies.jpg"
							alt="Image" class="w3-left w3-margin-right" style="width: 50px">
							<span class="w3-large">Dorum</span><br> <span>Ultricies
								congue</span></li>
						<li class="w3-padding-16 w3-hide-medium w3-hide-small"><img
							src="/w3images/rock.jpg" alt="Image"
							class="w3-left w3-margin-right" style="width: 50px"> <span
							class="w3-large">Mingsum</span><br> <span>Lorem ipsum
								dipsum</span></li>
					</ul>
				</div>
				<hr>

				<!-- Labels / tags -->
				<div class="w3-card-2 w3-margin">
					<div class="w3-container w3-padding">
						<h4>Tags</h4>
					</div>
					<div class="w3-container w3-white">
						<p class="sub">
							<span class="w3-tag w3-black w3-margin-bottom">Travel</span> <span
								class="w3-tag w3-light-grey w3-small w3-margin-bottom">New
								York</span> <span
								class="w3-tag w3-light-grey w3-small w3-margin-bottom">London</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">IKEA</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">NORWAY</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">DIY</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Ideas</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Baby</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Family</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">News</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Clothing</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Shopping</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Sports</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Games</span>
						</p>
					</div>
				</div>

				<!-- END Introduction Menu -->
			</div>

			<!-- END GRID -->
		</div>
		<br>

		<!-- END w3-content -->
	</div>

	<!-- Footer -->
	<footer class="w3-container w3-dark-grey w3-padding-32 w3-margin-top">
		<button class="w3-btn w3-disabled w3-padding-large w3-margin-bottom">Previous</button>
		<button class="w3-btn w3-padding-large w3-margin-bottom">Next
			&raquo;</button>
		<p>
			Powered by <a href="http://www.w3schools.com/w3css/default.asp"
				target="_blank">w3.css</a>
		</p>
	</footer>

</body>
</html>