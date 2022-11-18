import { useEffect, useState, useRef } from 'react';
import { AgGridReact } from 'ag-grid-react';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-material.css';
import Button from '@mui/material/Button';
import LisaaTapahtuma from './LisaaTapahtuma';

function Tapahtumat () {

    const [tapahtumat, setTapahtumat] = useState([]);

    const fetchData = () => {
        fetch("https://etappi-ticketguru.herokuapp.com/api/tapahtumat/")
        .then(response => response.json())
        .then(data => setTapahtumat(data._embedded.tapahtumas))
        .catch(error => console.error(error))
    }

    useEffect(() => {
        fetchData();
    }, []);

    const tallennaTapahtuma = (tapahtuma) => {
        fetch("https://etappi-ticketguru.herokuapp.com/api/tapahtumat/", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(tapahtuma)
        })
        .then(res => fetchData())
        .catch(error => console.error(error))
    }

    const poistaTapahtuma = (url) => {
        console.log("Delete", url)
        if (window.confirm('Haluatko varmasti poistaa tapahtuman?')) {
            fetch(url, {method: 'DELETE'})
            .then(res => fetchData())
            .catch(error => console.error(error))
        }
    }

    const columns = [
        { headerName: "Aika", field: "aika", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: "Nimi", field: "nimi", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: "Osoite", field: "osoite", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: "Kaupunki", field: "kaupunki", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: "Lippumäärä", field: "kpl", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: "Loppupvm", field: "loppupvm", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: '', field: "links", sortable: false, filter: false, width: 90,
            cellRendererFramework: params => {
                const url = params.data._links.self.href;
                return (
                    <Button onClick={() => poistaTapahtuma(url)}>Poista</Button>
                )}
        },
    ]

    const gridRef = useRef();

    return (
        <div className="ag-theme-material" style={{height: 700, margin: 'auto'}}>
            <LisaaTapahtuma tallennaapahtuma={tallennaTapahtuma}/>
            <AgGridReact
                ref={gridRef}
                onGridReady={ params => gridRef.current= params.api }
                rowSelection="single"
                columnDefs={columns}
                rowData={tapahtumat}>
            </AgGridReact>
        </div>
    )
}

export default Tapahtumat;