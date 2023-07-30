function showAddTickForm() {
    document.getElementById('createTicket0').style.display = 'block';
    document.getElementById('createTicket1').style.display = 'block';
    document.getElementById('createTicket2').style.display = 'block';
    document.getElementById('createTicket3').style.display = 'block';
}



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
const AopenBtn = document.getElementById("op");
const Amodal_container = document.getElementById('modal_contain');
const Acloser = document.getElementById('clos');
AopenBtn.addEventListener('click', () => {
    Amodal_container.classList.remove('unshow');
    Amodal_container.classList.add('show');
});
Acloser.addEventListener('click', () => {
    Amodal_container.classList.add('unshow');
    Amodal_container.classList.remove('show');

});
// let opener = "open";
// let modall = "modal_container";
// let closerr = "closer";
// for (var i = 0; i < 10; i++) {
//     opener = opener + String(i);
//     modall = modall + String(i);
//     closerr = closerr + String(i);
//     const openBtn = document.getElementById(opener);
//     const modal_container = document.getElementById(modall);
//     const closer = document.getElementById(closerr);
//     openBtn.addEventListener('click', () => {
//         modal_container.classList.remove('unshow');
//         modal_container.classList.add('show');
//     });
//     closer.addEventListener('click', () => {
//         modal_container.classList.add('unshow');
//         modal_container.classList.remove('show');
//
//     });
//
// }

    const openBtn = document.getElementById("open0");
const modal_container = document.getElementById('modal_container0');
const closer = document.getElementById('closer0');
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

