




function enviarCadastro() {
  // Obter dados do formulário
  let nome = document.getElementById('nome').value;
  let email = document.getElementById('email').value;
  let senha = document.getElementById('senha').value;

  // Criando objeto com os dados do formulário
  // let dados = {
   
  // }



  if (nome && email && senha) { 
  fetch('http://localhost:8080/cadastrar', {
    method: 'post',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      nomeUsuario: nome,
      emailUsuario: email,
      senhaUsario: senha
    }),
  })
    .then(response => response.json())
    .then(data => {
      // Lidar com a resposta do backend
      console.log('Resposta do backend:', data);
      alert("Conta criada com sucesso! Redirecionando para a rede social...");
      window.location.href = "../pagina_home/rede.html"
      // Aqui você pode tomar decisões com base na resposta, como redirecionar o usuário se o login for bem-sucedido
    })
    .catch(error => {
      // Lidar com erros de rede ou outros problemas
      console.error('Erro ao enviar dados de login:', error);
    });
  }
}
 

//Redirecionar para o login 

function redirecionar() {
  window.location.href = "../pagina_acesso/Login.html"
}
