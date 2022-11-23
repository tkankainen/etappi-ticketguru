import { useEffect, useState, useRef } from 'react';
import { AgGridReact } from 'ag-grid-react';
import { useNavigate, Link } from "react-router-dom";
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-material.css';
import moment from 'moment';
import Button from '@mui/material/Button';
import LisaaTapahtuma from './LisaaTapahtuma';
import MuokkaaTapahtuma from './MuokkaaTapahtuma';

function Tapahtumat () {

    const [tapahtumat, setTapahtumat] = useState([]);
    const navigate = useNavigate();
    const token = sessionStorage.getItem("jwt");

    useEffect(() => {
        if(!token) {
          navigate('/login');
        }
    });

    const fetchData = () => {
        fetch("https://etappi-ticketguru.herokuapp.com/api/tapahtumat/", {
            headers: { 'Authorization' : token }
        })
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
                'Content-Type': 'application/json',
                'Authorization' : token
            },
            body: JSON.stringify(tapahtuma)
        })
        .then(res => fetchData())
        .catch(error => console.error(error))
    }

    const poistaTapahtuma = (url) => {
        console.log("Delete", url)
        if (window.confirm('Haluatko varmasti poistaa tapahtuman?')) {
            fetch(url, {
                method: 'DELETE',
                headers: {
                    'Authorization' : token
                }
            })
            .then(res => fetchData())
            .catch(error => console.error(error))
        }
    }

    const muokkaaTapahtuma = (tapahtuma, url) => {
        fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'Authorization' : token
        },
        body: JSON.stringify(tapahtuma)
        })
        .then(res => fetchData())
        .catch(error => console.error(error))
    }

    const columns = [
        { headerName: "Aika", field: "aika", sortable: true, filter: true, width: 230, resizable: true,
            cellRenderer: params => {
                return (
                    moment(params.data.aika).format('LLL')
            )}
        },
        { headerName: "Nimi", field: "nimi", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: "Osoite", field: "osoite", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: "Kaupunki", field: "kaupunki", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: "Lippumäärä", field: "kpl", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: "Myynti loppuu", field: "loppupvm", sortable: true, filter: true, width: 160, resizable: true },
        { headerName: '', field: "links", sortable: false, filter: false, width: 120,
            cellRenderer: params => {
                const tapahtumaurl = params.data._links.self.href;
                return (
                    <MuokkaaTapahtuma muokkaaTapahtuma={muokkaaTapahtuma} tiedot={params} tapahtumaurl={tapahtumaurl} />
                )
            }
        },
        { headerName: '', field: "links", sortable: false, filter: false, width: 90,
            cellRenderer: params => {
                const url = params.data._links.self.href;
                return (
                    <Button onClick={() => poistaTapahtuma(url)}>Poista</Button>
                )}
        },
        { headerName: '', field: "links", sortable: false, filter: false, width: 200,
            cellRenderer: params => {
                const lippuurl = params.data._links.tapahtumalipputyypit.href;
                const tapahtumaurl = params.data._links.tapahtuma.href;
                return (
                    <Button><Link to="/lipputyypit" state={{ lippuurl: lippuurl, tapahtumaurl: tapahtumaurl }}>Lipputyypit</Link></Button>
                )}
        }
    ]

    const gridRef = useRef();

    return (
        <div className="ag-theme-material" style={{height: 700, margin: 'auto'}}>
            <LisaaTapahtuma tallennaTapahtuma={tallennaTapahtuma}/>
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
