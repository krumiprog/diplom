let id = document.querySelector('input[name=id]')
let opdK = document.querySelector('input[name=opdK]')
let opdN = document.querySelector('input[name=opdN]')
let opdAv1 = document.querySelector('select[name=opdAv1]')
let opdAvt1 = document.querySelector('select[name=opdAvt1]')
let opdAv2 = document.querySelector('select[name=opdAv2]')
let opdAvt2 = document.querySelector('select[name=opdAvt2]')
let opdAv3 = document.querySelector('select[name=opdAv3]')
let opdAvt3 = document.querySelector('select[name=opdAvt3]')
let trs = document.querySelectorAll('tbody tr')
let prevBtn = document.querySelector('button[name=prev]')
let nextBtn = document.querySelector('button[name=next]')
let rowCurIndex = -1;

function fillForm(ths) {
    id.value = ths[0].textContent
    opdK.value = ths[1].textContent
    opdN.value = ths[2].textContent
    opdAv1.value = ths[3].textContent
    opdAvt1.value = ths[4].textContent
    opdAv2.value = ths[5].textContent
    opdAvt2.value = ths[6].textContent
    opdAv3.value = ths[7].textContent
    opdAvt3.value = ths[8].textContent
}

function getCellsValue() {
  if (rowCurIndex >= 0 && rowCurIndex < trs.length) {
    let ths = trs[rowCurIndex].children
    fillForm(ths);
  } else {
    id.value = ''
    opdK.value = ''
    opdN.value = ''
    opdAv1.value = ''
    opdAvt1.value = ''
    opdAv2.value = ''
    opdAvt2.value = ''
    opdAv3.value = ''
    opdAvt3.value = ''
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