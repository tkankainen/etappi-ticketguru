import React, { useState, useEffect } from 'react';
import Button from '@mui/material/Button';
import { useNavigate } from "react-router-dom";

function Lipputarkistus () {

    const [status, setStatus] = useState('');
    const [koodi, setKoodi] = useState('');
    const [lippu, setLippu] = useState('');
    const token = sessionStorage.getItem("jwt");
    const timestamp = Date.now();
    const time = (new Intl.DateTimeFormat('en-US', {year: 'numeric', month: '2-digit',day: '2-digit', hour: '2-digit', minute: '2-digit', second: '2-digit'}).format(timestamp));
    const navigate = useNavigate();

    useEffect(() => {
      if(!token) {
        navigate('/login');
      }
    });

    const haeLippu = () => {
      console.log(koodi);
      fetch(`https://etappi-ticketguru.herokuapp.com/api/liput/search/lippu?koodi=${koodi}`, {
        headers: {
          'Authorization' : token 
        },
      })
      .then(response => response.json()
      .then(responseJson => setLippu(responseJson._embedded.lippus[0]))
      .catch(error => { 
        console.log(error);
      }));
      console.log(lippu);
      setStatus('')
    }

    const vaihdaKoodi = (event) => {
      event.preventDefault();
      haeLippu(koodi);
    }

    const merkitseKaytetty = () => {
      console.log(lippu._links.self.href)
      fetch(lippu._links.self.href, { 
        method: "PATCH",
        body: JSON.stringify({"kaytetty":time}),
        headers: {
          "Content-Type": "application/json",
          'Authorization' : token 
        },
      }).then(function(response) {
      setStatus('Lippu käytetty');
        return response.text()
      }, function(error) {
        console.log(error)
      setStatus('erhe');
      })
    }

    return (
      <div>
        <br />
        <form onSubmit={vaihdaKoodi}>
          <label>
            Hae lippu (lippukoodi): 
            <input
              type="text"
              value={koodi}
              onChange={(e) => setKoodi(e.target.value)}
            />
          </label>
          <input type="submit" value="Hae" />
        </form>

        <div>
          <p>Lippukoodi {lippu.lippukoodi}</p>
          <p>Myyntihinta {lippu.hinta} €</p>
          <p>Käytetty {lippu.kaytetty}</p>
          <Button onClick={merkitseKaytetty}>
            Merkitse käytetyksi
          </Button>
        </div>
        <div><p>{status}</p></div>
      </div>
    );
}
export default Lipputarkistus;
 