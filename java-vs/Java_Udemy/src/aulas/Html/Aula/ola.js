const meuFormulario = document.getElementById('form-contato');

meuFormulario.addEventListener('submit', (evento) => {
  // A linha mais importante: impede o recarregamento da página
  evento.preventDefault(); 
  
  console.log('Formulário interceptado! Validando dados...');
  // Aqui você faria a validação e o envio com fetch()
});