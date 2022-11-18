import React, { useState, useEffect  } from 'react';

function NaytaLiput () {

  const [taulukko, setTaulukko] = useState( [] );
  const [virhe, setVirhe] = useState('Haetaan ...');
 

  const fetchUrl = async () => {
    try {
      const response = await fetch('https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/86/liput');
      const json = await response.json();
      //setLippukoodi(response.data._embedded.lippus[0].lippukoodi);
      setTaulukko(json._embedded.lippus);
      setVirhe('');
    } catch (error) {
      setVirhe('Tietojen haku ei onnistunut');
    }
  }

  useEffect(() => {
    fetchUrl();
  }, []);

  if (taulukko.length === 0) {
    return <div>{ virhe }</div>
  }

  return (
    <div>
    {
      taulukko.map(ticket=> {
        return (
          <div key={ticket.lippukoodi }>
          { ticket.lippukoodi }
          </div>
        )
      })
    }
    </div>
  )
}
export default NaytaLiput;
 