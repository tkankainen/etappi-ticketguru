import { useEffect, useState, useRef } from 'react';
import { AgGridReact } from 'ag-grid-react';
import { useNavigate, Link } from "react-router-dom";
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-material.css';
import moment from 'moment';
import Button from '@mui/material/Button';
//import LisaaTapahtuma from './LisaaTapahtuma';
//import MuokkaaTapahtuma from './MuokkaaTapahtuma';

function Myyntitapahtumat () {

    const [tapahtumat, setTapahtumat] = useState([]);
    const navigate = useNavigate();
    const token = sessionStorage.getItem("jwt");

    useEffect(() => {
        if(!token) {
          navigate('/login');
        }
    });

    const fetchData = () => {
        fetch("https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/", {
            headers: { 'Authorization' : token }
        })
        .then(response => response.json())
        .then(data => setTapahtumat(data._embedded.myyntitapahtumas))
        .catch(error => console.error(error))
    }

    useEffect(() => {
        fetchData();
    }, []);

  

    const columns = [
        { headerName: "Aika", field: "aika", sortable: true, filter: true, width: 230, resizable: true,
            cellRenderer: params => {
                return (
                    moment(params.data.timestamp).format('LLL')
            )}
        },
       
        { headerName: '', field: "links", sortable: false, filter: false, width: 200,
            cellRenderer: params => {
                const lippuurl = params.data._links.liput.href;
             //  const myyntitapahtumaurl = params.data._links.self.href;
                return (
                    <Button><Link to="/showliput" state={{ lippuurl: lippuurl} }> Näytä liput</Link></Button>
                )}
        }
    ]

    const gridRef = useRef();

    return (
        <div className="ag-theme-material" style={{height: 700, margin: 'auto'}}>
           
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


export default Myyntitapahtumat;
