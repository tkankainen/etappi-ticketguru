import { useEffect, useState, useRef } from 'react';
import { AgGridReact } from 'ag-grid-react';
import { useLocation } from 'react-router-dom';
import Button from '@mui/material/Button';
//import LisaaLipputyyppi from './LisaaLipputyyppi';


function Liput () {

    const [liput, setLiput] = useState([]);
    const [lipputyyppi, setLipputyyppi] = useState([]);
    const location = useLocation()
    const { lippuurl } = location.state
    const token = sessionStorage.getItem("jwt");
   
  

    const fetchData = () => {
        console.log(lippuurl)
        
        fetch(lippuurl, {
            headers: { 'Authorization' : token }
        })
        .then(response => response.json())
        .then(data => setLiput(data._embedded.lippus))
        
        .catch(error => console.error(error))
    }
    
  
       

    useEffect(() => {
        fetchData();
    }, []);

     

    const columns = [
        { headerName: "Lippukoodi", field: "lippukoodi", sortable: true, filter: true, width: 350, resizable: true },
        { headerName: "Hinta", field: "hinta", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: '', field: "links", sortable: false, filter: false, width: 90,
            cellRenderer: params => {
               // const myurl = params.data._links.myyntitapahtuma.href;
                }
        },
       
    ]

    const gridRef = useRef();

    return (
        <div className="ag-theme-material" style={{height: 700, margin: 'auto'}}>
            
        <AgGridReact
            ref={gridRef}
            onGridReady={ params => gridRef.current= params.api }
            rowSelection="single"
            columnDefs={columns}
            rowData={liput}>
        </AgGridReact>
    </div>
    )
}

export default Liput;

