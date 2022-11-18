import { useEffect, useState, useRef } from 'react';
import { AgGridReact } from 'ag-grid-react';
import { useLocation } from 'react-router-dom'

function Lipputyypit () {

    const [lipputyypit, setLipputyypit] = useState([]);
    const location = useLocation()
    const { lippuurl } = location.state
    console.log(lippuurl)

    const fetchData = () => {
        console.log(lippuurl)
        fetch(lippuurl)
        .then(response => response.json())
        .then(data => setLipputyypit(data._embedded.tapahtumalipputyyppis))
        .catch(error => console.error(error))
    }
    
    useEffect(() => {
        fetchData();
    }, []);

    const columns = [
        { headerName: "Nimi", field: "nimi", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: "Hinta", field: "hinta", sortable: true, filter: true, width: 160, resizable: true },
    ]

    const gridRef = useRef();

    return (
        <div className="ag-theme-material" style={{height: 700, margin: 'auto'}}>
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

