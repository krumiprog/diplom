let id = document.querySelector('input[name=id]')
let ksData = document.querySelector('input[name=ksData]')
let ksDokk = document.querySelector('input[name=ksDokk]')
let ksDokn = document.querySelector('input[name=ksDokn]')
let ksTo = document.querySelector('input[name=ksTo]')
let ksDokd = document.querySelector('input[name=ksDokd]')
let ksS = document.querySelector('input[name=ksS]')
let ksSn = document.querySelector('input[name=ksSn]')
let ksKs = document.querySelector('input[name=ksKs]')
let ksKsn = document.querySelector('input[name=ksKsn]')
let ksDb = document.querySelector('input[name=ksDb]')
let ksKr = document.querySelector('input[name=ksKr]')

let trs = document.querySelectorAll('table[name=tables] tbody tr')
let prevBtn = document.querySelector('button[name=prev]')
let nextBtn = document.querySelector('button[name=next]')
let rowCurIndex = -1;

function fillForm(ths) {
    id.value = ths[0].textContent
    ksData.value = ths[1].textContent
    ksDokk.value = ths[2].textContent
    ksDokn.value = ths[3].textContent
    ksTo.value = ths[4].textContent
    ksDokd.value = ths[5].textContent
    ksS.value = ths[6].textContent
    ksSn.value = ths[7].textContent
    ksKs.value = ths[8].textContent
    ksKsn.value = ths[9].textContent
    ksDb.value = ths[10].textContent
    ksKr.value = ths[11].textContent
}

function getCellsValue() {
  if (rowCurIndex >= 0 && rowCurIndex < trs.length) {
    let ths = trs[rowCurIndex].children
    fillForm(ths);
  } else {
    id.value = ''
    ksData.value = ''
    ksDokk.value = ''
    ksDokn.value = ''
    ksTo.value = ''
    ksDokd.value = ''
    ksS.value = ''
    ksSn.value = ''
    ksKs.value = ''
    ksKsn.value = ''
    ksDb.value = ''
    ksKr.value = ''
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



