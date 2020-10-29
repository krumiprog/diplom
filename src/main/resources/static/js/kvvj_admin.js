let id = document.querySelector('input[name=id]')
let username = document.querySelector('input[name=username]')
let roles = document.querySelectorAll('input[name=roles]')
let trs = document.querySelectorAll('tbody tr')
let prevBtn = document.querySelector('button[name=prev]')
let nextBtn = document.querySelector('button[name=next]')
let rowCurIndex = -1;

function fillForm(ths) {
    id.value = ths[0].textContent
    username.value = ths[1].textContent
    roles[0].checked = ths[2].textContent.includes('USER') ? true : false;
    roles[1].checked = ths[2].textContent.includes('ADMIN') ? true : false;
}

function getCellsValue() {
  if (rowCurIndex >= 0 && rowCurIndex < trs.length) {
    let ths = trs[rowCurIndex].children
    fillForm(ths)
  } else {
    id.value = ''
    username.value = ''
    roles[0].checked = false
    roles[1].checked = false
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


console.log(roles.length)
console.log(roles)