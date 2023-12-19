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



