document.addEventListener('DOMContentLoaded',function(){
    const monthBR = ['janeiro', 'fevereiro', 'março', 'abril', 'maio', 'junho', 'julho', 'agosto', 'setembro', 'outubro', 'novembro', 'dezembro'];
    const tableDays = document.getElementById('dias');
    function GetDaysCalendar(month,ano){
        document.getElementById('month').innerHTML = monthBR[month];
        document.getElementById('ano').innerHTML = ano;

        let firstDayOfWeek = new Date(ano, month, 1).getDay()-1;
        let getLastDayThisMonth = new Date(ano,month+1,0).getDate();

        for(var i = -firstDayOfWeek, index = 0; 1 < (42-firstDayOfWeek); i++, index++){
            let dt = new Date(ano,month,i);
            let dtNow = new Date();
            let dayTable = tableDays.getElementsByTagName('td')[index];
            dayTable.classList.remove('mes-anterior');
            dayTable.classList.remove('proximo-mes');            
            dayTable.classList.remove('dia-atual');
            dayTable.innerHTML = dt.getDate();

            if(dt.getFullYear() == dtNow.getFullYear() && dt.getMonth() == dtNow.getMonth() && dt.getDate() == dtNow.getDate()){
                dayTable.classList.add('dia-atual')
            }
            if(i < 1){
                dayTable.classList.add('mes-anterior')
            }
            if(i > getLastDayThisMonth){
                dayTable.classList.add('proximo-mes')
            }
        }
    }

    let now = new Date();
    let month = now.getMonth();
    let ano = now.getFullYear();
    

    const botao_proximo = document.getElementById("btn_prev");
    const botao_anterior = document.getElementById("btn_ant");
    
    botao_proximo.onclick = function(){
        month++; 
        if(month > 11){
            month = 0;
            ano++;
        }
        GetDaysCalendar(month,ano);       
    }
    botao_anterior.onclick = function(){
        month--;
        if(month < 0){
            month = 11;
            ano--;
        } 
        GetDaysCalendar(month,ano);       
    }
    GetDaysCalendar(month,ano);
})