function botaoCadastrar() {
    // Use window.location.assign para redirecionar
    window.location.assign("../pagina_cadastro/index.html");
  }
  

function fazerLogin() {
    // Obter os valores dos campos de usuário e senha
    const username = document.getElementById('email').value;
    const password = document.getElementById('senha').value;

    // Construir objeto com os dados de login
    const dadosDeLogin = {
        email: username,
        senha: password
    };
    alert(username +"  "+  password);
    //Até aqui td certo
    alert(JSON.stringify(dadosDeLogin));

    //ajax
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'https://localhost:8080/logar', true);
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');

    xhr.addEventListener('load', function () {
        if (xhr.status === 200) {
            alert('Login realizado com sucesso');
            window.location.href = "../pagina_home/rede.html";
        } else {
            alert('Erro ao logar. Tente novamente. Detalhes do erro: ' + xhr.responseText);
        }
    });

    xhr.send(JSON.stringify(dadosDeLogin));

}





//**   Enviar dados para o backend
//  fetch('http://localhost:8080/logar', {
//   method: 'POST',
//   headers: {
//       'Content-Type': 'application/json',
//   },
// body: JSON.stringify(dadosDeLogin),
//    })
//   .then(response => response.json())
//   .then(data => {
// Lidar com a resposta do backend
//     console.log('Resposta do backend:', data);
// Aqui você pode tomar decisões com base na resposta, como redirecionar o usuário se o login for bem-sucedido
//   })
//  .catch(error => {
// Lidar com erros de rede ou outros problemas
//    console.error('Erro ao enviar dados de login:', error);
//  });




/**
 * 
 */




