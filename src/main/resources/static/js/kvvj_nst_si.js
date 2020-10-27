let id = document.querySelector('input[name=id]')
let nstDatas = document.querySelector('input[name=nstDatas]')
let nstDatad = document.querySelector('input[name=nstDatad]')
let nstS = document.querySelector('input[name=nstS]')
let nstSn = document.querySelector('input[name=nstSn]')
let charts = document.querySelectorAll('table[name=documents] tbody tr')

charts.forEach(tr => {
    tr.addEventListener('click', () => {
        let ths = tr.children
        nstS.value = ths[0].textContent
        nstSn.value = ths[1].textContent
    })
})
