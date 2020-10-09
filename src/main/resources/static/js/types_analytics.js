let vaK = document.querySelector('input[name=vaK]')
let vaN = document.querySelector('input[name=vaN]')
let id = document.querySelector('input[name=id]')
let trs = document.querySelectorAll('tbody tr')
let prevBtn = document.querySelector('button[name=prev]')
let nextBtn = document.querySelector('button[name=next]')
let rowCurIndex = -1;

function fillForm() {
  if (rowCurIndex >= 0 && rowCurIndex < trs.length) {
    let ths = trs[rowCurIndex].children
    id.value = ths[0].textContent
    vaK.value = ths[1].textContent
    vaN.value = ths[2].textContent
  } else {
    id.value = ''
    vaK.value = ''
    vaN.value = ''
  }
}

trs.forEach(tr => {
  tr.addEventListener('dblclick', () => {
    let ths = tr.children
    id.value = ths[0].textContent
    vaK.value = ths[1].textContent
    vaN.value = ths[2].textContent
  })
})

prevBtn.addEventListener('click', () => {
  if (trs.length === 0) return
  rowCurIndex > 0 ? rowCurIndex-- : 0
  fillForm()
})

nextBtn.addEventListener('click', () => {
  if (trs.length === 0) return
  rowCurIndex < trs.length ? rowCurIndex++ : trs.length - 1
  fillForm()
})
