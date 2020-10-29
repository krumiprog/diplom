let id = document.querySelector('input[name=id]')
let pdDokk = document.querySelector('input[name=pdDokk]')
let pdDokn = document.querySelector('input[name=pdDokn]')
let pdDokd = document.querySelector('input[name=pdDokd]')
let pdAv1 = document.querySelector('input[name=pdAv1]')
let pdAvt1 = document.querySelector('input[name=pdAvt1]')
let pdAk1 = document.querySelector('input[name=pdAk1]')
let pdAv2 = document.querySelector('input[name=pdAv2]')
let pdAvt2 = document.querySelector('input[name=pdAvt2]')
let pdAk2 = document.querySelector('input[name=pdAk2]')
let pdAv3 = document.querySelector('input[name=pdAv3]')
let pdAvt3 = document.querySelector('input[name=pdAvt3]')
let pdAk3 = document.querySelector('input[name=pdAk3]')
let pdRub = document.querySelector('input[name=pdRub]')
let pdTo = document.querySelector('input[name=pdTo]')
let pdDb = document.querySelector('input[name=pdDb]')
let pdDbn = document.querySelector('input[name=pdDbn]')
let pdKr = document.querySelector('input[name=pdKr]')
let pdKrn = document.querySelector('input[name=pdKrn]')

let trsDocs = document.querySelectorAll('table[name=documents] tbody tr')
let trsAn1 = document.querySelectorAll('table[name=analytics1] tbody tr')
let trsAn2 = document.querySelectorAll('table[name=analytics2] tbody tr')
let trsAn3 = document.querySelectorAll('table[name=analytics3] tbody tr')
let trsOpers = document.querySelectorAll('table[name=operations] tbody tr')
let trs = document.querySelectorAll('table[name=tables] tbody tr')
let prevBtn = document.querySelector('button[name=prev]')
let nextBtn = document.querySelector('button[name=next]')
let rowCurIndex = -1;

function sendRj() {
    registrationBook = {
        rjDokk: pdDokk.value,
        rjDokn: parseInt(pdDokn.value),
        rjDokd: pdDokd.value,
        rjTo: pdTo.value,
        rjDb: parseInt(pdDb.value),
        rjDbn: pdDbn.value,
        rjKr: parseInt(pdKr.value),
        rjKrn: pdKrn.value,
        rjRub: parseInt(pdRub.value)
    }

    fetch("/rest/kvvj_rj", {
        method: 'POST',
        body: JSON.stringify(registrationBook),
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        }
    }).then(response => console.log("Response status: ", response.status));
}

function deleteRj() {
    fetch("/rest/kvvj_rj", {
        method: 'DELETE',
    }).then(response => console.log('STATUS: ', response.status))
}

function fillForm(ths) {
    id.value = ths[0].textContent
    pdDokk.value = ths[1].textContent
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
    pdDokk.value = ''
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

        const e = new Event('change')
        pdAv1.dispatchEvent(e)
        pdAv2.dispatchEvent(e)
        pdAv3.dispatchEvent(e)
    })
})

trsAn1.forEach(tr => {
    tr.addEventListener('click', () => {
        let ths = tr.children
        pdAk1.value = ths[1].textContent
    })
})

trsAn2.forEach(tr => {
    tr.addEventListener('click', () => {
        let ths = tr.children
        pdAk2.value = ths[1].textContent
    })
})

trsAn3.forEach(tr => {
    tr.addEventListener('click', () => {
        let ths = tr.children
        pdAk3.value = ths[1].textContent
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

pdAv1.addEventListener('change', () => {
    trsAn1.forEach(tr => {
        tr.style.display = 'table-row'
        let ths = tr.children
        if (ths[0].textContent != pdAv1.value) {
            tr.style.display = 'none'
        }
    })
    pdAk1.value = ''
})

pdAv2.addEventListener('change', () => {
    trsAn2.forEach(tr => {
        tr.style.display = 'table-row'
        let ths = tr.children
        if (ths[0].textContent != pdAv2.value) {
            tr.style.display = 'none'
        }
    })
    pdAk2.value = ''
})

pdAv3.addEventListener('change', () => {
    trsAn3.forEach(tr => {
        tr.style.display = 'table-row'
        let ths = tr.children
        if (ths[0].textContent != pdAv3.value) {
            tr.style.display = 'none'
        }
    })
    pdAk3.value = ''
})

prevBtn.addEventListener('click', () => {
    if (trs.length === 0) return
    rowCurIndex > 0 ? rowCurIndex-- : 0
    getCellsValue()

    const e = new Event('change')
    pdAv1.dispatchEvent(e)
    pdAv2.dispatchEvent(e)
    pdAv3.dispatchEvent(e)
})

nextBtn.addEventListener('click', () => {
    if (trs.length === 0) return
    rowCurIndex < trs.length ? rowCurIndex++ : trs.length - 1
    getCellsValue()

    const e = new Event('change')
    pdAv1.dispatchEvent(e)
    pdAv2.dispatchEvent(e)
    pdAv3.dispatchEvent(e)
})



