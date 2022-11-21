import React, { useState } from 'react';
import Button from '@mui/material/Button';

function Lipputarkistus () {

    const [status, setStatus] = useState('');
    const [id, setId] = useState('');
    const [lippu, setLippu] = useState('');
    const token = sessionStorage.getItem("jwt");
    const timestamp = Date.now();
    const time = (new Intl.DateTimeFormat('en-US', {year: 'numeric', month: '2-digit',day: '2-digit', hour: '2-digit', minute: '2-digit', second: '2-digit'}).format(timestamp));
    
    const haeLippu = () => {
      console.log(id);
      fetch(`https://etappi-ticketguru.herokuapp.com/api/liput/${id}`)
      .then(response => response.json()
      .then(responseJson => setLippu(responseJson))
      .catch(error => { 
        console.log(error);
      }));
      console.log(lippu);
      setStatus('')
    }

    const vaihdaId = (event) => {
      event.preventDefault();
      haeLippu(id);
    }

    const merkitseKaytetty = () => {
      fetch(`https://etappi-ticketguru.herokuapp.com/api/liput/${id}`, { 
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

      <form onSubmit={vaihdaId}>
        <label>
          Hae lippu (id): 
          <input
            type="text"
            value={id}
            onChange={(e) => setId(e.target.value)}
          />
        </label>
        <input type="submit" value="Hae" />
      </form>

      <div>
        <p>
          Lippukoodi {lippu.lippukoodi}<br />
          Myyntihinta {lippu.hinta} €<br />
          Käytetty {lippu.kaytetty}<br /><br />
          <Button onClick={merkitseKaytetty}>
            Merkitse käytetyksi
          </Button>
        </p>
      </div>
      <div><p>{status}</p></div>
    </div>
  );
}
export default Lipputarkistus;
 