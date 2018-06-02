function requestPost() {
	// alert('Botão clicado');
}

$(document).ready(function() {
	$('.tituloPostagem').click(function() {
		alert('Clicado');

		// Exemplo: CaracoisNeurais/posts/sapiens_1.html
		var carregaUrl = '/posts/' + this.id + '.html';

		$.ajax({
			url: carregaUrl,
			success: function(data) {
				$('#div_conteudo').html(data);
			}
		});
	});
});