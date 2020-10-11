let id = document.querySelector('input[name=id]')
let txoDokk = document.querySelector('select[name=txoDokk]')
let txoK = document.querySelector('input[name=txoK]')
let txoDb = document.querySelector('input[name=txoDb]')
let txoDbn = document.querySelector('input[name=txoDbn]')
let txoKr = document.querySelector('input[name=txoKr]')
let txoKrn = document.querySelector('input[name=txoKrn]')
let trsDebet = document.querySelectorAll('table[name=debet] tr')
let trsCredit = document.querySelectorAll('table[name=credit] tr')
let trs = document.querySelectorAll('table[name=tables] tbody tr')
let prevBtn = document.querySelector('button[name=prev]')
let nextBtn = document.querySelector('button[name=next]')
let rowCurIndex = -1;

function fillForm(ths) {
    id.value = ths[0].textContent
    txoDokk.value = ths[1].textContent
    txoK.value = ths[2].textContent
    txoDb.value = ths[3].textContent
    txoDbn.value = ths[4].textContent
    txoKr.value = ths[5].textContent
    txoKrn.value = ths[6].textContent
}

function getCellsValue() {
  if (rowCurIndex >= 0 && rowCurIndex < trs.length) {
    let ths = trs[rowCurIndex].children
    fillForm(ths);
  } else {
    id.value = ''
    txoDokk.value = ''
    txoK.value = ''
    txoDb.value = ''
    txoDbn.value = ''
    txoKr.value = ''
    txoKrn.value = ''
  }
}

trsDebet.forEach(tr => {
    tr.addEventListener('click', () => {
        let ths = tr.children
        txoDb.value = ths[0].textContent
        txoDbn.value = ths[1].textContent
    })
})

trsCredit.forEach(tr => {
    tr.addEventListener('click', () => {
        let ths = tr.children
        txoKr.value = ths[0].textContent
        txoKrn.value = ths[1].textContent
    })
})

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