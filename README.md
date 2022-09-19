# TicketGuru - Team Etappi

Tiimi: Anne Pelin, Elia Ahonen, Pertti Korhonen, Taina Kankainen

Lähde dokumentaatiopohjalle: [https://github.com/mruonavaara/projektikurssi/blob/master/README.md](https://github.com/mruonavaara/projektikurssi/blob/master/README.md)

## Johdanto

-   Projektina on myyntipisteen lipunmyyntijärjestelmä, alustavalta nimeltä TicketGuru, joka toteutetaan lipputoimisto asiakkaalle (edustajana tuoteomistaja Markku Ruonavaara). Projektissa rakennetaan lipunmyyntijärjestelmä lipunmyyntipisteen myyjille - kyseessä ei siis ole verkkoalusta, josta asiakas voi itse käydä ostamassa lipun. Järjestelmässä tulee voida käsitellä tapahtumia, joihin lippuja myydään, myydä lippuja ja tulostaa niitä, sekä seurata myyntiä.
-   Toteutus- ja toimintaympäristö lyhyesti:  
    -   REST-palvelu ja tietokanta, sisältäen CRUD-toiminnallisuudet järjestelmän sisältämille tiedoille, sekä osittaisen käyttäjän tunnistautumistarpeen
    -   Päätelaitteina laptop/desktop, palvelu toteutetaan Javalla Spring Boot -kehyksen avulla ja tulokset talletetaan GitHubiin

## Järjestelmän määrittely

### Roolit
- lipputoimiston työntekijä
- lipunmyyntipisteen lipunmyyjä

### Käyttötapauskaavio

![Käyttötapauskaavio](https://user-images.githubusercontent.com/26714675/189474583-b87517c1-8dac-44b6-a1ca-30b5f6401ed8.jpg)

### Käyttäjätarinat
##### Tunnus: K1
Lipputoimiston työntekijänä haluan, että voin luoda myynnissä olevat tapahtumat,
koska lipunmyyntipisteen myyjän pitää pystyä myymään lippuja tiettyyn tapahtumaan.
prioriteetti = 1, tyyppi: toiminnallinen
##### Tunnus: K2
Lipputoimiston työntekijänä haluan pystyä muuttamaan tapahtuman tietoja, koska on mahdollista, että ohjelmassa olevaa tietoa pitää ajantasaistaa
prioriteetti = 1, tyyppi: toiminnallinen
##### Tunnus: K3 
Lipputoimiston työntekijänä haluan, että voin määritellä tapahtuman lipputyypit, 
koska tapahtumaan pitää pystyä myymään lippuja eri asiakastyypeille.
prioriteetti = 1, tyyppi: toiminnallinen
##### Tunnus: K4 
Lipputoimiston työntekijänä haluan, että voin määritellä lipputyyppien hinnan tapahtumittain, 
koska pitää pystyä myymään eri hintaisia lippuja eri asiakastyypeille.
prioriteetti = 1, tyyppi: toiminnallinen
##### Tunnus: K5
Lipunmyyjänä haluan, että voin hakea tapahtumia eri hakusanoilla, koska asiakkaalle pitää voida myydä lippu hänen haluamaansa tapahtumaan
prioriteetti = 1, tyyppi: toiminnallinen
##### Tunnus: K6
Lipunmyyjänä haluan, että voin myydä lipun tiettyyn tapahtumaan, koska asiakkaalle pitää voida myydä lippu hänen haluamaansa tapahtumaan
prioriteetti = 1, tyyppi: toiminnallinen
##### Tunnus: K7
Lipunmyyjänä haluan nähdä tapahtuman jäljellä olevien lippujen määrän, jotta lippuja ei myydä tapahtumaan liikaa
prioriteetti = 1, tyyppi: toiminnallinen
###### Tunnus: K8
Lipunmyyjänä haluan pystyä myymään useita lippuja samalla tilauksella, jotta jokaista lippua ei tarvitse myydä erikseen
prioriteetti = 1, tyyppi: toiminnallinen
##### Tunnus: K9
Lipunmyyjänä haluan, että voin tulostaa lippuja, koska asiakkaalle pitää tulostaa ostettu lippu 
prioriteetti = 1, Tyyppi: toiminnallinen
##### Tunnus: K10
Lipunmyyjänä haluan, että voin tulostaa myymättä jääneet liput, koska liput pitää olla myytävissä tapahtuman ovella.
prioriteetti = 1, tyyppi: toiminnallinen
##### Tunnus: K11
Käyttäjätarina:
Lipputoimiston työntekijänä haluan nähdä raportin tapahtumaan myydyistä ja myymättömistä lipuista, jotta voin seurata myyntiä
prioriteetti = 2, tyyppi: toiminnallinen


## Käyttöliittymä

[Wireframe-malli](https://github.com/tkankainen/etappi-ticketguru/blob/development/Kuvat/TicketGuru%20UI.pdf) kuvaa alustavasti käyttöliittymän toimintoja.

## Tietokanta

![Tietokantakaavio](Kuvat/tietokantakaavio.jpeg)

Lisäksi kukin järjestelmän tietoelementti ja sen attribuutit kuvataan
tietohakemistossa. Tietohakemisto tarkoittaa yksinkertaisesti vain jokaisen elementin (taulun) ja niiden
attribuuttien (kentät/sarakkeet) listausta ja lyhyttä kuvausta esim. tähän tyyliin:

> ### _Tilit_
> _Tilit-taulu sisältää käyttäjätilit. Käyttäjällä voi olla monta tiliä. Tili kuuluu aina vain yhdelle käyttäjälle._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> id | int PK | Tilin id
> nimimerkki | varchar(30) |  Tilin nimimerkki
> avatar | int FK | Tilin avatar, viittaus [avatar](#Avatar)-tauluun
> kayttaja | int FK | Viittaus käyttäjään [käyttäjä](#Kayttaja)-taulussa

## Tekninen kuvaus

Teknisessä kuvauksessa esitetään järjestelmän toteutuksen suunnittelussa tehdyt tekniset
ratkaisut, esim.

-   Missä mikäkin järjestelmän komponentti ajetaan (tietokone, palvelinohjelma)
    ja komponenttien väliset yhteydet (vaikkapa tähän tyyliin:
    https://security.ufl.edu/it-workers/risk-assessment/creating-an-information-systemdata-flow-diagram/)
-   Palvelintoteutuksen yleiskuvaus: teknologiat, deployment-ratkaisut yms.
-   Keskeisten rajapintojen kuvaukset, esimerkit REST-rajapinta. Tarvittaessa voidaan rajapinnan käyttöä täsmentää
    UML-sekvenssikaavioilla.
-   Toteutuksen yleisiä ratkaisuja, esim. turvallisuus.

Tämän lisäksi

-   ohjelmakoodin tulee olla kommentoitua
-   luokkien, metodien ja muuttujien tulee olla kuvaavasti nimettyjä ja noudattaa
    johdonmukaisia nimeämiskäytäntöjä
-   ohjelmiston pitää olla organisoitu komponentteihin niin, että turhalta toistolta
    vältytään

## Testaus

Tässä kohdin selvitetään, miten ohjelmiston oikea toiminta varmistetaan
testaamalla projektin aikana: millaisia testauksia tehdään ja missä vaiheessa.
Testauksen tarkemmat sisällöt ja testisuoritusten tulosten raportit kirjataan
erillisiin dokumentteihin.

Tänne kirjataan myös lopuksi järjestelmän tunnetut ongelmat, joita ei ole korjattu.

## Asennustiedot

Järjestelmän asennus on syytä dokumentoida kahdesta näkökulmasta:

-   järjestelmän kehitysympäristö: miten järjestelmän kehitysympäristön saisi
    rakennettua johonkin toiseen koneeseen

-   järjestelmän asentaminen tuotantoympäristöön: miten järjestelmän saisi
    asennettua johonkin uuteen ympäristöön.

Asennusohjeesta tulisi ainakin käydä ilmi, miten käytettävä tietokanta ja
käyttäjät tulee ohjelmistoa asentaessa määritellä (käytettävä tietokanta,
käyttäjätunnus, salasana, tietokannan luonti yms.).

## Käynnistys- ja käyttöohje

Tyypillisesti tässä riittää kertoa ohjelman käynnistykseen tarvittava URL sekä
mahdolliset kirjautumiseen tarvittavat tunnukset. Jos järjestelmän
käynnistämiseen tai käyttöön liittyy joitain muita toimenpiteitä tai toimintajärjestykseen liittyviä asioita, nekin kerrotaan tässä yhteydessä.

Usko tai älä, tulet tarvitsemaan tätä itsekin, kun tauon jälkeen palaat
järjestelmän pariin !
