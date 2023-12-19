

//Post
document.addEventListener('DOMContentLoaded', function () {
    //referencia os ID's do html
    const textarea = document.getElementById('novoPost');
    const compartilharBtn = document.getElementById('compartilharBtn');
    const boxContainer = document.getElementById('boxContainer');
    const postsContainer = document.getElementById('postsContainer');





    //botao de compartilhar
    compartilharBtn.addEventListener('click', () => {
        // Get the text from the textarea
        const postText = textarea.value;

        //vê se o texto nao está vazio
        if (postText.trim() !== '') {
            // cria um novo post
            const newPost = createPostElement(postText);

            // Adicionar a nova postagem na div de postagens no início
            postsContainer.insertBefore(newPost, postsContainer.firstChild);

            // Limpa a área que o texto foi escrito
            textarea.value = '';

            // Altera o tamanho da box de traz dos posts
            updateBoxHeight();
        }
    });

    // Função pra criar um novo post
    function createPostElement(text) {
        const postDiv = document.createElement('div');
        postDiv.classList.add('post');

        const perfilPostDiv = document.createElement('div');
        perfilPostDiv.classList.add('perfilPost');



        // Adciciona a foto de perfil, o nome e a data
        const nomeUsuario = document.querySelector('.nomePerfilCapa').textContent;
        perfilPostDiv.innerHTML = `
        <img src="../../Assets/perfil.jpg" alt="">
        <div class="usuarioData">
            <h2 class="nomePerfil">${nomeUsuario}</h2>
            <h4 class="dataPost">${getCurrentDate()}</h4>
        </div>
        `;



        const espacoPostDiv = document.createElement('div');
        espacoPostDiv.classList.add('espacoPost');

        // Adiciona o conteúdo do post
        const conteudoPostP = document.createElement('p');
        conteudoPostP.classList.add('conteudoPost');
        conteudoPostP.textContent = text;

        // adicionar o novo post ao div que já existe
        espacoPostDiv.appendChild(conteudoPostP);
        postDiv.appendChild(perfilPostDiv);
        postDiv.appendChild(espacoPostDiv);

        return postDiv;
    }

    // Altera o tamanho da div
    function updateBoxHeight() {
        const postsHeight = postsContainer.offsetHeight;
        boxContainer.style.height = `${postsHeight}px`;
    }

    // Coloca a data no formato dia/mes/ano
    function getCurrentDate() {
        const currentDate = new Date();
        const day = currentDate.getDate();
        const month = currentDate.getMonth() + 1;
        const year = currentDate.getFullYear();
        return `${day}/${month}/${year}`;
    }
});


//Calendario


const calendar = document.querySelector(".calendar"),
date = document.querySelector(".date"),
daysContainer = document.querySelector(".days"),
prev = document.querySelector(".prev"),
next = document.querySelector(".next"),
todayBtn = document.querySelector(".today-btn"),
gotoBtn = document.querySelector(".goto-btn"),
dateInput = document.querySelector(".date-input");


    let today = new Date();
    let activeDay;
    let month = today.getMonth();
    let year = today.getFullYear();

    const months = [
        "Janeiro",
        "Fevereiro",
        "Março",
        "Abril",
        "Maio",
        "Junho",
        "Julho",
        "Agosto",
        "Setembro",
        "Outubro",
        "Novembro",
        "Dezembro"
    ]

    //função para adicionar os dias do calendário

    function initCalendar(){
        //Função pega os dias do passado, atual e próximo mês
        const firstDay = new Date(year, month, 1);
        const lastDay = new Date(year, month + 1, 0);
        const prevLastDay = new Date(year, month, 0);
        const prevDays = prevLastDay.getDate();
        const lastDate = lastDay.getDate();
        const day = firstDay.getDay();
        const nextDays = 7 - lastDay.getDay() -1 ;
        //atualiza o topo do calendário
        date.innerHTML = months[month] + " " + year;

        //adiciona os dias 
        let days = ""; 
        //mês passado
        for(let x = day; x > 0; x--){
            //Enviar HTML utilizando o JS
            days += `<div class="day prev-date">${prevDays -x + 1}</div>`
        }
        //mês atual
        for (let i = 1 ; i <= lastDate ; i++ ){
            if(i === new Date().getDate() &&
            year === new Date().getFullYear() &&
            month === new Date().getMonth()) {
            days += `<div class="day today">${i}</div>`
            }   
            else{
                days += `<div class="day">${i}</div>`
            }
        }
        //próximo mês 
        for(let j = 1; j <= nextDays; j++){
            days += `<div class="day next-date">${j}</div>`
        }

        daysContainer.innerHTML = days;
    }
    
    initCalendar();

    //mês anterior
    function prevMonth(){
        month--;
        if (month < 0){
            month = 11;
            year--;

        }
        initCalendar();
    }
    

    //prox mês
    function nextMonth(){
        month++;
        if(month>11){
            month = 0;
            year++;
        }
        initCalendar();
    }

    //eventlist

    prev.addEventListener("click", prevMonth);
    next.addEventListener("click", nextMonth);


    todayBtn.addEventListener("click", ()=> {
        today = new Date();
        month = today.getMonth();
        year = today.getFullYear();
        initCalendar();

        
    })

    dateInput.addEventListener("input", (e)=> {
        // faz com que só permita números
        dateInput.value = dateInput.value.replace(/[^0-9/]/g, "");
        if(dateInput.value.length === 2){
            dateInput.value += "/";
        }
        if (dateInput.value.length > 7){
            dateInput.value = dateInput.value.slice(0, 7);
        }

        if(e.inputType === "deleteContentBackward"){
           if(dateInput.value.length === 3){
                dateInput.value = dateInput.value.slice(0, 2);
            }
        }
    })

    
    gotoBtn.addEventListener("click", gotoDate);

    function gotoDate(){
        const dateArr = dateInput.value.split("/"); 
        if(dateArr.length === 2){
            if(dateArr[0] > 0 && dateArr[0] < 13 && dateArr[1].length === 4){
                month = dateArr[0] - 1;
                year = dateArr[1];
                initCalendar();
                return;
            }
        }
        alert("Invalid Date")
    }


// Adicione um evento de clique para o container dos dias (daysContainer)
daysContainer.addEventListener("click", (event) => {
    const clickedDay = event.target;
    if (clickedDay.classList.contains("day")) {
        const selectedDay = clickedDay.textContent
        const calendarPageURL = "../pagina_calendario/index.html";
        window.location.href = calendarPageURL;
    }
});
