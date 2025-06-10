document.getElementById('cadastroForm').addEventListener('submit',CadastrarJogo);

function CadastrarJogo(event){
    event.preventDefault();

    const name= document.getElementById('name').value;
    const platform =  document.getElementById('plataform').value;

    fetch('http://localhost:8080/Jogos',{
        method:'POST',
        headers:{
            'Content-Type':'application/json',
        },
        body: JSON.stringify({name, platform}),
    })
        .then(response => response.json())
        .then(data => {
            alert('Jogo Cadastrado com Sucesso');
            document.getElementById('cadastroForm').reset();
        })
        .catch(error => {
            console.error('Erro ao cadastrar ',error)
        });

}
