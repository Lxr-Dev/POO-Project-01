/**
 * 
 */
let modal = document.getElementById('miModal');
let flex = document.getElementById('flex');
let abrir1 = document.getElementById('abrir1');
let abrir2 = document.getElementById('abrir2');
let abrir3 = document.getElementById('abrir3');
let cerrar = document.getElementById('close');

abrir1.addEventListener('click',function(){
    modal.style.display = 'block';
});
abrir2.addEventListener('click',function(){
    modal.style.display = 'block';
});
abrir3.addEventListener('click',function(){
    modal.style.display = 'block';
});

cerrar.addEventListener('click',function(){
    modal.style.display = 'none';
});

window.addEventListener('click',function(e){
    if(e.target == flex){
        modal.style.display = 'none';
    }
});