let id = document.querySelector('input[name=id]')
let psS = document.querySelector('input[name=psS]')
let psN = document.querySelector('input[name=psN]')
let psTyp = document.querySelector('select[name=psTyp]')
let psAv1 = document.querySelector('select[name=psAv1]')
let psAv2 = document.querySelector('select[name=psAv2]')
let trs = document.querySelectorAll('tbody tr')
let prevBtn = document.querySelector('button[name=prev]')
let nextBtn = document.querySelector('button[name=next]')
let rowCurIndex = -1;

function fillForm(ths) {
    id.value = ths[0].textContent
    psS.value = ths[1].textContent
    psN.value = ths[2].textContent
    psTyp.value = ths[3].textContent
    psAv1.value = ths[4].textContent
    psAv2.value = ths[5].textContent
}

function getCellsValue() {
  if (rowCurIndex >= 0 && rowCurIndex < trs.length) {
    let ths = trs[rowCurIndex].children
    fillForm(ths)
  } else {
    id.value = ''
    psS.value = ''
    psN.value = ''
    psTyp.value = ''
    psAv1.value = ''
    psAv2.value = ''
  }
}

trs.forEach(tr => {
  tr.addEventListener('dblclick', () => {
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