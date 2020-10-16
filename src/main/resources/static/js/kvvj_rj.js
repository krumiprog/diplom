let id = document.querySelector('input[name=id]')
let rjData = document.querySelector('input[name=rjData]')
let rjDokk = document.querySelector('input[name=rjDokk]')
let rjDokn = document.querySelector('input[name=rjDokn]')
let rjTo = document.querySelector('input[name=rjTo]')
let rjDokd = document.querySelector('input[name=rjDokd]')
let rjDb = document.querySelector('input[name=rjDb]')
let rjDbn = document.querySelector('input[name=rjDbn]')
let rjKr = document.querySelector('input[name=rjKr]')
let rjKrn = document.querySelector('input[name=rjKrn]')
let rjRub = document.querySelector('input[name=rjRub]')

let trs = document.querySelectorAll('table[name=tables] tbody tr')
let prevBtn = document.querySelector('button[name=prev]')
let nextBtn = document.querySelector('button[name=next]')
let rowCurIndex = -1;

function fillForm(ths) {
    id.value = ths[0].textContent
    rjData.value = ths[1].textContent
    rjDokk.value = ths[2].textContent
    rjDokn.value = ths[3].textContent
    rjTo.value = ths[4].textContent
    rjDokd.value = ths[5].textContent
    rjDb.value = ths[6].textContent
    rjDbn.value = ths[7].textContent
    rjKr.value = ths[8].textContent
    rjKrn.value = ths[9].textContent
    rjRub.value = ths[10].textContent
}

function getCellsValue() {
  if (rowCurIndex >= 0 && rowCurIndex < trs.length) {
    let ths = trs[rowCurIndex].children
    fillForm(ths);
  } else {
    id.value = ''
    rjData.value = ''
    rjDokk.value = ''
    rjDokn.value = ''
    rjDokd.value = ''
    rjTo.value = ''
    rjDb.value = ''
    rjDbn.value = ''
    rjKr.value = ''
    rjKrn.value = ''
    rjRub.value = ''
  }
}

trs.forEach(tr => {
  tr.addEventListener('click', () => {
    let ths = tr.children
    fillForm(ths)
  })
})

prevBtn.addEventListener('click', () => {
    if (trs.length === 0) return
    rowCurIndex > 0 ? rowCurIndex-- : 0
    getCellsValue()
})

nextBtn.addEventListener('click', () => {
    if (trs.length === 0) return
    rowCurIndex < trs.length ? rowCurIndex++ : trs.length - 1
    getCellsValue()
})



