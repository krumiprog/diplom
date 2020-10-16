let id = document.querySelector('input[name=id]')
let gpdDokk = document.querySelector('input[name=pdDokk]')
let pdDokn = document.querySelector('input[name=pdDokn]')
let pdDokd = document.querySelector('input[name=pdDokd]')
let pdAv1 = document.querySelector('input[name=pdAv1]')
let pdAvt1 = document.querySelector('input[name=pdAvt1]')
let pdAk1 = document.querySelector('select[name=pdAk1]')
let pdAv2 = document.querySelector('input[name=pdAv2]')
let pdAvt2 = document.querySelector('input[name=pdAvt2]')
let pdAk2 = document.querySelector('select[name=pdAk2]')
let pdAv3 = document.querySelector('input[name=pdAv3]')
let pdAvt3 = document.querySelector('input[name=pdAvt3]')
let pdAk3 = document.querySelector('select[name=pdAk3]')
let pdRub = document.querySelector('input[name=pdRub]')
let pdTo = document.querySelector('input[name=pdTo]')
let pdDb = document.querySelector('input[name=pdDb]')
let pdDbn = document.querySelector('input[name=pdDbn]')
let pdKr = document.querySelector('input[name=pdKr]')
let pdKrn = document.querySelector('input[name=pdKrn]')
let trsDocs = document.querySelectorAll('table[name=documents] tr')
let trsOpers = document.querySelectorAll('table[name=operations] tr')
let trs = document.querySelectorAll('table[name=tables] tbody tr')
let prevBtn = document.querySelector('button[name=prev]')
let nextBtn = document.querySelector('button[name=next]')
let rowCurIndex = -1;



function watchRj() {
    registrationBook = {
//        id: null,
        rjData: "2020-11-11",
        rjDokk: gpdDokk.value,
        rjDokn: parseInt(pdDokn.value),
        rjDokd: pdDokd.value,
        rjTo: pdTo.value,
        rjDb: parseInt(pdDb.value),
        rjDbn: pdDbn.value,
        rjKr: parseInt(pdKr.value),
        rjKrn: pdKrn.value,
        rjRub: parseInt(pdRub.value)
    }

    console.log(registrationBook)
    console.log(JSON.stringify(registrationBook))

    fetch("/rest/kvvj_rj", {
        method: 'POST',
        body: JSON.stringify(registrationBook),
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        }
//        credentials: 'include',
    }).then(response => console.log("Response status: ", response.status));
}

function cleanRj() {
    let hello = 'Hello, world!'

    console.log(hello)
    console.log(JSON.stringify(hello))

    fetch("/rest/kvvj_rj/hello", {
        method: 'POST',
        body: JSON.stringify(hello),
        headers: {
           'Content-type': 'application/json; charset=UTF-8'
        }
//        credentials: 'include'
    }).then(response => console.log('STATUS: ', response.status))
}



function fillForm(ths) {
    id.value = ths[0].textContent
    gpdDokk.value = ths[1].textContent
    pdDokn.value = ths[2].textContent
    pdDokd.value = ths[3].textContent
    pdAv1.value = ths[4].textContent
    pdAvt1.value = ths[5].textContent
    pdAk1.value = ths[6].textContent
    pdAv2.value = ths[7].textContent
    pdAvt2.value = ths[8].textContent
    pdAk2.value = ths[9].textContent
    pdAv3.value = ths[10].textContent
    pdAvt3.value = ths[11].textContent
    pdAk3.value = ths[12].textContent
    pdRub.value = ths[13].textContent
    pdTo.value = ths[14].textContent
    pdDb.value = ths[15].textContent
    pdDbn.value = ths[16].textContent
    pdKr.value = ths[17].textContent
    pdKrn.value = ths[18].textContent
}

function getCellsValue() {
  if (rowCurIndex >= 0 && rowCurIndex < trs.length) {
    let ths = trs[rowCurIndex].children
    fillForm(ths);
  } else {
    id.value = ''
    gpdDokk.value = ''
    pdDokn.value = ''
    pdDokd.value = ''
    pdAv1.value = ''
    pdAvt1.value = ''
    pdAk1.value = ''
    pdAv2.value = ''
    pdAvt2.value = ''
    pdAk2.value = ''
    pdAv3.value = ''
    pdAvt3.value = ''
    pdAk3.value = ''
    pdRub.value = ''
    pdTo.value = ''
    pdDb.value = ''
    pdDbn.value = ''
    pdKr.value = ''
    pdKrn.value = ''
  }
}

trsDocs.forEach(tr => {
    tr.addEventListener('click', () => {
        let ths = tr.children
        pdDokk.value = ths[0].textContent
        pdAv1.value = ths[1].textContent
        pdAvt1.value = ths[2].textContent
        pdAv2.value = ths[3].textContent
        pdAvt2.value = ths[4].textContent
        pdAv3.value = ths[5].textContent
        pdAvt3.value = ths[6].textContent
    })
})

trsOpers.forEach(tr => {
    tr.addEventListener('click', () => {
        let ths = tr.children
        pdTo.value = ths[0].textContent
        pdDb.value = ths[1].textContent
        pdDbn.value = ths[2].textContent
        pdKr.value = ths[3].textContent
        pdKrn.value = ths[4].textContent
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



