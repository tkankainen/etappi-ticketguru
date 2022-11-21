import { useEffect, useState, useRef } from 'react';
import { AgGridReact } from 'ag-grid-react';
import { useLocation } from 'react-router-dom'
import LisaaLipputyyppi from './LisaaLipputyyppi';

function Lipputyypit () {

    const [lipputyypit, setLipputyypit] = useState([]);
    const location = useLocation()
    const { lippuurl } = location.state
    const { tapahtumaurl } = location.state
    const token = sessionStorage.getItem("jwt");

    const fetchData = () => {
        console.log(lippuurl)
        console.log(tapahtumaurl)
        fetch(lippuurl)
        .then(response => response.json())
        .then(data => setLipputyypit(data._embedded.tapahtumalipputyyppis))
        .catch(error => console.error(error))
    }
    
    useEffect(() => {
        fetchData();
    }, []);

    const tallennaLipputyyppi = (lipputyyppi) => {
        fetch("https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization' : token 
            },
            body: JSON.stringify(lipputyyppi)
        })
        .then(res => fetchData())
        .catch(error => console.error(error))
    }

    const columns = [
        { headerName: "Nimi", field: "nimi", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: "Hinta", field: "hinta", sortable: true, filter: true, width: 160, resizable: true },
    ]

    const gridRef = useRef();

    return (
        <div className="ag-theme-material" style={{height: 700, margin: 'auto'}}>
        <LisaaLipputyyppi 
            tallennaLipputyyppi={tallennaLipputyyppi}
            tapahtumaurl={tapahtumaurl}
        />
        <AgGridReact
            ref={gridRef}
            onGridReady={ params => gridRef.current= params.api }
            rowSelection="single"
            columnDefs={columns}
            rowData={lipputyypit}>
        </AgGridReact>
    </div>
    )
}

export default Lipputyypit;

