const observer = new IntersectionObserver((entries) => {
     entries.forEach((entry) => {
            console.log(entry)
            if (entry.isIntersecting){
                entry.target.classList.add('show');
            }else{
                entry.target.classList.remove('show');
            }
      });
});

const hiddenElements = document.querySelectorAll('.hidden');
hiddenElements.forEach((el) => observer.observe(el));





var counter = 1;
setInterval(function(){
  document.getElementById('radio' + counter).checked = true;
  counter++;
  if(counter > 4){
     counter = 1;
     }
  }, 5000);
const menuBtn = document.querySelector('.menu-button');
let menuOpen = false;
menuBtn.addEventListener('click', () => {
  if(!menuOpen) {
       menuBtn.classList.add('open');
       menuOpen = true;
  } else{
     menuBtn.classList.remove('open');
     menuOpen = false;
  }
});
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}
const openBtn = document.getElementById("open0");
const modal_container = document.getElementById('modal_container0');
const closer = document.getElementById('closer0');
//const nextBtn = document.getElementById('next');
//const nextModal = document.getElementById('nextModal');
//const modal = document.getElementById('modalpop');
//const Ncloser = document.getElementById('Ncloser');
const ticket = document.getElementById('DDList');
const Quant = document.getElementById('DDList2');
const event = document.getElementById('event');
const summary = document.getElementById('summary');

openBtn.addEventListener('click', () => {
    modal_container.classList.remove('unshow');
    modal_container.classList.add('show');
});
closer.addEventListener('click', () => {
    modal_container.classList.add('unshow');
    modal_container.classList.remove('show');

});

//nextBtn.addEventListener('click', () => {
//    nextModal.classList.remove('unshow');
//    nextModal.classList.add('show');
//    summary.innerHTML = `You have selected ${Quant.value} x ${ticket.value.substring(1)} tickets.`;
//
//});

//Ncloser.addEventListener('click', () => {
//    nextModal.classList.add('unshow');
//    nextModalclassList.remove('show');
//
//});

const openBtn2 = document.getElementById("open1");
const modal_container2 = document.getElementById('modal_container1');
const closer2 = document.getElementById('closer1');

openBtn2.addEventListener('click', () => {
    modal_container2.classList.remove('unshow');
    modal_container2.classList.add('show');
});
closer2.addEventListener('click', () => {
    modal_container2.classList.add('unshow');
    modal_container2.classList.remove('show');
});

const openBtn3 = document.getElementById("open2");
const modal_container3 = document.getElementById('modal_container2');
const closer3 = document.getElementById('closer2');

openBtn3.addEventListener('click', () => {
    modal_container3.classList.remove('unshow');
    modal_container3.classList.add('show');
});
closer3.addEventListener('click', () => {
    modal_container3.classList.add('unshow');
    modal_container3.classList.remove('show');
});
const openBtn4 = document.getElementById("open3");
const modal_container4 = document.getElementById('modal_container3');
const closer4 = document.getElementById('closer3');

openBtn4.addEventListener('click', () => {
    modal_container4.classList.remove('unshow');
    modal_container4.classList.add('show');
});
closer4.addEventListener('click', () => {
    modal_container4.classList.add('unshow');
    modal_container4.classList.remove('show');
});



